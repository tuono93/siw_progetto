<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>e-Market</title>
</head>
<body>
<h1>Summary Order:</h1>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>e-Market</title>
</head>
<body>
<f:view>
	<h1>
		<b>Summary Order</b>
	</h1>
	<h2>
		<b>${customerManager.currentCustomer.firstname}, your order has been confirmed</b>
	</h2>
	<h3><b>ORDER ID:</b> ${orderController.order.id}</h3>
	Details:
	<h:form>
<ul>
		<c:forEach var="orderLine" items="#{orderController.order.orderLines}">
		<li><div><b>Product:</b> ${orderLine.productDescription.name}</div>
		<div><b>Unit Price:</b> ${orderLine.realUnitPrice}</div>
			<div><b>Quantity:</b> ${orderLine.quantity}</div></li>
			<div>*********************</div>
		</c:forEach>
		</ul>
		<div><b>TOTAL PRICE:</b> ${orderController.order.getTotal()}</div>
		<a href='<c:url value="/faces/customerHome.jsp" />'>Home</a> 

</h:form>
</f:view>
</body>
</html>
