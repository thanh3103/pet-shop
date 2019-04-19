<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<!-- Meta -->
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <meta name="keywords" content="MediaCenter, Template, eCommerce">
        <meta name="robots" content="all">

        <title>MediaCenter - Responsive eCommerce Template</title>

        <!-- Bootstrap Core CSS -->
        <link rel="stylesheet" href='<c:url value="/resources/assets/css/bootstrap.min.css"/>'>
        
        <!-- Customizable CSS -->
        <link rel="stylesheet" href='<c:url value="/resources/assets/css/main.css"/>'>
        <link rel="stylesheet" href='<c:url value="/resources/assets/css/green.css"/>'>
        <link rel="stylesheet" href='<c:url value="/resources/assets/css/owl.carousel.css"/>'>
        <link rel="stylesheet" href='<c:url value="/resources/assets/css/owl.transitions.css"/>'>
        <link rel="stylesheet" href='<c:url value="/resources/assets/css/animate.min.css"/>'>

		<script type="text/javascript" src='<c:url value="/resources/js/ajax.min.js"/>'></script>
		<link rel="stylesheet" href='<c:url value="/resources/css/font-awesome.min.css"/>'>
        <!-- Demo Purpose Only. Should be removed in production -->
        <link rel="stylesheet" href='<c:url value="/resources/assets/css/config.css"/>'>

        <link href="<c:url value="/resources/assets/css/green.css"/>" rel="alternate stylesheet" title="Green color">
        <link href="<c:url value="/resources/assets/css/blue.css"/>" rel="alternate stylesheet" title="Blue color">
        <link href="<c:url value="/resources/assets/css/red.css"/>" rel="alternate stylesheet" title="Red color">
        <link href="<c:url value="/resources/assets/css/orange.css"/>" rel="alternate stylesheet" title="Orange color">
        <link href="<c:url value="/resources/assets/css/navy.css"/>" rel="alternate stylesheet" title="Navy color">
        <link href="<c:url value="/resources/assets/css/dark-green.css"/>" rel="alternate stylesheet" title="Darkgreen color">
        <!-- Demo Purpose Only. Should be removed in production : END -->

        <!-- Fonts -->
        <link rel="stylesheet" href='<c:url value="/resources/css/css2.css"/>'>
        
        <!-- Icons/Glyphs -->
        <link rel="stylesheet" href='<c:url value="/resources/assets/css/font-awesome.min.css"/>'>
        
        <!-- Favicon -->
        <link rel="stylesheet" href='<c:url value="/resources/assets/images/favicon.ico"/>'>

        <!-- HTML5 elements and media queries Support for IE8 : HTML5 shim and Respond.js -->
        <!--[if lt IE 9]>
            <script src="assets/js/html5shiv.js"></script>
            <script src="assets/js/respond.min.js"></script>
        <![endif]-->
        <script type="text/javascript" src="<c:url value="/resources/js/register.js" />"></script>
