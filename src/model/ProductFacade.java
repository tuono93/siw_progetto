package model;




import javax.ejb.Stateless;


@Stateless(name="pFacade")
public class ProductFacade {

	
	public Product createProduct(){
		Product p =new Product();
		return p;
	}
	
}
