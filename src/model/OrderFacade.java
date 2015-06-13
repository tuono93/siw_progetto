package model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name="oFacade")
public class OrderFacade {
	@PersistenceContext(unitName= "unit-progetto-siw")
	private EntityManager em;
	
	public Order createOrder(Customer c){
		Order o= new Order(c);
		return o;
	}
	
	public void confirmOrder(Order o){
		o.setState("closed");
		Calendar calendar = new GregorianCalendar();
		Date newDate = calendar.getTime();
		o.setClosingOrderDate(newDate);
		this.em.persist(o);
	}

	public Double getTotal(Order currentOrder) {
		Iterator<OrderLine> it=currentOrder.getOrderLines().iterator();
		Double total=0.0;
		while(it.hasNext()){
			OrderLine ol=it.next();
			total=total+ (ol.getProductDescription().getPrice()* ol.getQuantity());
		}
		return total;
	}

}
