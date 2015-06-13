package model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name="olFacade")
public class OrderLineFacade {
	@PersistenceContext(unitName= "unit-progetto-siw")
	private EntityManager em;
	
	public OrderLine createOrderLine(ProductDescription productDescription, Integer quantity){
		OrderLine ol=new OrderLine(productDescription, quantity);
		return ol;
	}

}
