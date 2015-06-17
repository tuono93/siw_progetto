<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>non Existing Orders</title>
</head>
<body>
<f:view>
<h1><b>Non existing orders</b></h1>
<h2>You don't have closed orders</h2>
<ul>
			<li><a href='<c:url value="/faces/adminHome.jsp" />'>Go home</a></li>
		</ul>
</f:view>
</body>
</html>
