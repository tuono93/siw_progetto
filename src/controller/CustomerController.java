package controller;

import model.CustomerFacade;
import model.Address;
import model.AddressFacade;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Customer;
import model.Order;


@ManagedBean(name= "customerController")
@RequestScoped
public class CustomerController {

	@ManagedProperty(value="#{param.cf}")
	private String fc;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private Date dateOfBirth;
	private String street;
	private String houseNumber;
	private String zipCode;
	private String city;
	private String country;
	private Customer customer;
	private Address address;


	@EJB(beanName="aFacade")
	private AddressFacade addressFacade;

	@EJB(beanName ="cFacade")
	private CustomerFacade customerFacade;

	@ManagedProperty(value ="#{customerManager}")
	private CustomerManager session;

	@ManagedProperty(value ="#{orderController}")
	private OrderController oc;

	public String createCustomer(){ 
		this.address = this.addressFacade.createAddress(street, houseNumber, zipCode, city, country);
		this.customer= customerFacade.createCustomer(fc, firstname, lastname, email, password, dateOfBirth,address);
		return "registeredCustomer";
	}

	public String loginCustomer(){
		Customer c=this.customerFacade.findCustomer(email);
		if(c==null || !(c.getPassword().equals(this.password)))
			return "failedLogin";
		else{
			this.session.login(c);
			return "customerHome";
		}
	}


	public String logoutCustomer(){
		this.session.logout();
		this.oc.getSessionOrder().setCurrentOrder(null);
		return "generalHome.html";
	}

	public String createOrder(){
		Customer currentCustomer = this.session.getCurrentCustomer();
		if(currentCustomer==null)
			return "loginCustomer";
		else {
			return this.oc.createOrder(currentCustomer);
		}
	}

	public List<Order> getOrders(){
		return this.customerFacade.getOrders(this.session.getCurrentCustomer());
	}

	public String goMyOrders(){
		if(this.session.getCurrentCustomer()==null){
			return "loginCustomer";
		} else if(this.getOrders().isEmpty()||this.getOrders()==null)
			return "noOrders";
		else return "customerOrders";
	}

	public String orderDetails() {
		return "orderDetails";
	}
	public String getFc() {
		return fc;
	}
	public void setFc(String fc) {
		this.fc = fc;
	}

	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
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




	public Customer getCustomer() {
		return customer;
	}




	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public AddressFacade getAddressFacade() {
		return addressFacade;
	}

	public void setAddressFacade(AddressFacade addressFacade) {
		this.addressFacade = addressFacade;
	}

	public CustomerFacade getCustomerFacade() {
		return customerFacade;
	}

	public void setCustomerFacade(CustomerFacade customerFacade) {
		this.customerFacade = customerFacade;
	}

	public CustomerManager getSession() {
		return session;
	}

	public void setSession(CustomerManager session) {
		this.session = session;
	}

	public OrderController getOc() {
		return oc;
	}

	public void setOc(OrderController oc) {
		this.oc = oc;
	}




}
