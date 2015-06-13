<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>

</head>
<body>
<h1><b>Add a Product:</b></h1>
<f:view>
		<h:form>
			<div>Code: ${productController.productManager.codeProductDescription}</div>
			<div>
				Quantity:
				<h:inputText value="#{productController.quantity}" 
				required="true"
				requiredMessage="Quantity is mandatory" 
				converterMessage="Quantity must be an integer number" 
				id="quantity"/>
				<h:message for="quantity" />
			</div>
			<div></div>
		<div><a href='<c:url value="/faces/adminHome.jsp" />'>Home</a> </div>
	       <div>
		 <h:commandButton value="Submit"  action="#{productController.addProduct}"/>
	    </div>
	
</h:form>
</f:view>
</body>
</html>