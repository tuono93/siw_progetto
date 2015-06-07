package controller;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Administrator;

@ManagedBean
public class AdministratorController {
	
@ManagedProperty(value="#{param.password}")
private String password;
private Administrator admnin;

public String convalidatePassword(){
	return "adminHome";
}
public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}


}
