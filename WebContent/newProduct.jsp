<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Product</title>

</head>
<body>
	<h1>
		<b>Insert new Product:</b>
	</h1>
	<f:view>
		<h:form>
		<div>Code: ${productController.code}</div>
			<div>
				Name:
				<h:inputText value="#{productController.name}" required="true"
					requiredMessage="Name is mandatory" id="name" />
				<h:message for="name" />
			</div>
			<div>
				Price:
				<h:inputText value="#{productController.price}" required="true"
					requiredMessage="Price is mandatory"
					converterMessage="Price must be a number" id="price" />
				<h:message for="price" />
			</div>
			<div>
				Quantity:
				<h:inputText value="#{productController.quantity}" required="true"
					requiredMessage="Quantity is mandatory"
					converterMessage="Quantity must be an integer number" id="quantity" />
				<h:message for="quantity" />
			</div>
			<div>
				Description:
				<h:inputTextarea value="#{productController.description}"
					required="false" cols="20" rows="5" />

			</div>

			<div>
				<h:commandButton value="Submit"
					action="#{productController.createProduct}" />
			</div>

		</h:form>
	</f:view>
</body>
</html>