<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Suspended Order</title>
</head>
<body>

	<f:view>
		<h1><b>you do not have enough products in stock</b></h1>
		<h2>You don't evade this order!</h2>
		<ul>
			<li><a href='<c:url value="/faces/adminHome.jsp" />'>Back To
					Home Admin</a></li>
		</ul>
	</f:view>
</body>
</html>
