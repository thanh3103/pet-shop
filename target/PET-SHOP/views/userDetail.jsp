<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    
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
<title>User Detail</title>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading h3 text-center">
			USER DETAIL
		</div>
		<div class="panel-body">

			<form:form class="form-horizontal" modelAttribute="user">
				
				<div class="form-group">
					<label class="control-label col-sm-4" for="userID" style="text-align: right"> 
						User ID:
					</label>
					<div class="col-sm-6">
						<form:input path="userID" type="text" class="form-control"
							id="userID" name="userID" readonly="${role == 'ADMIN'}" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="userEmail" style="text-align: right"> 
						User Email:
					</label>
					<div class="col-sm-6">
						<form:input path="userEmail" type="text" class="form-control"
							id="userEmail" name="userEmail" readonly="${role == 'ADMIN'}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="userName" style="text-align: right"> 
						User Name:
					</label>
					<div class="col-sm-6">
						<form:input path="userName" type="text" class="form-control"
							id="userName" name="userName" readonly="${role == 'ADMIN'}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="firstName" style="text-align: right"> 
						First Name:
					</label>
					<div class="col-sm-6">
						<form:input path="firstName" type="text" class="form-control"
							id="firstName" name="firstName" readonly="${role == 'ADMIN'}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="lastName" style="text-align: right"> 
						Last Name:
					</label>
					<div class="col-sm-6">
						<form:input path="lastName" type="text" class="form-control"
							id="lastName" name="lastName" readonly="${role == 'ADMIN'}" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4" for="code" style="text-align: right"> 
						Code:
					</label>
					<div class="col-sm-6">
						<form:input path="address.code" type="text" class="form-control"
							id="code" name="code" readonly="${role == 'ADMIN'}" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4" for="street" style="text-align: right"> 
						Street:
					</label>
					<div class="col-sm-6">
						<form:input path="address.street" type="text" class="form-control"
							id="street" name="street" readonly="${role == 'ADMIN'}" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="district" style="text-align: right"> 
						District:
					</label>
					<div class="col-sm-6">
						<form:input path="address.district" type="text" class="form-control"
							id="district" name="district" readonly="${role == 'ADMIN'}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="city" style="text-align: right"> 
						City:
					</label>
					<div class="col-sm-6">
						<form:input path="address.city" type="text" class="form-control"
							id="city" name="city" readonly="${role == 'ADMIN'}" />
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-6">
						<button type="button" onclick="location.href='./'" class="btn btn-default">
							<span>Back</span>
						</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>