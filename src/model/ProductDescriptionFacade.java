package model;
import javax.ejb.Stateless;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name="pdFacade")
public class ProductDescriptionFacade {
	@PersistenceContext(unitName= "unit-progetto-siw")
	private EntityManager em;
	
	
	public ProductDescription createProductDescription(String code, String name, Double price, String description,Product product,int quantity){
		ProductDescription pd;
		 
		 
	     pd = new ProductDescription(code,name,price,description,quantity);
	     if(product!=null){
	     List<Product> listProduct = new ArrayList<Product>();
	     listProduct.add(product);
	     pd.setProducts(listProduct);}
		 em.persist(pd);
		 if(product!=null)
		 em.persist(product);
	
		return pd;
	}
	
	public ProductDescription refreshProductDescription(String code,Product product){
		ProductDescription pd;
		pd = em.find(ProductDescription.class,code);
		List<Product> listProduct = pd.getProducts();
		listProduct.add(product);	
		em.persist(pd);
		em.persist(product);
	   
		return pd;
}
	
	public ProductDescription controlExistenceProduct(String code){
		return em.find(ProductDescription.class,code);
	}
	
   public ProductDescription refreshQuantity(String code,int quantity){
	   ProductDescription pd;
		pd = em.find(ProductDescription.class,code);
		int previousQuantity = pd.getQuantity();
		pd.setQuantity(previousQuantity + quantity);
		em.merge(pd);
		em.refresh(pd);
		return pd;
	   
	   
   }
}
