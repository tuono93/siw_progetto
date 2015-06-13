package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Order {
						
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date openingOrderDate;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date closingOrderDate;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date consignmentOrderDate;
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name ="orders_id")
	private List<OrderLine> orderLines;
	@ManyToOne
	private Customer customer;
	@Column(nullable=false)
	private String state;
	
	public Order() {
	
	}

	public Order(Customer customer) {
		Calendar calendar = new GregorianCalendar();
		Date newDate = calendar.getTime();
		this.openingOrderDate = newDate;
		this.customer = customer;
		this.orderLines= new ArrayList<OrderLine>();
		this.state="open";
	}
	
	public void addOrderLine(OrderLine ol){
		this.orderLines.add(ol);
	}

	public Date getOpeningOrderDate() {
		return openingOrderDate;
	}

	public void setOpeningOrderDate(Date openingOrderDate) {
		this.openingOrderDate = openingOrderDate;
	}

	public Date getClosingOrderDate() {
		return closingOrderDate;
	}

	public void setClosingOrderDate(Date closingOrderDate) {
		this.closingOrderDate = closingOrderDate;
	}

	public Date getConsignmentOrderDate() {
		return consignmentOrderDate;
	}

	public void setConsignmentOrderDate(Date consignmentOrderDate) {
		this.consignmentOrderDate = consignmentOrderDate;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
	
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
	
	
}
