package model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

}
