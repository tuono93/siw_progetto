package model;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name="pFacade")
public class ProductFacade {
	
	public Product createProduct(){
		Product p =new Product();
		return p;
	}

}
