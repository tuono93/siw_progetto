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
<<<<<<< HEAD
		<b>Are you sure to delete current order, ${customerManager.currentCustomer.firstname}?</b>
=======
		<b>Are you sure to delete current order?, ${customerManager.currentCustomer.firstname}</b>
>>>>>>> branch 'master' of https://github.com/tuono93/siw_progetto.git
	</h2>
	<h:form>

		<div><a href='<c:url value="/faces/shoppingCart.jsp" />'>No</a>      <h:commandLink action="#{orderController.deleteCurrentOrder}"
				value="Yes">
			</h:commandLink></div>

</h:form>
</f:view>
</body>
</html>