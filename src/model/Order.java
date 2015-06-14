package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date openingOrderDate;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date closingOrderDate;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date consignmentOrderDate;
	@OneToMany(cascade = {CascadeType.ALL})
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
		this.closingOrderDate=newDate;
		this.consignmentOrderDate=newDate;
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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Double getTotal() {
		Iterator<OrderLine> it=this.orderLines.iterator();
		Double total=0.0;
		while(it.hasNext()){
			OrderLine ol=it.next();
			total=total+ (ol.getRealUnitPrice()* ol.getQuantity());
		}
		return total;
	}
	
	
}
