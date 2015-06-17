<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Closed Orders</title>
</head>
<body>
<f:view>
<h1><b>Which order do you want to escape?</b></h1>
<ul>
	<c:forEach var="order" items="#{orderController.getClosedOrders()}">
		<li><h:form>
		<h:commandLink action="#{orderController.closedOrderDetails}" value="#{order.id}">
		<f:setPropertyActionListener
								target="#{orderController.order}"
								value="#{order}" />
		</h:commandLink>
		</h:form></li>
	</c:forEach>
</ul>
</f:view>
</body>
</html>