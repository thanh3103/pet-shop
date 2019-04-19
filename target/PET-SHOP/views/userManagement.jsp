<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/user.js" />"></script>
<title>User Management</title>
</head>
<body>
	<div class="panel panel-default">
		<div id="abc" class="panel-heading h3 text-center">
			List of Users
		</div>
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
			<div>
<!-- 				<div> -->
<%-- 					<c:forEach varStatus="loop" begin="0" end="${pages}"> 							 --%>
<%-- 						<a href="${pageContext.request.contextPath}/product/?page=${loop.count}" > --%>
<!-- 							<button type="button" class="btn btn-secondary"> -->
<%-- 								<c:out value="${loop.count}"/> --%>
<!-- 							</button> -->
<!-- 						</a> -->
<%-- 					</c:forEach> --%>
<!-- 				</div> -->
				<div>
					<button onclick="location.href='${pageContext.request.contextPath}/admin/addAdmin'" class="btn btn-primary">
						<span>Add New Admin</span>
					</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>