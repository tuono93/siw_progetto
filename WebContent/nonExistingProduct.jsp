<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>e-Market</title>
</head>
<body>
<f:view>
<h1><b>Non existing product</b></h1>
<h2>The product you've inserted was not found in our product catalog</h2>
<ul>
			<li><a href='<c:url value="/faces/customerHome.jsp" />'>Go home</a></li>
		</ul>
		<ul>
			<li><a href="javascript:history.go(-1);">Insert another product</a></li>
		</ul>
</f:view>
</body>
</html>