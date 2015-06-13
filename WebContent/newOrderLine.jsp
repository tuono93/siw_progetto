<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Order</title>
</head>
<body>
<f:view>
<h1><b>Insert code of Product, ${customerManager.currentCustomer.firstname}</b></h1>
<h:form>
			<div>
				Code:
				<h:inputText value="#{orderController.productDescriptionCode}" required="true"
					requiredMessage="Code is mandatory" id="code" />
				<h:message for="code" />
			</div>
			<div>
				Quantity:
				<h:inputText value="#{orderController.quantity}" required="true"
					requiredMessage="Quantity is mandatory" 
					converterMessage="Quantity must be an integer number" id="quantity" />
				<h:message for="quantity" />
				
			</div>
			<div><a href='<c:url value="/faces/productCatalog.jsp" />'>View Product Catalog</a></div>
			<div></div>
			<div><a href='<c:url value="/faces/customerHome.jsp" />'>Go Home</a> </div>
			 <div>
			 
		<h:commandButton value="Submit"  action="#{orderController.createOrderLine}"/>
	    </div>
	    </h:form>
</f:view>
</body>
</html>