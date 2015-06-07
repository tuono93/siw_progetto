<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Description Code</title>
</head>
<body>
<h1><b>Insert code of Product:</b></h1>
<f:view>

		<h:form>
			<div>
				Code:
				<h:inputText value="#{productController.code}" required="true"
					requiredMessage="Code is mandatory" id="code" />
				<h:message for="code" />
			</div>
			 <div>
		 <h:commandButton value="Submit"  action="#{productController.controlExistenceProduct}"/>
	    </div>
</h:form>
</f:view>
</body>
</html>