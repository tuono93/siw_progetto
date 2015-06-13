package model;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name="pcFacade")
public class ProductCatalog {
	@PersistenceContext(unitName= "unit-progetto-siw")
	private EntityManager em;
	
	public List <ProductDescription> getProductCatalog(){
		Query query= this.em.createNamedQuery("getAllProductDescriptions");
		List<ProductDescription> catalog;
		try{
		catalog= query.getResultList();
		}
		catch (NoResultException e){
			catalog=null;
		}
		return catalog;
	}

}
