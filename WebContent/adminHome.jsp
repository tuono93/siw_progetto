<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
<h1><b>You logged as Admin:</b></h1>
<f:view>
	    <ul>
			<li><a href='<c:url value="/faces/productDescriptionCode.jsp" />'>Insert product</a></li>
		</ul>
		<ul>
			<li><a href='<c:url value="/faces/productCatalog.jsp" />'>View the product catalog</a></li>	
		</ul>
</f:view>
</body>
</html>