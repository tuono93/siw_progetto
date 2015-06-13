package controller;


import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Product;
 
@ManagedBean(name="productManager")
@SessionScoped
public class ProductManager {
private String codeProductDescription;
private String vatinProvider;
private List<Long> listCodeProducts;

public ProductManager(){}

public String getCodeProductDescription() {
	return codeProductDescription;
}
public void setCodeProductDescription(String codeProductDescription) {
	this.codeProductDescription = codeProductDescription;
}
public List<Long> getListCodeProducts() {
	return listCodeProducts;
}
public void setListProductIncluded(List<Long> listCodeProducts) {
	this.listCodeProducts = listCodeProducts;
}
public String getVatinProvider() {
	return vatinProvider;
}
public void setVatinProvider(String vatinProvider) {
	this.vatinProvider = vatinProvider;
}

public void createListCodeProducts(){
List <Long> listCodeProducts = new ArrayList<Long>();
this.setListProductIncluded(listCodeProducts);
}
}
