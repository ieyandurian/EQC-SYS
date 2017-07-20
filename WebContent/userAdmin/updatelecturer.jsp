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
 	AdminBean currentUser = ((AdminBean) (session
 			.getAttribute("currentSessionAdmin")));
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
							<li><a href="../userAdmin/createlecturer.jsp">Add
									Lecturer</a></li>
							<li><a class="menu-top-active"
								href="../userAdmin/managelecturer.jsp">Manage Lecturer</a></li>
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
					<h4 class="page-head-line">Manage Account</h4>
				</div>
			</div>
			<div class="row">
				<div class="" style="width: 100%; padding: 0 20% 0;">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="center">
								<h2>UPDATE LECTURER INFORMATION</h2>
							</div>
						</div>
						<sql:setDataSource var="snapshot"
							driver="oracle.jdbc.driver.OracleDriver"
							url="jdbc:oracle:thin:@localhost:1521:xe" user="EQCSYS"
							password="oracle" />
						<sql:query dataSource="${snapshot}" var="result">
						SELECT * from lecturer where lecturerID=?
						<sql:param value="${param.lecturerID}" />
						</sql:query>
						<c:forEach items="${result.rows}" var="row">
							<div class="panel-body">
								<form name="UpdateLecturerServlet" action="../updatelecturer">
									<div class="form-group">
										<label for="exampleInputID">ID</label> <input type="text"
											class="form-control" id="id" name="lecturerID"
											value="${param.lecturerID}" readonly required />
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">New Password</label> <input
											type="password" class="form-control"
											id="exampleInputPassword1" name="lecturerPassword"
											placeholder="New Password" required />
									</div>
									<div class="form-group">
										<label for="exampleInputPassword2">Confirm Password</label> <input
											type="password" class="form-control"
											id="exampleInputPassword2" name="lecturerPasswordConfirm"
											placeholder="Confirm Password" required />
									</div>
									<div class="form-group">
										<label for="exampleInputFirstName">First Name</label> <input
											type="text" class="form-control" id="exampleInputFirstName"
											name="lecturerFirstName" value="${row.lecturerFirstName}"
											required />
									</div>
									<div class="form-group">
										<label for="exampleInputLastName">Last Name</label> <input
											type="text" class="form-control" id="exampleInputLastName"
											name="lecturerLastName" value="${row.lecturerLastName}"
											required />
									</div>
									<div class="form-group">
										<label for="exampleInputContactNumber">Contact Number</label>
										<input type="text" class="form-control"
											id="exampleInputContactNumber" name="lecturerPhoneNumber"
											value="${row.lecturerPhoneNumber}" required />
									</div>
									<div class="form-group">
										<label for="exampleInputEmailAddress">Email Address</label> <input
											type="email" class="form-control"
											id="exampleInputEmailAddress" name="lecturerEmail"
											value="${row.lecturerEmail}" required />
									</div>
									<div class="form-group">
										<label>Faculty</label> <select class="form-control"
											name="lecturerFaculty">
											<option value="${row.lecturerFaculty}" selected><c:out
													value="${row.lecturerFaculty}" /></option>
											<option value="FSKM">FSKM</option>
											<option value="FPA">FPA</option>
										</select>
									</div>
									<hr />
									<div class="center">
										<button type="submit" class="btn btn-success"
											style="width: 100px;">Submit</button>
										<button type="reset" class="btn btn-success"
											style="width: 100px;">Reset</button>
										<a href="../userAdmin/managelecturer.jsp"
											class="btn btn-success" style="width: 100px;">Back</a>
									</div>
								</form>
							</div>
						</c:forEach>
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
