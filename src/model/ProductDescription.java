package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "getAllProductDescriptions", query = "SELECT pd FROM ProductDescription pd")
public class ProductDescription {
	@Id 
	private String code;
	@Column
	private String name;
	@Column
	private Double price;
	@Column
	private String description;
	@Column
	private int quantity;
	@OneToMany
	@JoinColumn(name ="productDescription_id")
	private List<Product> products;
	


	
	public ProductDescription(String code, String name, Double price,
			String description,int quantity) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
	}

	public ProductDescription (){
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



}
