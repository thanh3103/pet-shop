<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<title><spring:message code="product.detail.label" /></title>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading h3 text-center">
			<spring:message code="product.detail.label" />
		</div>
		<div class="panel-body">
			<spring:message code="product.detail.name.plhd" var="name_plhd" />
			<spring:message code="product.detail.price.plhd" var="price_plhd" />
			<spring:message code="product.detail.unitInStock.plhd"
				var="unitInStock_plhd" />
			<spring:message code="product.detail.description.plhd"
				var="description_plhd" />
			<spring:message code="product.detail.category.plhd"
				var="category_plhd" />

			<form:form class="form-horizontal" action="./save" method="post"
				modelAttribute="product" enctype="multipart/form-data">
				<form:input path="id" type="hidden" />
				<div class="form-group">
					<label class="control-label col-sm-4" for="name"> <spring:message
							code="product.detail.name" />
					</label>
					<div class="col-sm-6">
						<form:input path="productName" type="text" class="form-control"
							id="productName" name="productName" placeholder="${name_plhd}"
							readonly="${mode == 'VIEW'}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="price"> <spring:message
							code="product.detail.price" />
					</label>
					<div class="col-sm-6">
						<form:input path="price" type="text" class="form-control"
							id="price" name="price" placeholder="${price_plhd}"
							readonly="${mode == 'VIEW'}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="unitInStock"> <spring:message
							code="product.detail.unitInStock" />
					</label>
					<div class="col-sm-6">
						<form:input path="unitInStock" type="text" class="form-control"
							id="unitInStock" name="unitInStock"
							placeholder="${unitInStock_plhd}" readonly="${mode == 'VIEW'}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="description"> <spring:message
							code="product.detail.description" />
					</label>
					<div class="col-sm-6">
						<form:input path="description" type="text" class="form-control"
							id="description" name="description"
							placeholder="${description_plhd}" readonly="${mode == 'VIEW'}" />
					</div>
				</div>
				<!-- Category -->
				
				<div class="form-group">
					<label class="control-label col-sm-4" for="category"> <spring:message
							code="product.detail.category" />
					</label>
					<div class="col-sm-6">
						<form:select path="category.id">
							<form:option value="-1">Please Select</form:option>
							<form:options items="${categories}" itemLabel="categoryName"
								itemValue="id" />
						</form:select>
					</div>
				</div>
				<!-- uploadFile -->

				<div class="form-group">
					<label class="control-label col-sm-4" for="images">
						Images
					</label>
					<div class="col-sm-6">
						<input type="file" class="form-control" name="fileUpload" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-6">
						<c:if test="${mode == 'VIEW'}">
							<button disabled="disabled" type="submit" class="btn btn-primary">
								<spring:message code="product.detail.btn.save" />
							</button>
						</c:if>
						<c:if test="${mode != 'VIEW'}">
							<button type="submit" class="btn btn-primary">
								<spring:message code="product.detail.btn.save" />
							</button>
						</c:if>
						<button type="button" onclick="location.href='./'"
							class="btn btn-default">
							<spring:message code="product.detail.btn.cancel" />
						</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>