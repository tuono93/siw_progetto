package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Customer;

@ManagedBean(name = "customerManager")
@SessionScoped
public class CustomerManager {
	private Customer currentCustomer;

	public void logout() {
		this.currentCustomer=null;
	}

	public void login(Customer c) {
		this.currentCustomer = c;
	}

	

	public Customer getCurrentCustomer() {
		return currentCustomer;
	}
	
	public boolean isLogged(){
		return (this.currentCustomer != null);
	}

}
