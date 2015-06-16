package model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless(name="oFacade")
public class OrderFacade {
	@PersistenceContext(unitName= "unit-progetto-siw")
	private EntityManager em;

	public Order createOrder(Customer c){
		Customer managedCustomer;
		managedCustomer = em.find(Customer.class,c.getFc());
		Order o= new Order(managedCustomer);
		this.em.persist(o);
		return o;
	}

	public void confirmOrder(Order o){
		Order orderToPersist;
		Customer cToPersist;
		cToPersist=this.em.find(Customer.class, o.getCustomer().getFc());
		orderToPersist=this.em.find(Order.class, o.getId());
		orderToPersist.setState("closed");
		Calendar calendar = new GregorianCalendar();
		Date newDate = calendar.getTime();
		orderToPersist.setClosingOrderDate(newDate);
		this.em.refresh(orderToPersist);
		cToPersist.getOrders().add(orderToPersist);
		this.em.persist(cToPersist);


	}

	public boolean iCanEvadeOrder(Order o){
		boolean right = true;
		Iterator <OrderLine> it = o.getOrderLines().iterator();
		while(it.hasNext()&& right){
			OrderLine orderLine = it.next();
			if(orderLine.getQuantity()>orderLine.getProductDescription().getQuantity())
				right = false;
		}

		return right;
	}
	
	
	public List<Order> getOrders() {
		List<Order> orders;
		try {
		orders= this.em.createQuery("SELECT o FROM Order o").getResultList();
		} catch (
		NoResultException e){
		orders=null;
		} return orders;
		}



	public Order evadeOrder(Order o){
		Calendar calendar = new GregorianCalendar();
		Date newDate = calendar.getTime();
		o.setConsignmentOrderDate(newDate);
		o.setState("evaso");
		for(OrderLine orderLine:o.getOrderLines()){
			ProductDescription pd = orderLine.getProductDescription();
			pd.setQuantity(pd.getQuantity()-orderLine.getQuantity());
			List <Product> products = pd.getProducts();
			Iterator <Product> it = products.iterator();
			int i=0;
			while(i<orderLine.getQuantity()){
				Product p = it.next();
				Product productManaged =em.find(Product.class,p.getId());
				em.remove(productManaged);
				i++;}
			ProductDescription productDescriptionManaged = em.find(ProductDescription.class,pd.getCode());
			em.refresh(productDescriptionManaged);
			}
		em.persist(o);
		return o;	
		}








	public List<Order> getClosedOrders(){
		List<Order> listOrders;
		try {
			listOrders =  em.createNamedQuery("getClosedOrders").setParameter("state", "closed").getResultList();
		}
		catch (NoResultException e){
			listOrders=null;
		}

		return listOrders;
	}
	public String details(){
		return "orderDetails";
	}

	public Double getTotal(Order currentOrder) {
		return currentOrder.getTotal();
	}

	public void deleteCurrentOrder(Order currentOrder) {
		Order orderToDelete=this.em.find(Order.class, currentOrder.getId());
		this.em.remove(orderToDelete);

	}

	public Order getOrder(Long id){
		return em.find(Order.class,id);
	}
}
