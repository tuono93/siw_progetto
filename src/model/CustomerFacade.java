package model;



import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name="cFacade")

public class CustomerFacade {
	@PersistenceContext(unitName= "unit-progetto-siw")
	private EntityManager em;

	public Customer createCustomer(String fc, String firstname, String lastname, String email, String password, Date dateOfBirth,Address address){
		Customer c =new Customer(fc,firstname,lastname,email,password,dateOfBirth,address);
		em.persist(c);
		return c;
	}

	public Customer findCustomer(String email){
		Customer c= new Customer();
		Query query=em.createNamedQuery("findCustomer");
		query.setParameter("email", email);
		try {
			c=(Customer) query.getSingleResult();
		}
		catch (NoResultException e){
			c=null;
		}
		return c;

	}
	
	public void deleteCustomers(){
		Query query=em.createQuery("DELETE FROM Customer c");
		query.executeUpdate();
	}

}
