<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>e-Market</title>
</head>
<body>
<h1><b>Product Catalog</b></h1>
<f:view>
		<ul>
		<c:forEach var="product" items="#{productController.getProductCatalog()}">
		<li><h:form><h:commandLink
							action="#{productController.details}"
							value="#{product.name}">
							<f:setPropertyActionListener target="#{productController.productDescription}" value="#{product}" />
						</h:commandLink></h:form></li>
		</c:forEach>
		</ul>
	<div>
		<a href="javascript:history.go(-1);">Back</a>
	</div>
	</f:view>
</body>
</html>