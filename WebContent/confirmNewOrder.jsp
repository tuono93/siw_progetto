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
		<b>Shopping Cart</b>
	</h1>
	<h2>
		<b>Are you sure to confirm this order, ${customerManager.currentCustomer.firstname}?</b>
	</h2>
	<h:form>
<ul>
		<c:forEach var="orderLine" items="#{orderManager.currentOrder.orderLines}">
		<li><div><b>Product:</b> ${orderLine.productDescription.name}</div>
<<<<<<< HEAD
		<div><b>Unit Price:</b> ${orderLine.productDescription.price}</div>
			<div><b>Quantity:</b> ${orderLine.quantity}</div></li>
			<div>*********************</div>
		</c:forEach>
		</ul>
		<div><b>TOTAL PRICE:</b> ${orderController.getTotal()}</div>
		<div><a href='<c:url value="/faces/shoppingCart.jsp" />'>No</a>      <h:commandLink action="#{customerController.confirmCurrentOrder}"
=======
		<div><b>Unit Price:</b> ${orderLine.realUnitPrice}</div>
			<div><b>Quantity:</b> ${orderLine.quantity}</div></li>
			<div>*********************</div>
		</c:forEach>
		</ul>
		<div><b>TOTAL PRICE:</b> ${orderController.getTotal()}</div>
		<div><a href='<c:url value="/faces/shoppingCart.jsp" />'>No</a>      <h:commandLink action="#{orderController.confirmCurrentOrder}"
>>>>>>> branch 'master' of https://github.com/tuono93/siw_progetto.git
				value="Yes">
			</h:commandLink></div>

</h:form>
</f:view>
</body>
</html>
