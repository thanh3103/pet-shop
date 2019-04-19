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
	
<title>Product Details</title>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading h3 text-center">Product Details</div>
		
		<div class="panel-body">

			<form:form class="form-horizontal" modelAttribute="product" >

				<!-- Image -->
				<div class="col-sm-4">
					<label class="control-label col-sm-4" for="images"></label>
					<div class="col-sm-6">
						<img src="data:image/jpeg;base64, ${product.base64ImageFile}" height=300px width=300px alt="No image">
					</div>
				</div>
				
				<div class="col-sm-8">
				
					<div class="form-group">
						<label class="control-label col-sm-4" for="productID" style="text-align: right"> 
							Product ID:
						</label>
						<div class="col-sm-6">
							<form:input path="productID" type="text" class="form-control"
								id="productID" name="productID" readonly="${role == 'ADMIN'}" />
						</div>
					</div>
				
					<div class="form-group">
						<label class="control-label col-sm-4" for="productName" style="text-align: right"> 
							Name:
						</label>
						<div class="col-sm-6">
							<form:input path="productName" type="text" class="form-control"
								id="productName" name="productName" placeholder="${productName_plhd}" readonly="${role == 'ADMIN'}" />
						</div>
					</div>
				
					<div class="form-group">
						<label class="control-label col-sm-4" for="price" style="text-align: right">
							Price:
						</label>
						<div class="col-sm-6">
							<form:input path="price" type="text" class="form-control"
								id="price" name="price" placeholder="${price_plhd}" readonly="${role == 'ADMIN'}" />
						</div>
					</div>
				
					<div class="form-group">
						<label class="control-label col-sm-4" for="unitInStock" style="text-align: right">
							Unit in Stock:
						</label>
						<div class="col-sm-6">
							<form:input path="unitInStock" type="text" class="form-control"
								id="unitInStock" name="unitInStock" placeholder="${unitInStock_plhd}" readonly="${role == 'ADMIN'}" />
						</div>
					</div>
				
					<div class="form-group">
						<label class="control-label col-sm-4" for="description" style="text-align: right">
							Description:
						</label>
						<div class="col-sm-6">
							<form:input path="description" type="text" class="form-control"
								id="description" name="description" placeholder="${description_plhd}" readonly="${role == 'ADMIN'}" />
						</div>
					</div>
				
<!-- 					<div class="form-group"> -->
<!-- 						<label class="control-label col-sm-4" for="description" style="text-align: right"> -->
<!-- 							Category: -->
<!-- 						</label> -->
<!-- 						<div class="col-sm-6"> -->
<%-- 							<form:input path="description" type="text" class="form-control" --%>
<%-- 								id="description" name="description" placeholder="${description_plhd}" readonly="${role == 'ADMIN'}" /> --%>
<!-- 						</div> -->
<!-- 					</div> -->
				
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-6">
							<button type="button" onclick="location.href='./'" class="btn btn-default">
								Back
							</button>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>