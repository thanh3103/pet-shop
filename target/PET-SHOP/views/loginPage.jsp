<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="_menu.jsp" />


	<h1>Login</h1>

	<!-- /login?error=true -->
	<c:if test="${param.error == 'true'}">
		<div style="color: red; margin: 10px 0px;">

			Login Failed!!!<br /> Reason :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

		</div>
	</c:if>

	<h3>Enter user name and password:</h3>

	<form name='f' action="login" method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='userName' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='passWord' /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>