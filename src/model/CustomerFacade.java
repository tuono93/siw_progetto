package model;



import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@Stateless(name="cFacade")

public class CustomerFacade {
	@PersistenceContext(unitName= "unit-progetto-siw")
	private EntityManager em;
	
	public Customer createCustomer(String fc, String firstname, String lastname, String email, String password, Date dateOfBirth,Address address){
		Customer c =new Customer(fc,firstname,lastname,email,password,dateOfBirth,address);
		em.persist(c);
		return c;
	}
}
