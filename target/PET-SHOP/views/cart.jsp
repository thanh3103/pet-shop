<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/products.js" />"></script>
</head>
<body>
	<div class="panel panel-default">
		<div id="abc" class="panel-heading h3 text-center">Shopping Cart
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th><spring:message code="product.table.id" /></th>
						<th><spring:message code="product.table.name" /></th>
						<th><spring:message code="product.table.price" /></th>
						<th>Images</th>
						<th>Quantity</th>
						<th>Total</th>
						<th>Action</th>
					</tr>
				<thead>
					<c:forEach items="${order.listOrderDetail}" var="orderDetail">
						<tr>
							<td>${orderDetail.id}</td>
							<td>${orderDetail.product.productName}</td>
							<td>${orderDetail.product.price}$</td>
							<td><img
								src="data:image/jpeg;base64,${orderDetail.product.base64ImageFile}"
								alt="No image" width="70px" height="50px"></td>
							<td><input type="number" id="quantity_${orderDetail.product.id}"
								value="${orderDetail.quantity}" style="width: 50px" /></td>
							<td>${orderDetail.total}$</td>
							<td><a
								href='<c:url value="/product/remove" />?id=${orderDetail.product.id}'
								class="btn btn-danger" onclick="return confirm('Are you sure?')">Remove</a>

								<a href="#" class="btn btn-primary"
								onclick="update($('#quantity_${orderDetail.product.id}').val(), ${orderDetail.product.id})">Update</a>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>Total Price: ${order.totalPrice}</td>
					</tr>
					<tr>
						<th colspan="5">
							<button
								onclick="location.href='${pageContext.request.contextPath}/product/'"
								class="btn btn-success">Back to shopping</button>
						</th>
						<th colspan="5">
							<button
								onclick="location.href='${pageContext.request.contextPath}/order/addOrder'"
								class="btn btn-info">Payment</button>
						</th>
					</tr>
			</table>
		</div>
	</div>
</body>
</html>