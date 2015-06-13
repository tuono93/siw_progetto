<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Failed Login</title>
</head>
<body>
<f:view>
<h1><b>Failed Login. Please choose an action.</b></h1>
<ul>
			<li><a href='<c:url value="/faces/generalHome.jsp" />'>Go general home</a></li>
		</ul>
		<ul>
			<li><a href="javascript:history.go(-1);">Try again to log in</a></li>
		</ul>
</f:view>
</body>
</html>