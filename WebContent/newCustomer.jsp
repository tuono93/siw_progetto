<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>New Customer</title>
</head>
<body>
	<f:view>
		<h:form>
			<div>
				Firstname:
				<h:inputText value="#{customerController.firstname}" required="true"
					requiredMessage="Firstname is mandatory" id="firstname" />
				<h:message for="firstname" />
			</div>
			
           <div>
				Lastname:
				<h:inputText value="#{customerController.lastname}" required="true"
					requiredMessage="Lastname is mandatory" id="lastname" />
				<h:message for="lastname" />
			</div>
			<div>
				email:
				<h:inputText value="#{customerController.email}" required="true"
					requiredMessage="email is mandatory" id="email" />
				<h:message for="email" />
			</div>
			<div>
				Password:
				<h:inputSecret value="#{customerController.password}"
					required="true" requiredMessage="Password is mandatory"
					validatorMessage="Password: min 6 characters"
					id="password"> 
					<f:validateLength minimum="6" maximum="6"/>
					</h:inputSecret>
				<h:message for="password" />
			</div>
			<div>
				Fiscal Code:
				<h:inputText value="#{customerController.fc}" required="true"
					requiredMessage="Fiscal Code is mandatory"
					validatorMessage="Fiscal Code must be of 16 characters"
					id="fiscalcode">
					<f:validateLength minimum="16" maximum="16" />
					</h:inputText>
				<h:message for="fiscalcode" styleClass="error" />
			</div>



			<div>
				Date of birth:
				<h:inputText value="#{customerController.dateOfBirth}"
					required="true" requiredMessage="Date of birth is mandatory"
					converterMessage="Date of birth must be a date" id="dateOfBirth">
					<f:convertDateTime pattern="dd/mm/yyyy"/>
					</h:inputText>
				<h:message for="dateOfBirth" />
			</div>
			<div>
				Street:
				<h:inputText value="#{customerController.street}" required="true"
					requiredMessage="Street is mandatory" id="street" />
				<h:message for="street" />
			</div>
			
			<div>
				House Number:
				<h:inputText value="#{customerController.houseNumber}" required="true"
					requiredMessage="House Number is mandatory" id="houseNumber" />
				<h:message for="houseNumber" />
			</div>
			<div>
				Zip Code:
				<h:inputText value="#{customerController.zipCode}" required="true"
					requiredMessage="Zip Code is mandatory" 
					validatorMessage="Zip Code must be of 5 characters" id="zipCode">
					<f:validateLength minimum="5" maximum="5" />
					</h:inputText>
				<h:message for="zipCode" />
			</div>
			
			<div>
				City:
				<h:inputText value="#{customerController.city}" required="true"
					requiredMessage="City is mandatory" id="city" />
				<h:message for="city" />
			</div>
			<div>
				Country:
				<h:inputText value="#{customerController.country}" required="true"
					requiredMessage="Country is mandatory" id="country" />
				<h:message for="country" />
			</div>
			
			
			<div>
				<h:commandButton value="Sign up" action="#{customerController.createCustomer}" />
			</div>
		</h:form>
	</f:view>
</body>
</html>
