<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<f:view>
		<h:form>
			<h1>Hi, ${customerManager.currentCustomer.firstname}</h1>
			<h2>Choose an activity:</h2>
			<ul>
				<li><a href='<c:url value="/faces/productCatalog.jsp" />'>View
						Product Catalog</a></li>
				<li><h:commandLink action="#{customerController.createOrder}"
						value="New Order">
					</h:commandLink></li>
				<li><h:commandLink action="#{orderController.goShoppingCart}"
						value="Shopping Cart">
					</h:commandLink></li>
				<li><h:commandLink action="#{customerController.goMyOrders}"
						value="My Orders">
					</h:commandLink></li>
			</ul>
			<h:commandButton value="Logout"
				action="#{customerController.logoutCustomer}" />
		</h:form>
	</f:view>
</body>
</html>