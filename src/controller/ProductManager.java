package controller;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
@ManagedBean(name="productManager")
@SessionScoped
public class ProductManager {
private String codeProductDescription;

public ProductManager(){}
public String getCodeProductDescription() {
	return codeProductDescription;
}
public void setCodeProductDescription(String codeProductDescription) {
	this.codeProductDescription = codeProductDescription;
}


}
