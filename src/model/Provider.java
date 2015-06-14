package model;

import javax.persistence.*;

import java.util.*;
@Entity
public class Provider {


@Id
private String vatin;

@Column
private String name;

@Column
private String phoneNumber;

@Column
private String email;


@OneToMany(mappedBy="provider")
private List <Product> products;

@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
private Address address;

public Provider(String vatin,String name, String phoneNumber, String email,Address address) {
	this.vatin=vatin;
	this.name = name;
	this.phoneNumber = phoneNumber;
	this.email = email;
	this.address = address;
}

public Provider(){
}


public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getVatin() {
	return vatin;
}

public void setVatin(String vatin) {
	this.vatin = vatin;
}

public List<Product> getProducts() {
	return products;
}

public void setProducts(List<Product> products) {
	this.products = products;
}
}
