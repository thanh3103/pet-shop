<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/w3.css">
<link rel="stylesheet" href="resources/css/cssFamilyLato.css">
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/products.js"></script>
<style type="text/css">
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Lato", sans-serif;
}

body, html {
	height: 100%;
	color: #777;
	line-height: 1.8;
}

/* Create a Parallax Effect */
.bgimg-1, .bgimg-2, .bgimg-3 {
	background-attachment: fixed;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

/* First image (Logo. Full height) */
.bgimg-1 {
	background-image: url('resources/images/tiger.jpg');
	min-height: 100%;
}

.colorCF {
	background-color: #ffffe6;
}

img {
	margin-bottom: 0px;
}
</style>
<script type="text/javascript">
	/* function myMap() {
		myCenter = new google.maps.LatLng(41.878114, -87.629798);
		var mapOptions = {
			center : myCenter,
			zoom : 12,
			scrollwheel : false,
			draggable : false,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(document.getElementById("googleMap"),
				mapOptions);

		var marker = new google.maps.Marker({
			position : myCenter,
		});
		marker.setMap(map);
	} */

	// Modal Image Gallery
	function onClick(element) {
		document.getElementById("img01").src = element.src;
		document.getElementById("modal01").style.display = "block";
		var captionText = document.getElementById("caption");
		captionText.innerHTML = element.alt;
	}

	// Change style of navbar on scroll
	window.onscroll = function() {
		myFunction()
	};
	function myFunction() {
		var navbar = document.getElementById("myNavbar");
		if (document.body.scrollTop > 100
				|| document.documentElement.scrollTop > 100) {
			navbar.className = "w3-bar" + " w3-card" + " w3-animate-top"
					+ " w3-white";
		} else {
			navbar.className = navbar.className.replace(
					" w3-card w3-animate-top w3-white", "");
		}
	}

	// Used to toggle the menu on small screens when clicking on the menu button
	function toggleFunction() {
		var x = document.getElementById("navDemo");
		if (x.className.indexOf("w3-show") == -1) {
			x.className += " w3-show";
		} else {
			x.className = x.className.replace(" w3-show", "");
		}
	}
</script>
<title>HomePage</title>
</head>
<body>
	<!-- Navbar (sit on top) -->
	<div class="w3-top">
		<div class="w3-bar" id="myNavbar">
			<a
				class="w3-bar-item w3-button w3-hover-black w3-hide-medium w3-hide-large w3-right"
				href="javascript:void(0);" onclick="toggleFunction()"
				title="Toggle Navigation Menu"> <i class="fa fa-bars"></i>
			</a> <a href="#home" class="w3-bar-item w3-button">HOME</a> <a
				href="./product/" class="w3-bar-item w3-button w3-hide-small"><i
				class="glyphicon glyphicon-th-large"></i> PRODUCT</a> <a
				href="#portfolio" class="w3-bar-item w3-button w3-hide-small"><i
				class="glyphicon glyphicon-send"></i> BOOKING ONLINE</a> 
			<a href="./login"
				class="w3-bar-item w3-button w3-hide-small w3-right"> <span
				class="glyphicon glyphicon-log-in"></span> Login
			</a> 
			<a href="./register" class="w3-bar-item w3-button w3-hide-small w3-right">
				<span class="glyphicon glyphicon-user"></span> Register
			</a> 
			<a href="#" class="w3-bar-item w3-button w3-hide-small w3-right"> 
				<span class="glyphicon glyphicon-log-in"></span> Welcome ${name }
			</a>
			<a href="#" class="w3-bar-item w3-button w3-hide-small w3-right">
				<i class="glyphicon glyphicon-search"></i>
			</a>
		</div>

		<!-- Navbar on small screens -->
		<div id="navDemo"
			class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium">
			<a href="#about" class="w3-bar-item w3-button"
				onclick="toggleFunction()">PRODUCT</a> <a href="#portfolio"
				class="w3-bar-item w3-button" onclick="toggleFunction()">BOOKING ONLINE</a>
			<a href="#contact" class="w3-bar-item w3-button"
				onclick="toggleFunction()">REGISTER</a> 
			<a href="#contact" class="w3-bar-item w3-button"
				onclick="toggleFunction()">LOGIN</a>
				<!-- <a href="#" class="w3-bar-item w3-button">SEARCH</a> -->
		</div>
	</div>

	<!-- First Parallax Image with Logo Text -->
	<div class="bgimg-1 w3-display-container w3-opacity-min" id="home">
		<div class="w3-display-middle" style="white-space: nowrap;">
			<div class="container text-center">
				<h1>GREETINGS FROM</h1>
				<h1>PET SHOP</h1>
				<h4>Everthing for pets</h4>
			</div>
		</div>
	</div>

	<div class="container-fluid colorCF">
		<div class="container text-center">
			<h1>OPENING HOURS</h1>
			<h4>Mon-Fri: 9am - 6pm</h4>
			<h4>Sat: 10am-2pm</h4>
			<h4>Sun: Closed</h4>
			<img src="resources/images/hd.jpg" />
			<h4>Thanks for visiting</h4>
		</div>
	</div>

	<div class="w3-container text-center">
		<h2>Best seller</h2>
	</div>

	<div class="w3-content w3-display-container">

		<div class="w3-display-container mySlides">
			<img src="resources/images/product1.jpg" style="width: 100%" height="500px">
		</div>

		<div class="w3-display-container mySlides">
			<img src="resources/images/product2.jpg" style="width: 100%" height="500px">
		</div>

		<div class="w3-display-container mySlides">
			<img src="resources/images/product3.jpg" style="width: 100%" height="500px">
		</div>

		<button class="w3-button w3-display-left w3-black"
			onclick="plusDivs(-1)">&#10094;</button>
		<button class="w3-button w3-display-right w3-black"
			onclick="plusDivs(1)">&#10095;</button>

	</div>

	<!-- Footer -->
	<footer
		class="w3-center w3-black w3-padding-64 w3-opacity w3-hover-opacity-off">
	<a href="#home" class="w3-button w3-light-grey"><i
		class="fa fa-arrow-up w3-margin-right"></i>To the top</a>
	<div class="w3-xlarge w3-section">
		<i class="fa fa-facebook-official w3-hover-opacity"></i> <i
			class="fa fa-instagram w3-hover-opacity"></i> <i
			class="fa fa-snapchat w3-hover-opacity"></i> <i
			class="fa fa-pinterest-p w3-hover-opacity"></i> <i
			class="fa fa-twitter w3-hover-opacity"></i> <i
			class="fa fa-linkedin w3-hover-opacity"></i>
	</div>
	</footer>
	<script>
		var slideIndex = 1;
		showDivs(slideIndex);

		function plusDivs(n) {
			showDivs(slideIndex += n);
		}

		function currentDiv(n) {
			showDivs(slideIndex = n);
		}

		function showDivs(n) {
			var i;
			var x = document.getElementsByClassName("mySlides");
			var dots = document.getElementsByClassName("demo");
			if (n > x.length) {
				slideIndex = 1
			}
			if (n < 1) {
				slideIndex = x.length
			}
			for (i = 0; i < x.length; i++) {
				x[i].style.display = "none";
			}
			for (i = 0; i < dots.length; i++) {
				dots[i].className = dots[i].className.replace(" w3-red", "");
			}
			x[slideIndex - 1].style.display = "block";
			/* dots[slideIndex - 1].className += " w3-red"; */
		}
	</script>

</body>
</html>