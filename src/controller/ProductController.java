package controller;


import java.util.LinkedHashMap;
import java.util.List;

import model.*;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;


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
	
	@EJB(beanName ="pcFacade")
	private ProductCatalog productCatalog;

	public String createProduct(){
		int i;
		this.code=this.productManager.getCodeProductDescription();
		if(quantity>0){
			this.product = productFacade.createProduct();}
		this.productDescription = productDescriptionFacade.createProductDescription(code, name, price, description, product,quantity);


		for(i=1;i<quantity;i++){
			this.product = productFacade.createProduct();
			this.productDescription = productDescriptionFacade.refreshProductDescription(code ,product);}

		return "registeredProduct";	
	}



	public String controlExistenceProduct(){
		String stringFinal=null;
		this.code=this.productManager.getCodeProductDescription();
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
		this.code=this.productManager.getCodeProductDescription();
		for (i=0;i<quantity;i++){
			this.product = productFacade.createProduct();
			this.productDescription = productDescriptionFacade.refreshProductDescription(code,product);}

		this.productDescription = productDescriptionFacade.refreshQuantity(code, quantity);
		return "registeredProduct";

	}
	
	public List<ProductDescription> getProductCatalog(){
		List<ProductDescription> catalog= this.productCatalog.getProductCatalog();
		return catalog;
	}
	
	public String details(){
		
		return "productDetails";
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





	public ProductFacade getProductFacade() {
		return productFacade;
	}



	public void setProductFacade(ProductFacade productFacade) {
		this.productFacade = productFacade;
	}



	public ProductDescriptionFacade getProductDescriptionFacade() {
		return productDescriptionFacade;
	}



	public void setProductDescriptionFacade(
			ProductDescriptionFacade productDescriptionFacade) {
		this.productDescriptionFacade = productDescriptionFacade;
	}



	public void setProductCatalog(ProductCatalog productCatalog) {
		this.productCatalog = productCatalog;
	}






}
