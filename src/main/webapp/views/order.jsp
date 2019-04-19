<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
<script type="text/javascript" src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/products.js" />"></script>
</head>
<body>
	<div class="panel panel-default">  
		<div id="abc" class="panel-heading h3 text-center">
			Order Page
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>User Name</th>
						<th>Total Price</th>
						<th>Date</th>
						<th>Action</th>
					</tr>
				<thead>
						<tr>
							<td>${order.user.userName}</td>
							<td>${order.totalPrice}</td>	
							<td>${order.createDate}</td>
						</tr>
					<tr>
						<td>Total</td>
					</tr>
					<tr>
						<td>
<!-- 						<div class="col-sm-6"> -->
<%-- 							<form:input path="totalPrice" type="text" class="form-control" --%>
<%-- 							id="totalPrice" name="totalPrice" value="${order.totalPrice}"/> --%>
<!-- 						</div> -->
						</td>
					</tr>
					<tr>
					<th colspan="5">
						<button onclick="location.href='${pageContext.request.contextPath}/product/'" class="btn btn-success">
							Back to shopping
						</button>
						<input type="submit" value="Payment"/>
					</th>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>