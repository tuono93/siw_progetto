package controller;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Customer;
import model.Order;
import model.OrderFacade;
import model.OrderLine;
import model.OrderLineFacade;
import model.ProductDescription;
import model.ProductDescriptionFacade;
@ManagedBean(name= "orderController")
@RequestScoped
public class OrderController {
	@EJB(beanName="oFacade")
	private OrderFacade orderFacade;
	@EJB(beanName="olFacade")
	private OrderLineFacade orderLineFacade;
	@EJB(beanName="pdFacade")
	private ProductDescriptionFacade pdFacade;
	private String productDescriptionCode;
	private Integer quantity;
	private Order order;

	@ManagedProperty(value ="#{orderManager}")
	private OrderManager sessionOrder;

	public OrderController(){
	}

	public String createOrder(Customer c){
		if(this.sessionOrder.getCurrentOrder()!=null)
			return "anOrderAlreadyExist";
		else{
		Order o=this.orderFacade.createOrder(c);
		this.sessionOrder.setCurrentOrder(o);
		return "newFirstOrderLine";
		}
	}

	public String createOrderLine(){
		Order currentOrder = this.sessionOrder.getCurrentOrder();
		if(currentOrder==null)
			return "customerHome";
		else {
			ProductDescription pd=this.pdFacade.findProductDescription(this.productDescriptionCode);
			if(pd==null) return "nonExistingProduct";
			else{
				OrderLine ol=this.orderLineFacade.createOrderLine(currentOrder, pd, this.quantity);
				currentOrder.getOrderLines().add(ol);
				return "shoppingCart";
			}
		}
	}

	public String goShoppingCart(){
		if(this.sessionOrder.getCurrentOrder()==null || this.sessionOrder.getCurrentOrder().getOrderLines().isEmpty())
			return "shoppingCartEmpty";
		else
			return "shoppingCart";
	}

	public String deleteCurrentOrder(){
		this.orderFacade.deleteCurrentOrder(this.sessionOrder.getCurrentOrder());
		this.sessionOrder.setCurrentOrder(null);
		return "shoppingCartEmpty";
	}
	
	public String goHomeAndDelete(){
		this.orderFacade.deleteCurrentOrder(this.sessionOrder.getCurrentOrder());
		this.sessionOrder.setCurrentOrder(null);
		return "customerHome";
	}
	
	public Double getTotal(){
		return this.orderFacade.getTotal(this.sessionOrder.getCurrentOrder());
			
	}

	public OrderFacade getOrderFacade() {
		return orderFacade;
	}

	public void setOrderFacade(OrderFacade orderFacade) {
		this.orderFacade = orderFacade;
	}

	public OrderLineFacade getOrderLineFacade() {
		return orderLineFacade;
	}

	public void setOrderLineFacade(OrderLineFacade orderLineFacade) {
		this.orderLineFacade = orderLineFacade;
	}

	public OrderManager getSessionOrder() {
		return sessionOrder;
	}

	public void setSessionOrder(OrderManager sessionOrder) {
		this.sessionOrder = sessionOrder;
	}

	public String getProductDescriptionCode() {
		return productDescriptionCode;
	}

	public void setProductDescriptionCode(String productDescriptionCode) {
		this.productDescriptionCode = productDescriptionCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String confirmCurrentOrder() {
		Order currentOrder=this.sessionOrder.getCurrentOrder();
			this.orderFacade.confirmOrder(currentOrder);
			this.order=currentOrder;
			this.sessionOrder.setCurrentOrder(null);
			return "summaryOrder";
	}

	public ProductDescriptionFacade getPdFacade() {
		return pdFacade;
	}

	public void setPdFacade(ProductDescriptionFacade pdFacade) {
		this.pdFacade = pdFacade;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	




}
