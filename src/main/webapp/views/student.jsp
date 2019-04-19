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
<script type="text/javascript" src="<c:url value="/resources/js/students.js" />"></script>
<title><spring:message code="student.label" /></title>
</head>
<body>
	<form action="search" method="post">
		Search: <input type="text" id="searchForm" name="searchForm" />
	</form>
	<div class="panel panel-default">
		<div id="abc" class="panel-heading h3 text-center">
			<spring:message code="student.header" />
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th><spring:message code="student.table.id" /></th>
						<th><spring:message code="student.table.name" /></th>
						<th><spring:message code="student.table.age" /></th>
						<th><spring:message code="student.table.address" /></th>
						<th><spring:message code="student.table.action" /></th>
					</tr>
				<thead>
				<c:choose>
	  				<c:when test="${!empty students}">
						<c:forEach items="${students}" var="student">
							<tr>
								<td>${student.id}</td>
								<td>${student.firstName} ${student.lastName}</td>
								<td>${student.age}</td>
								<td>${student.address.street}, ${student.address.district}, ${student.address.city}</td>
								<td>
									<button class="btn btn-info" onclick="getStudent(${student.id}, 'VIEW');">
										<spring:message code="student.btn.view" />
									</button>
									<button class="btn btn-primary" onclick="getStudent(${student.id}, 'EDIT');">
										<spring:message code="student.btn.edit" />
									</button>
									<button class="btn btn-danger" onclick="deleteStudent(${student.id});">
										<spring:message code="student.btn.delete" />
									</button>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<th colspan="5" class="text-center"><spring:message code="student.table.empty" /></th>
						</tr>
					</c:otherwise>
				</c:choose>
				<tr>
					<th colspan="5">
						<button onclick="location.href='addStudent'" class="btn btn-primary">
							<spring:message code="student.btn.add" />
						</button>
					</th>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>