<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>e-Market</title>
</head>
<body>
	<f:view>
		<h1><b>Welcome in e-Market</b></h1>
		<ul>
			<li><a href='<c:url value="/faces/newCustomer.jsp" />'>Sign up in e-Market</a></li>
		</ul>
		<ul>
			<li><a href='<c:url value="/faces/loginCustomer.jsp" />'>Log in e-Market</a></li>
		</ul>
	</f:view>
</body>
</html>

