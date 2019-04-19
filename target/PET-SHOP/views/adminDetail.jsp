<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
<script type="text/javascript" src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>

<%-- <script type="text/javascript" src="<c:url value="/resources/js/register.js" />"></script> --%>

<title>Add New Admin</title>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading h3 text-center">Admin Details</div>
		<div class="panel-body">
			<form:form class="form-horizontal" action="./saveAdmin" method="post" modelAttribute="user">
				
				<form:input path="id" type="hidden" />
				
				<!-- Email -->
				<div class="form-group">
					<label class="control-label col-sm-4" for="userEmail">Email:</label>
					<div class="col-sm-5">
						<form:input path="email" type="text" onkeyup="validationEmail()" class="form-control" id="userEmail" name="userEmail" />
					</div>
					<div><p id="responseEmail" class="text-danger" /></div>
				</div>
				
				<!-- UserName -->
				<div class="form-group">
					<label class="control-label col-sm-4" for="userName">Username:</label>
					<div class="col-sm-5">
						<form:input path="userName" type="text" onkeyup="validationUserName()" class="form-control" id="userName" name="userName" />
					</div>
					<div><p id="responseUserName" class="text-danger" /></div>
				</div>
				
				<!-- PassWord -->
				<div class="form-group">
					<label class="control-label col-sm-4" for="pwd">Password:</label>
					<div class="col-sm-5">
						<form:input path="passWord" type="password" class="form-control" id="passWord" name="passWord" />
					</div>
				</div>
				
				<!-- First Name -->
				<div class="form-group">
					<label class="control-label col-sm-4" for="firstName">First Name:</label>
					<div class="col-sm-5">
						<form:input path="firstName" type="text" class="form-control" id="firstName" name="firstName" />
					</div>
				</div>
				
				<!-- Last Name -->
				<div class="form-group">
					<label class="control-label col-sm-4" for="lastName">Last Name:</label>
					<div class="col-sm-5">
						<form:input path="lastName" type="text" class="form-control" id="lastName" name="lastName" />
					</div>
				</div>
				
				<!-- Role -->
				<div class="form-group">
					<div class="col-sm-5">
						<form:input path="userRole" type="hidden" class="form-control" id="userRole" name="userRole" value="ROLE_ADMIN" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-5">
						<button type="submit" class="btn btn-primary">Add</button>
						
						<button type="button" onclick="location.href='./'" class="btn btn-danger">Cancel</button>
						
						<button type="reset" class="btn btn-warning">Reset</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>