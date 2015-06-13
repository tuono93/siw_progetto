package model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.RollbackException;



import java.util.*;

@Stateless(name="prFacade")
public class ProviderFacade {

	@PersistenceContext(unitName= "unit-progetto-siw")
	private EntityManager em;

public Provider controlExistenceProvider(String vatin){
		return em.find(Provider.class,vatin);
}



public Provider createProvider(String vatin,String name,String phoneNumber,String email,Address address,List<Long> listCodeProducts){
Provider p = new Provider(vatin,name,phoneNumber,email,address);
em.persist(p);
for(Long codeProduct: listCodeProducts){
Product product = em.find(Product.class,codeProduct);
this.addProductToProvider(product, p);
this.addProviderToProduct(product, p);
}


return p;	
}

public Provider addProvider(String vatin,List<Long> listCodeProducts){

Provider p = em.find(Provider.class,vatin);

for(Long codeProduct: listCodeProducts){
Product product = em.find(Product.class,codeProduct);
this.addProductToProvider(product, p);
this.addProviderToProduct(product, p);
}

return p;
}

public void addProviderToProduct(Product product, Provider provider){
product.setProvider(provider);
em.persist(product);
}

public void addProductToProvider(Product product, Provider provider){
	
	if(provider.getProducts()==null){
		List<Product> listProduct = new ArrayList<Product>();
		listProduct.add(product);
		provider.setProducts(listProduct);}
		else{
		provider.getProducts().add(product);
		}
	
	em.persist(provider);
	
	
	
}


}
