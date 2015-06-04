<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Registered Customer</title>
</head>
<body>
<f:view>
<h1><b>Your registration was successful!!</b></h1>
<a href='<c:url value="/faces/customerHome.jsp" />'>Go Home</a>
</f:view>
</body>
</html>
