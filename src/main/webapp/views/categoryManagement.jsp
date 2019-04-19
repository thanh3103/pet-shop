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
<script type="text/javascript" src="<c:url value="/resources/js/categories.js" />"></script>
<title><spring:message code="category.label" /></title>
</head>
<body>
	<form action="search" method="post">
		Search: <input type="text" id="searchForm" name="searchForm" />
	</form>
	<div class="panel panel-default">  
		<div id="abc" class="panel-heading h3 text-center">
			<spring:message code="category.header" />
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th><spring:message code="category.table.id" /></th>
						<th><spring:message code="category.table.categoryName" /></th>
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
							<th colspan="5" class="text-center"><spring:message code="category.table.empty" /></th>
						</tr>
					</c:otherwise>
				</c:choose>
				<tr>
					<th colspan="5">
						<button onclick="location.href='addCategory'" class="btn btn-primary">
							Add New Category
						</button>
					</th>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>