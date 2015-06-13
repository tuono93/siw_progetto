package controller;


import java.util.LinkedHashMap;
import java.util.List;

import model.*;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
<<<<<<< HEAD
import javax.inject.Inject;
import javax.inject.Named;

import model.AddressFacade;
import model.CustomerFacade;
import model.Provider;
import java.util.*;
=======
>>>>>>> branch 'master' of https://github.com/tuono93/siw_progetto.git


@ManagedBean(name = "productController")
@RequestScoped
public class ProductController  {

	@ManagedProperty(value="#{productManager}")
	private ProductManager productManager;
<<<<<<< HEAD

=======
	
	
	
>>>>>>> branch 'master' of https://github.com/tuono93/siw_progetto.git

	private String name;
	private String code;
	private String description;
	private Double price;
	private Product product;
	private ProductDescription productDescription;
	private int quantity;
<<<<<<< HEAD
	private Provider provider;
	private String vatin;
	private String nameProvider;
	private String email;
	private String street;
	private String houseNumber;
	private String zipCode;
	private String city;
	private String country;
	private String phoneNumber;
	private Address address;
=======
>>>>>>> branch 'master' of https://github.com/tuono93/siw_progetto.git

	@EJB(beanName="pFacade")
	private ProductFacade productFacade;

	@EJB(beanName ="pdFacade")
	private ProductDescriptionFacade productDescriptionFacade;
<<<<<<< HEAD

	@EJB(beanName ="prFacade")
	private ProviderFacade providerFacade;

	@EJB(beanName="aFacade")
	private AddressFacade addressFacade;


	public String createProduct(){
		int i;

		if(quantity>0){
			this.product = productFacade.createProduct();
			this.productManager.createListCodeProducts();
		}

		this.productDescription = productDescriptionFacade.createProductDescription(this.productManager.getCodeProductDescription(), name, price, description, product,quantity);
		
		if(quantity>0){
			this.productManager.getListCodeProducts().add(product.getId());}


		for(i=1;i<quantity;i++){
			this.product = productFacade.createProduct();
			this.productDescription = productDescriptionFacade.refreshProductDescription(this.productManager.getCodeProductDescription(),product);
			this.productManager.getListCodeProducts().add(product.getId());}

		if(quantity==0)
			return "registeredProduct";
		else
			return 
					"providerCode";
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
=======
	
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
>>>>>>> branch 'master' of https://github.com/tuono93/siw_progetto.git
	}



<<<<<<< HEAD
	public String addProduct(){
		int i;

		for (i=0;i<quantity;i++){
			this.product = productFacade.createProduct();
			this.productDescription = productDescriptionFacade.refreshProductDescription(this.productManager.getCodeProductDescription(),product);
			if(this.productManager.getListCodeProducts()==null){
				this.productManager.createListCodeProducts();
				this.productManager.getListCodeProducts().add(product.getId());

			}
			else{
				this.productManager.getListCodeProducts().add(product.getId());
			}}

		this.productDescription = productDescriptionFacade.refreshQuantity(this.productManager.getCodeProductDescription(), quantity);

		if(quantity==0)
			return "registeredProduct";

		else
			return "providerCode";

=======
	public String getName() {
		return name;
>>>>>>> branch 'master' of https://github.com/tuono93/siw_progetto.git
	}


<<<<<<< HEAD
	public String createOrAddProvider(){
		this.provider = this.providerFacade.controlExistenceProvider(vatin);
		if(this.provider==null){
			this.productManager.setVatinProvider(vatin);
			return "newProvider";}
		else{
			this.addProvider();
			return "registeredProduct";}
	}

	public String createProvider(){
		this.address = this.addressFacade.createAddress(street, houseNumber, zipCode, city, country);
		this.provider = this.providerFacade.createProvider(this.productManager.getVatinProvider(), nameProvider, phoneNumber, email, address, this.productManager.getListCodeProducts());
		this.productManager.getListCodeProducts().clear();

		return "registeredProduct";	
	}

	private void addProvider(){
		this.provider = this.providerFacade.addProvider(vatin, this.productManager.getListCodeProducts());
		this.productManager.getListCodeProducts().clear();

	}


	public String getName() {
		return name;
	}


=======
>>>>>>> branch 'master' of https://github.com/tuono93/siw_progetto.git
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
<<<<<<< HEAD

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public String getVatin() {
		return vatin;
	}

	public void setVatin(String vatin) {
		this.vatin = vatin;
	}

	public String getNameProvider() {
		return nameProvider;
	}

	public void setNameProvider(String nameProvider) {
		this.nameProvider = nameProvider;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
=======
>>>>>>> branch 'master' of https://github.com/tuono93/siw_progetto.git


	public Address getAddress() {
		return address;
	}


<<<<<<< HEAD
	public void setAddress(Address address) {
		this.address = address;
=======

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
>>>>>>> branch 'master' of https://github.com/tuono93/siw_progetto.git
	}






}
