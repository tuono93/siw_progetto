<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Product</title>
</head>
<body>
<f:view>
<h1>${productController.productDescription.name}</h1>
<h2>Details</h2>
<div>Code: ${productController.productDescription.code}</div>
<div>Price: ${productController.productDescription.price}</div>
<div>Description: ${productController.productDescription.description}</div>

<div>
		<a href="javascript:history.go(-1);">Back</a>
	</div>
</f:view>
</body>
</html>