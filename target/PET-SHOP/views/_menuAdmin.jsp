<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
<script type="text/javascript" src="<c:url value="/resources/js/jquery.1.10.2.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	
<title>Menu Admin Page</title>
</head>
<body>
	
	<div class="panel panel-default">  
		<div id="header" class="panel-heading h5 text-center">Admin Management</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ADMIN MANAGEMENT</th>
					</tr>
				<thead>
					<tr>
						<td><a class="nav-link" href="${pageContext.request.contextPath}/admin/getListUser">User Management</a></td>
					</tr>
					<tr>
						<td><a class="nav-link" href="${pageContext.request.contextPath}/product/">Product Management</a></td>
					</tr>
					<tr>
						<td><a class="nav-link" href="${pageContext.request.contextPath}/admin/getListCategory">Category Management</a></td>
					</tr>
			</table>
		</div>
	</div>

</body>
</html>