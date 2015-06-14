<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>e-Market</title>
</head>
<body>
<h1><b>Shopping Cart</b></h1>
<f:view>
<h:form>
		<ul>
		<c:forEach var="orderLine" items="#{orderManager.currentOrder.orderLines}">
		<li><div><b>Product:</b> ${orderLine.productDescription.name}</div>
		<div><b>Unit Price:</b> ${orderLine.productDescription.price}</div>
			<div><b>Quantity:</b> ${orderLine.quantity}</div></li>
			<div>*********************</div>
		</c:forEach>
		</ul>
	<div>
		<a href='<c:url value="/faces/newOrderLine.jsp" />'>Add product</a>
	</div>
	<div>
		<a href='<c:url value="/faces/customerHome.jsp" />'>Home</a>
	</div>
	<div><a href='<c:url value="/faces/confirmOrderDeletion.jsp" />'>Delete Order</a></div>
						</h:form>
	</f:view>
</body>
</html>