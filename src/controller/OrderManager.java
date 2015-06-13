package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Order;

@ManagedBean(name = "orderManager")
@SessionScoped
public class OrderManager {
	private Order currentOrder;

	public Order getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}
	
	
}
