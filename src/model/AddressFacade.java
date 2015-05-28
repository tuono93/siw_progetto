package model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name="aFacade")

public class AddressFacade {
	public Address createAddress(String street, String houseNumber, String zipCode, String city, String country){
		Address i = new Address(street, houseNumber, zipCode, city, country);
		return i;
	}
}
