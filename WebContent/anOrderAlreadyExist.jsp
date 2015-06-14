<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>e-Market</title>
</head>
<body>
<f:view>
	<h1>
		<b>e-Market</b>
	</h1>
	<h2>
		<b>${customerManager.currentCustomer.firstname}, You can't create a new Order</b>
	</h2>
	<h3>To create a new Order, go in your shopping Cart and delete your current Order</h3>
	<h:form>

		<div><a href='<c:url value="/faces/customerHome.jsp" />'>Go home</a>     <h:commandLink action="#{orderController.goShoppingCart}"
				value="Shopping Cart">
			</h:commandLink></div>

</h:form>
</f:view>
</body>
</html>