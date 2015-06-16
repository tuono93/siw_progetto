<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
	<h1>
		<b>You logged as Admin:</b>
	</h1>
	<f:view>
		<h:form>
			<ul>
				<li><h:commandLink
						action="#{administrationController.newCustomer}"
						value="New Customer">
					</h:commandLink></li>
				<li><h:commandLink
						action="#{administrationController.newProduct}"
						value="New Product">
					</h:commandLink></li>

				<li><h:commandLink action="#{orderController.goArchive}"
						value="Orders Archive">
					</h:commandLink></li>

				<li><a href='<c:url value="/faces/productCatalog.jsp" />'>View
						the product catalog</a></li>
				<li><h:commandLink
						action="#{administrationController.listClosedOrders}"
						value="Evade Order">
					</h:commandLink></li>

			</ul>

			<h:commandButton value="Logout"
				action="#{administrationController.logoutAdministration}" />
		</h:form>
	</f:view>
</body>
</html>