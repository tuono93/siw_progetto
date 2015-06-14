package model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

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

	public Double getTotal(Order currentOrder) {
		return currentOrder.getTotal();
	}

	public void deleteCurrentOrder(Order currentOrder) {
		Order orderToDelete=this.em.find(Order.class, currentOrder.getId());
		this.em.remove(orderToDelete);
		
	}
}
