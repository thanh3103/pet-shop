<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
<script type="text/javascript" src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<title>Category Detail</title>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading h3 text-center">
			Category Detail
		</div>
		<div class="panel-body">

			<form:form class="" action="./saveCategory" method="post" modelAttribute="category">
				
				<form:input path="id" type="hidden"/>
				
				<div class="form-group">
					<div class="">
					<label class="control-label col-sm-4" for="categoryName" style="text-align: right"> 
						Category Name:
					</label>
					<div class="col-sm-6">
						<form:input path="categoryName" type="text" class="form-control"
							id="categoryName" name="categoryName" placeholder="Insert category name" />
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-6">
						<button type="submit" class="btn btn-primary">
							Save
						</button>
						<button type="button" onclick="location.href='./'"
							class="btn btn-default">
							Cancel
						</button>
					</div>
				</div>
			</div>
			</form:form>
		</div>
	</div>		
</body>
</html>