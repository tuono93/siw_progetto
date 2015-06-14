package model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name="olFacade")
public class OrderLineFacade {
	@PersistenceContext(unitName= "unit-progetto-siw")
	private EntityManager em;
	
	public OrderLine createOrderLine(Order currentOrder, ProductDescription productDescription, Integer quantity){
		ProductDescription productDescriptionManaged= this.em.find(ProductDescription.class, productDescription.getCode());
		Order orderManaged=this.em.find(Order.class, currentOrder.getId());
		OrderLine ol=new OrderLine(productDescriptionManaged, quantity);
		orderManaged.getOrderLines().add(ol);
		this.em.persist(orderManaged);
		return ol;
	}

}
