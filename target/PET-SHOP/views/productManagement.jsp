<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
<script type="text/javascript"
	src="<c:url value="/resources/js/product.js" />"></script>
<title><spring:message code="product.label" /></title>
</head>
<body>
	
	<form:form action="${pageContext.request.contextPath}/product/search" method="POST" modelAttribute="categories">
		
		<input type="text" id="searchForm" name="searchForm"/>
		
		<form:select path="${category.id}" name="categoryID">
			
			<form:option value="-1">Please Select</form:option>
			<form:options items="${categories}" itemValue="id" itemLabel="categoryName"></form:options>
			
		</form:select>
		
		<button type="submit">
			<span class="glyphicon glyphicon-search"></span>
		</button>
		
	</form:form>
	
	<div class="panel panel-default">
		<div id="abc" class="panel-heading h3 text-center">
			<spring:message code="product.header" />
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th><spring:message code="product.table.id" /></th>
						<th><spring:message code="product.table.productName" /></th>
						<th><spring:message code="product.table.price" /></th>
						<th><spring:message code="product.table.unitInStock" /></th>
						<th><spring:message code="product.table.description" /></th>
						<th>Images</th>
						<th><spring:message code="product.table.action" /></th>
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
								<th colspan="5" class="text-center"><spring:message
										code="product.table.empty" /></th>
							</tr>
						</c:otherwise>
					</c:choose>
					<c:forEach varStatus="loop" begin="0" end="${pages}">
 						<a href="${pageContext.request.contextPath}/product/?page=${loop.count}">
 							<button type="button" class="btn btn-secondary">
 								<c:out value="${loop.count}"/>
 							</button>	
 						</a>
					</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>