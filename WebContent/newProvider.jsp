<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Provider</title>

</head>
<body>
	<h1>
		<b>Insert a new Provider:</b>
	</h1>
	<f:view>
		<h:form>
		<div>Code: ${productController.vatin}</div>
			<div>
				Name:
				<h:inputText value="#{productController.nameProvider}" required="true"
					requiredMessage="Name is mandatory" id="nameProvider" />
				<h:message for="nameProvider" />
			</div>
			<div>
				Email:
				<h:inputTextarea value="#{productController.email}"
				    required="true"
					requiredMessage="Email is mandatory" id="emailProvider" />
				<h:message for="emailProvider" />
			</div>
			
			<div>
				Phone Number:
				<h:inputText value="#{productController.phoneNumber}" required="true"
					requiredMessage="Phone Number is mandatory" id="phoneNumber" />
				<h:message for="phoneNumber" />
			</div>
			
			<div>
				Street:
				<h:inputText value="#{productController.street}" required="true"
					requiredMessage="Street is mandatory" id="street" />
				<h:message for="street" />
			</div>
			
			<div>
				House Number:
				<h:inputText value="#{productController.houseNumber}" required="true"
					requiredMessage="House Number is mandatory" id="houseNumber" />
				<h:message for="houseNumber" />
			</div>
			<div>
				Zip Code:
				<h:inputText value="#{productController.zipCode}" required="true"
					requiredMessage="Zip Code is mandatory" 
					validatorMessage="Zip Code must be of 5 characters" id="zipCode">
					<f:validateLength minimum="5" maximum="5" />
					</h:inputText>
				<h:message for="zipCode" />
			</div>
			
			<div>
				City:
				<h:inputText value="#{productController.city}" required="true"
					requiredMessage="City is mandatory" id="city" />
				<h:message for="city" />
			</div>
			<div>
				Country:
				<h:inputText value="#{productController.country}" required="true"
					requiredMessage="Country is mandatory" id="country" />
				<h:message for="country" />
			</div>
			

			<div>
				<h:commandButton value="Submit"
					action="#{productController.createProvider}" />
			</div>

		</h:form>
	</f:view>
</body>
</html>