<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Provider Code</title>
</head>
<body>
<f:view>
<h1><b>Now, insert provider code</b></h1>
<h2>Insert vatin of Provider:</h2>
		<h:form>
			<div>
				Vatin:
				<h:inputText value="#{productController.vatin}" required="true"
					requiredMessage="Vatin is mandatory" id="vatin" />
				<h:message for="vatin" />
			</div>
			 <div>
		 <h:commandButton value="Submit"  action="#{productController.createOrAddProvider}"/>
	    </div>
</h:form>
</f:view>
</body>
</html>