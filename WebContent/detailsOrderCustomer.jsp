<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>e-Market</title>
</head>
<body>
	<f:view>
		<h1>
			<b>Order Details</b>
		</h1>
		<h2>
			<b>ORDER ID:</b> ${orderController.order.id}
		</h2>
		<div>
			<b>State:</b> ${orderController.order.state}
		</div>
		<div>
			<b>Closing Order Date:</b> ${orderController.order.closingOrderDate}
		</div>
Customer Details:
<h:form>
			<div>
				<b>Lastname:</b> ${orderController.order.customer.lastname}
			</div>
			<div>
				<b>Fiscal Code:</b> ${orderController.order.customer.fc}
			</div>
			<div>
				<b>Street:</b>
				${orderController.order.customer.address.street},${orderController.order.customer.address.houseNumber}
			</div>
			<div>
				<b>Zip Code:</b> ${orderController.order.customer.address.zipCode}
			</div>
			<div>
				<b>City:</b> ${orderController.order.customer.address.city}
			</div>
			<div>
				<b>Country:</b> ${orderController.order.customer.address.country}
			</div>
		</h:form>
		<div>
			<a href="javascript:history.go(-1);">Back</a>
		</div>
	</f:view>
</body>
</html>