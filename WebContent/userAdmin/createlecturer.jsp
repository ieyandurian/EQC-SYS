<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.EQCSYS.app.bean.*"
	import="java.util.*" import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta name="description" content="" />
<meta name="author" content="" />
<!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
<title>EQC-SYS</title>
<!-- BOOTSTRAP CORE STYLE  -->
<link href="../assets/css/bootstrap.css" rel="stylesheet"
	type="text/css" />
<!-- FONT AWESOME ICONS  -->
<link href="../assets/css/font-awesome.css" rel="stylesheet"
	type="text/css" />
<!-- CUSTOM STYLE  -->
<link href="../assets/css/style.css" rel="stylesheet" type="text/css" />
<!-- HTML5 Shiv and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<link rel="icon" href="../assets/img/icon.png">
<script>
	function mouseoverPass(obj) {
		var obj = document.getElementById('myPassword');
		obj.type = "text";
	}
	function mouseoutPass(obj) {
		var obj = document.getElementById('myPassword');
		obj.type = "password";
	}
	function mouseoverPassConfirm(obj) {
		var obj = document.getElementById('myPasswordConfirm');
		obj.type = "text";
	}
	function mouseoutPassConfirm(obj) {
		var obj = document.getElementById('myPasswordConfirm');
		obj.type = "password";
	}
	function validateRegister() {
		var pass1 = document.AddLecturerServlet.lecturerPassword.value;
		var pass2 = document.AddLecturerServlet.lecturerPasswordConfirm.value;

		if (pass1 != pass2) {
			alert("Password and Confirm Password must be the same");
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>
	<div class="navbar navbar-inverse set-radius-zero">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="../userAdmin/home.jsp"> <img
					src="../assets/img/logo.png" />
				</a>
			</div>
			<div class="left-div">
				<div class="user-settings-wrapper">
					<ul class="nav">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#" aria-expanded="false"> <span
								class="glyphicon glyphicon-user" style="font-size: 25px;"></span>
						</a> <%
 	AdminBean currentUser = ((AdminBean) (session.getAttribute("currentSessionAdmin")));
 %>
							<div class="dropdown-menu dropdown-settings">
								<div class="media">
									<a class="media-left" href="#"> <img
										src="../assets/img/64-64.png" alt="" class="img-rounded" />
									</a>
									<div class="media-body">
										<h4>Welcome,</h4>
										<h5><%=currentUser.getAdminID()%>.
										</h5>
									</div>
								</div>
								<hr />
								<center>
									<a href="../userAdmin/logout.jsp" class="btn btn-danger btn-sm">Logout</a>
								</center>
							</div></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- LOGO HEADER END-->
	<section class="menu-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="navbar-collapse collapse ">
						<ul id="menu-top" class="nav navbar-nav navbar-right">
							<li><a href="../userAdmin/home.jsp">Home</a></li>
							<li><a class="menu-top-active"
								href="../userAdmin/createlecturer.jsp">Add Lecturer</a></li>
							<li><a href="../userAdmin/managelecturer.jsp">Manage
									Lecturer</a></li>
							<li><a href="../userAdmin/email.jsp">Email</a></li>
							<li><a href="../userAdmin/logout.jsp">Logout</a></li>
						</ul>
					</div>
				</div>

			</div>
		</div>
	</section>
	<!-- MENU SECTION END-->
	<div class="content-wrapper">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h4 class="page-head-line">Create Lecturer Account</h4>
				</div>
			</div>
			<div class="row">
				<div class="" style="width: 100%; padding: 0 20% 0;">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="center">
								<h2>REGISTRATION FORM</h2>
							</div>
						</div>
						<div class="panel-body">
							<form name="AddLecturerServlet" action="../addlecturer"
								onsubmit="return validateRegister()">
								<div class="form-group">
									<label for="exampleInputPassword1">Password</label> <input
										type="password" class="form-control" id="myPassword"
										placeholder="Enter Password" name="lecturerPassword"
										onmouseover="mouseoverPass();" onmouseout="mouseoutPass();"
										required />
								</div>
								<div class="form-group">
									<label for="exampleInputPassword2">Confirm Password</label> <input
										type="password" class="form-control" id="myPasswordConfirm"
										placeholder="Enter Password" name="lecturerPasswordConfirm"
										onmouseover="mouseoverPassConfirm();"
										onmouseout="mouseoutPassConfirm();" required />
								</div>
								<div class="form-group">
									<label for="exampleInputFirstName">First Name</label> <input
										type="text" class="form-control" id="exampleInputFirstName"
										placeholder="Enter First Name" name="lecturerFirstName"
										pattern="[a-z A-Z]{1,40}"
										title="Lecturer first name must be in letters" required />
								</div>
								<div class="form-group">
									<label for="exampleInputLastName">Last Name</label> <input
										type="text" class="form-control" id="exampleInputLastName"
										placeholder="Enter Last Name" name="lecturerLastName"
										pattern="[a-z A-Z]{1,40}"
										title="Lecturer last name must be in letters" required />
								</div>
								<div class="form-group">
									<label for="exampleInputContactNumber">Contact Number</label> <input
										type="text" class="form-control"
										id="exampleInputContactNumber"
										placeholder="Enter Contact Number" name="lecturerPhoneNumber"
										pattern="[0-9]{10,11}" min="10" max="11"
										title="Phone number must be in number format and 10 or 11 length of number"
										required />
								</div>
								<div class="form-group">
									<label for="exampleInputEmailAddress">Email Address</label> <input
										type="email" class="form-control"
										id="exampleInputEmailAddress"
										placeholder="Enter Email Address" name="lecturerEmail"
										pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required />
								</div>
								<div class="form-group">
									<label>Faculty</label> <select class="form-control"
										name="lecturerFaculty" required>
										<option value="">- - -</option>
										<option value="FSKM">FSKM</option>
										<option value="FPA">FPA</option>
									</select>
								</div>
								<hr />
								<div class="center">
									<button type="submit" class="btn btn-success"
										style="width: 100px">Submit</button>
									<button type="reset" class="btn btn-success"
										style="width: 100px">Reset</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- CONTENT-WRAPPER SECTION END-->
	<!-- CONTENT-WRAPPER SECTION END-->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					&copy; 2016-2017 IEYANDURIAN | By : <a href="fb.com/ieyandurian"
						target="_blank">Azizulaimran Bin Kamsol, 2014340001</a>
				</div>

			</div>
		</div>
	</footer>
	<!-- FOOTER SECTION END-->
	<!-- JAVASCRIPT AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
	<!-- CORE JQUERY SCRIPTS -->
	<script src="../assets/js/jquery-1.11.1.js"></script>
	<!-- BOOTSTRAP SCRIPTS  -->
	<script src="../assets/js/bootstrap.js"></script>
</body>
</html>
