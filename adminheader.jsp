<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>The Lights Wagon</title>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="jquery-1.8.3.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<style>
h1 {
	font-size: 40px;
	font-weight: bold
}

body {
	padding-top: 150px;
}

a:hover {
	background-color: #008B00;
	color: #ADFF2F
}

.navbar .nav>li>a:hover {
	background-color: #008B00;
	color: #ADFF2F
}

.navbar .nav>li>a {
	color: #0000CD;
	font-weight: bold;
	font-family: Verdana;
}
</style>

</head>
<body>
<h1>THE LIGHTS WAGON</h1>
	<hr style="color: #228B22">
	<nav class="navbar navbar-top" style="background-color: #90EE90;">
		<div class="container-fluid">
		
			<div>
				<ul class="nav navbar-nav">
				<li class="navbar-text">Edit the database</li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Product <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="addproduct">Add</a></li>
							<li><a href="#">Delete</a></li>
							<li><a href="#">Update</a></li>
							<li class="divider"></li>
							<li><a href="#">View all</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Category <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Add</a></li>
							<li><a href="#">Delete</a></li>
							<li><a href="#">Update</a></li>
							<li class="divider"></li>
							<li><a href="#">View all</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Supplier <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Add</a></li>
							<li><a href="#">Delete</a></li>
							<li><a href="#">Update</a></li>
							<li class="divider"></li>
							<li><a href="#">View all</a></li>
						</ul></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
						<li><a href="home">Sign Out</a></li>        
       </ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="sidebar-nav-fixed affix">
					<div class="well">
						<ul class="nav ">
							<li class="nav-header">Edit the Contents</li>
							<li><a href="#">Home</a></li>
							<li><a href="#">About us</a></li>
							<li><a href="#">Contact Us</a></li>

						</ul>
					</div>
				</div>
			</div>
		