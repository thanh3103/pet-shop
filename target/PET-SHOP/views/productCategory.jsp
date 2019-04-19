<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<title>Product By Category</title>
</head>
<body>
<div class="panel panel-default">
		<div id="abc" class="panel-heading h3 text-center">
			Product By Category
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<c:choose>
	  				<c:when test="${!empty products}">
						<c:forEach items="${products}" var="product">
							<tr>
								<td>${product.id}</td>
								<td>${product.productName}</td>
								<td>${product.price}</td>
								<td>${product.unitInStock}</td>
								<td>${product.description}</td>
								<td>
										<%-- ${product.images} --%>
                                        <img src="data:image/jpeg;base64,${product.base64ImageFile}" height=30px width=30px alt="No image">
                                </td>
								<td>
									<button class="btn btn-info" onclick="getProduct(${product.id}, 'VIEW');">
										View
									</button>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<th colspan="5" class="text-center">Empty</th>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</div>
</body>
</html>