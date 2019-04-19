<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
<script type="text/javascript" src="<c:url value="/resources/js/jquery.1.10.2.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/admin.js"/>"></script>
	
<title>Admin Page</title>
</head>
<body>
	<jsp:include page="_menu.jsp" />

	<div id="header" class="panel-heading h3 text-center">Admin Page</div>

	<div class="col-sm-3">
		<jsp:include page="_menuAdmin.jsp" />
	</div>
	
	<div class="col-sm-9">
		
<!-- Start User Members -->
		<div class="panel panel-default">
		
		<div id="header" class="panel-heading h5 text-center">Users</div>
		
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>User Name</th>
						<th>User Email</th>
						<th>Full Name</th>
						<th>Code</th>
						<th>Street</th>
						<th>District</th>
						<th>City</th>
						<th>Action</th>
					</tr>
				<thead>
					<c:choose>
						<c:when test="${!empty users}">
							<c:forEach items="${users}" var="user">
								<tr>
									<td>${user.id}</td>
									<td>${user.userName}</td>
									<td>${user.email}</td>
									<td>${user.firstName} ${user.lastName}</td>
									<td>${user.address.code}</td>
									<td>${user.address.street}</td>
									<td>${user.address.district}</td>
									<td>${user.address.city}</td>
									<td>
										<button class="btn btn-info"
											onclick="getUser(${user.id}, 'ADMIN');">
											User's Info
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
				</thead>
			</table>
		</div>
		</div>
		<hr>
<!-- End User Members -->

<!-- Start Product Member -->
	<div class="panel panel-default">
		<div id="header" class="panel-heading h5 text-center">Products</div>
		
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Product ID</th>
						<th>Product Name</th>
						<th>Product Price</th>
						<th>Description</th>
						<th>Images</th>
						<th>Action</th>
					</tr>
				<thead>
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
										<%-- ${product.images} --%> <img
										src="data:image/jpeg;base64,${product.base64ImageFile}" height=30px
										width=30px alt="No image">
									</td>
									<td>
										<button class="btn btn-info"
											onclick="getProduct(${product.id}, 'ADMIN');">
											VIEW
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
<!-- End Product Members -->

<!-- Start Category -->
	<div class="panel panel-default">  
		<div id="header" class="panel-heading h5 text-center">Categories</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Category ID</th>
						<th>Category Name</th>
					</tr>
				<thead>
				<c:choose>
	  				<c:when test="${!empty categories}">
						<c:forEach items="${categories}" var="category">
							<tr>
								<td>${category.id}</td>
								<td>${category.categoryName}</td>
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
<!-- End Category -->
		
	</div>
	
<!-- 	<div class="col-sm-3"> -->
<%-- 		<a href="${pageContext.request.contextPath}/admin/getListUser"> --%>
<!-- 			<button type="button" class="btn btn-primary"> -->
<!-- 				<span>User Management</span> -->
<!-- 			</button> -->
<!-- 		</a> -->
<!-- 	</div> -->
	
<!-- 	<div class="col-sm-3"> -->
<%-- 		<a href="${pageContext.request.contextPath}/admin/getListProduct"> --%>
<!-- 			<button type="button" class="btn btn-success"> -->
<!-- 				<span>Product Management</span> -->
<!-- 			</button> -->
<!-- 		</a> -->
<!-- 	</div> -->
	
<!-- 	<div class="col-sm-3"> -->
<%-- 		<a href="${pageContext.request.contextPath}/admin/getListCategory"> --%>
<!-- 			<button type="button" class="btn btn-info"> -->
<!-- 				<span>Category Management</span> -->
<!-- 			</button> -->
<!-- 		</a> -->
<!-- 	</div> -->
	
<!-- 	<div class="col-sm-3"> -->
<%-- 		<a href="${pageContext.request.contextPath}/admin/getListCart"> --%>
<!-- 			<button type="button" class="btn btn-warning"> -->
<!-- 				<span>Cart Management</span> -->
<!-- 			</button> -->
<!-- 		</a> -->
<!-- 	</div> -->


</body>
</html>