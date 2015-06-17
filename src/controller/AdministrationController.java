package controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Administration;

@ManagedBean(name ="administrationController")
@RequestScoped
public class AdministrationController {
	@ManagedProperty(value ="#{administrationManager}")
	private AdministrationManager session;
	
	@ManagedProperty(value ="#{productController}")
	private ProductController pc;
	
	@ManagedProperty(value ="#{orderController}")
	private OrderController oc;
	
	@ManagedProperty(value="#{param.password}")
	private String password;
	private Administration admnin;
	
	public AdministrationController(){
	}
	public String login(){
		this.admnin= new Administration();
		if(this.password.equals(admnin.getPassword())){
		this.session.login(admnin);
		return "adminHome";
		}
		else 
			return "failedLogin"; 
		
	}
	public String logoutAdministration(){                
		this.session.logout();
		return "generalHome.html";
	}
	
	public String newProduct(){
		if(this.session.getCurrentAdministration()==null)
			return "loginAdministrator";
		else
			return "productDescriptionCode";
	}
	
	public String newCustomer(){
		if(this.session.getCurrentAdministration()==null)
			return "loginAdministrator";
		else    
			return "newCustomer";
	}
	
	public String listClosedOrders(){
		 if(this.session.getCurrentAdministration()==null)
			return "loginAdministrator";
		 
		 else return this.oc.listClosedOrders();

		
	}
	
	
	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Administration getAdmnin() {
		return admnin;
	}
	public void setAdmnin(Administration admnin) {
		this.admnin = admnin;
	}
	public AdministrationManager getSession() {
		return session;
	}
	public void setSession(AdministrationManager session) {
		this.session = session;
	}
	public ProductController getPc() {
		return pc;
	}
	public void setPc(ProductController pc) {
		this.pc = pc;
	}
	public OrderController getOc() {
		return oc;
	}
	public void setOc(OrderController oc) {
		this.oc = oc;
	}
	
	
	
	
	


}
