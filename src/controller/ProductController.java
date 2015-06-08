package controller;


import model.*;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

import model.AddressFacade;
import model.CustomerFacade;


@ManagedBean(name = "productController")
@RequestScoped
public class ProductController  {

	@ManagedProperty(value="#{productManager}")
	private ProductManager productManager;

	
	private String name;
    private String code;
	private String description;
	private Double price;
	private Product product;
	private ProductDescription productDescription;
	private int quantity;
	
	@EJB(beanName="pFacade")
	private ProductFacade productFacade;
	
	@EJB(beanName ="pdFacade")
	private ProductDescriptionFacade productDescriptionFacade;

	
public String createProduct(){
	int i;
	if(quantity>0){
	this.product = productFacade.createProduct();}
	this.productDescription = productDescriptionFacade.createProductDescription(this.productManager.getCodeProductDescription(), name, price, description, product,quantity);
	
	
	for(i=1;i<quantity;i++){
	this.product = productFacade.createProduct();
	this.productDescription = productDescriptionFacade.refreshProductDescription(this.productManager.getCodeProductDescription(),product);}
	
	return "registeredProduct";	
}



public String controlExistenceProduct(){
String stringFinal=null;
this.productDescription = this.productDescriptionFacade.controlExistenceProduct(code);
this.productManager.setCodeProductDescription(code);
if(this.productDescription==null)
	stringFinal="newProduct";
else
	stringFinal = "addProduct";


return stringFinal;
}



public String addProduct(){
int i;

for (i=0;i<quantity;i++){
this.product = productFacade.createProduct();
this.productDescription = productDescriptionFacade.refreshProductDescription(this.productManager.getCodeProductDescription(),product);}

this.productDescription = productDescriptionFacade.refreshQuantity(this.productManager.getCodeProductDescription(), quantity);
return "registeredProduct";
	
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getCode() {
	return code;
}


public void setCode(String code) {
	this.code = code;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public Double getPrice() {
	return price;
}


public void setPrice(Double price) {
	this.price = price;
}


public Product getProduct() {
	return product;
}


public void setProduct(Product product) {
	this.product = product;
}


public ProductDescription getProductDescription() {
	return productDescription;
}


public void setProductDescription(ProductDescription productDescription) {
	this.productDescription = productDescription;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}



public ProductManager getProductManager() {
	return productManager;
}



public void setProductManager(ProductManager productManager) {
	this.productManager = productManager;
}






}
