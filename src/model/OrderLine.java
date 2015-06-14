package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class OrderLine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	@OneToOne
	private ProductDescription productDescription;
	@Column(nullable=false)
	private Integer quantity;
	@Column(nullable=false)
	private Double realUnitPrice;
	
	public OrderLine(){
	}
	
	public OrderLine(ProductDescription productDescription, Integer quantity) {
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.realUnitPrice=productDescription.getPrice();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public ProductDescription getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(ProductDescription productDescription) {
		this.productDescription = productDescription;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getRealUnitPrice() {
		return realUnitPrice;
	}

	public void setCurrentUnitPrice(Double realUnitPrice) {
		this.realUnitPrice = realUnitPrice;
	}
	
	
	
}
