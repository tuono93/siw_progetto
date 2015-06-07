<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Administrator</title>
</head>
<body>
<h1><b>Enter the admin password:</b></h1>
	<f:view>
		<h:form>
			<div>
				Password:
				<h:inputSecret value="#{administratorController.password}"
					required="true" requiredMessage="Insert the admin password"
					validatorMessage="Insert the correct Password"
					id="password" >
				<f:validateRegex pattern="emarket" />
				</h:inputSecret>
				<h:message for="password" />
			</div>
			<div>
				<h:commandButton value="Sign up" action="#{administratorController.convalidatePassword}" />
			</div>
		</h:form>
	</f:view>
</body>
</html>
