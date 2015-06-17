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
		<div>
			<b>Consignment Order Date:</b> ${orderController.order.consignmentOrderDate}
		</div>
Details:
<h:form>
			<ul>
				<c:forEach var="orderLine"
					items="#{orderController.order.orderLines}">
					<li><div>
							<b>Product:</b> ${orderLine.productDescription.name}
						</div>
						<div>
							<b>Unit Price:</b> ${orderLine.realUnitPrice}
						</div>
						<div>
							<b>Quantity:</b> ${orderLine.quantity}
						</div></li>
					<div>*********************</div>
				</c:forEach>
			</ul>
			<div>
				<b>TOTAL PRICE:</b> ${orderController.order.getTotal()}
			</div>
		</h:form>
		<div>
			<a href="javascript:history.go(-1);">Back</a>
		</div>
	</f:view>
</body>
</html>