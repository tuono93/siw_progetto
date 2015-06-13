package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Administration;

@ManagedBean(name = "administrationManager")
@SessionScoped
public class AdministrationManager {
	private Administration currentAdministration;

	public Administration getCurrentAdministration() {
		return currentAdministration;
	}

	public void setCurrentAdministration(Administration currentAdministration) {
		this.currentAdministration = currentAdministration;
	}
	
	public void logout() {
		this.currentAdministration=null;
	}

	public void login(Administration a) {
		this.currentAdministration = a;
	}
	
	public boolean isLogged(){
		return (this.currentAdministration!= null);
	}
}
