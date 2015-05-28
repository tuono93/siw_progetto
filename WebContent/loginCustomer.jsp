<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Customer</title>
</head>
<body>
<h1><b>Welcome in e-Market</b></h1>
	<f:view>
		<h:form>
			<div>
				e-mail:
				<h:inputText value="#{customerController.email}" required="true"
					requiredMessage="Insert your e-mail" id="email" />
				<h:message for="email" />
			</div>
			<div>
				Password:
				<h:inputSecret value="#{customerController.password}"
					required="true" requiredMessage="Insert your password"
					id="password" />
				<h:message for="password" />
			</div>
			<div>
		<a href="customerController.jsp"><input type="button" value="Login" name="Login"/></a>
	</div>
		</h:form>
	</f:view>
</body>
</html>