</head>
<body>
<nav class="top-bar animate-dropdown">
    <div class="container">
        <div class="col-xs-12 col-sm-6 no-margin">
            <ul>
                <li><a href="${pageContext.request.contextPath}/">Home</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle"  data-toggle="dropdown" href="#change-colors">Change Colors</a>

                    <ul class="dropdown-menu" role="menu" >
                        <li role="presentation"><a role="menuitem" class="changecolor green-text" tabindex="-1" href="#" title="Green color">Green</a></li>
                        <li role="presentation"><a role="menuitem" class="changecolor blue-text" tabindex="-1" href="#" title="Blue color">Blue</a></li>
                        <li role="presentation"><a role="menuitem" class="changecolor red-text" tabindex="-1" href="#" title="Red color">Red</a></li>
                        <li role="presentation"><a role="menuitem" class="changecolor orange-text" tabindex="-1" href="#" title="Orange color">Orange</a></li>
                        <li role="presentation"><a role="menuitem" class="changecolor navy-text" tabindex="-1" href="#" title="Navy color">Navy</a></li>
                        <li role="presentation"><a role="menuitem" class="changecolor dark-green-text" tabindex="-1" href="#" title="Darkgreen color">Dark Green</a></li>
                    </ul>
                </li>
                <li><a href="index.php?page=blog">Blog</a></li>
                <li><a href="index.php?page=contact">Contact Us</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#pages">Pages</a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="index.html">Home</a></li>
                        <li><a href="index-2.html">Home Alt</a></li>
                        <li><a href="category-grid.html">Category - Grid/List</a></li>
                        <li><a href="category-grid-2.html">Category 2 - Grid/List</a></li>
                        <li><a href="single-product.html">Single Product</a></li>
                        <li><a href="single-product-sidebar.html">Single Product with Sidebar</a></li>
                        <li><a href="cart.html">Shopping Cart</a></li>
                        <li><a href="checkout.html">Checkout</a></li>
                        <li><a href="about.html">About Us</a></li>
                        <li><a href="contact.html">Contact Us</a></li>
                        <li><a href="blog.html">Blog</a></li>
                        <li><a href="blog-fullwidth.html">Blog Full Width</a></li>
                        <li><a href="blog-post.html">Blog Post</a></li>
                        <li><a href="faq.html">FAQ</a></li>
                        <li><a href="terms.html">Terms & Conditions</a></li>
                        <li><a href="authentication.html">Login/Register</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.col -->

        <div class="col-xs-12 col-sm-6 no-margin">
            <ul class="right">
                <li>
                    <a class="dropdown-toggle"  data-toggle="dropdown" href="#change-language">English</a>
                </li>
                <li>
                    <a class="dropdown-toggle"  data-toggle="dropdown" href="#change-language">Tiếng Việt</a>
                </li>
                <c:choose>
                	<c:when test="${not empty pageContext.request.userPrincipal.name}">
                		<li>Welcome : ${pageContext.request.userPrincipal.name}</li>
                		<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                	</c:when>
                	<c:otherwise>
               			<li><a href="${pageContext.request.contextPath}/register/">Register</a></li>
                		<li><a href="${pageContext.request.contextPath}/login">Login</a></li>
                	</c:otherwise>	
                </c:choose>
            </ul>
        </div><!-- /.col -->
    </div><!-- /.container -->
</nav><!-- /.top-bar -->
<main id="authentication" class="inner-bottom-md">
	<div class="container">
		<div class="row">
			
			<div class="col-md-12">
				<section class="section sign-in inner-right-xs">
					<h2 class="bordered" style="text-align: center">Create New Account</h2>

					<form:form role="form" class="login-form cf-style-1" action="register/save" method="post" modelAttribute="user">
						<form:input path="id" type="hidden" />
						<div class="field-row">
                            <label>Email</label>
                            <form:input path="email" type="text" class="le-input" name="email" id="email" onmouseover="validateEmail();"></form:input>
                        	<p id="emailValidate"></p>
                        </div>
                        
                        <div class="field-row">
                            <label>First Name</label>
                            <form:input path="firstName" type="text" class="le-input" name="firstName" id="firstName" onmouseover="validateFirstName();"></form:input>
                        	<p id="firstNameValidate"></p>
                        </div>
                        
                        <div class="field-row">
                            <label>Last Name</label>
                            <form:input path="lastName" type="text" class="le-input" name="lastName" id="lastName" onmouseover="validateLastName();"></form:input>
                        	<p id="lastNameValidate"></p>
                        </div>
                        
                        <div class="field-row">
                            <label>Age</label>
                            <form:input path="age" type="text" class="le-input" name="age" id="age" onmouseover="validateAge();"></form:input>
                        	<p id="ageValidate"></p>
                        </div>
						
						<div class="field-row">
                            <label>Username</label>
                            <form:input path="userName" type="text" class="le-input" name="userName" id="userName" onmouseover="validateUser();"></form:input>
                        	<p id="userValidate"></p>
                        </div>

                        <div class="field-row">
                            <label>Password</label>
                            <form:input path="passWord" type="password" class="le-input" name="passWord" id="passWord" onmouseover="validatePassWord();"></form:input>
                        	<p id="passValidate"></p>
                        </div>
                        
                        <div class="field-row">
                            <label>Phone Number</label>
                            <form:input path="phoneNo" type="text" class="le-input" name="phoneNo" id="phoneNo" onmouseover="validatePhoneNo();"></form:input>
                        	<p id="phoneNoValidate"></p>
                        </div>

                        <div class="buttons-holder">
                            <button type="submit" class="btn btn-primary">
								<spring:message code="register.btn.register" />
							</button>
							<button type="reset" class="btn btn-warning">
								<spring:message code="register.btn.reset" />
							</button>
							<button type="button" onclick="location.href='./'" class="btn btn-danger">
								<spring:message code="register.btn.cancel" />
							</button>
                        </div>
					</form:form><!-- /.cf-style-1 -->

				</section><!-- /.sign-in -->
			</div><!-- /.col -->
		</div>
	</div>
</main>
</body>
</html>