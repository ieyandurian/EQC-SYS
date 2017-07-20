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
<link href="../assets/css/bootstrap.css" rel="stylesheet" />
<!-- FONT AWESOME ICONS  -->
<link href="../assets/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLE  -->
<link href="../assets/css/style.css" rel="stylesheet" />
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
				<a class="navbar-brand" href="../userLecturer/home.jsp"> <img
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
 	LecturerBean currentUser = ((LecturerBean) (session
 			.getAttribute("currentSessionUser")));
 %>
							<div class="dropdown-menu dropdown-settings">
								<div class="media">
									<a class="media-left" href="#"> <img
										src="../assets/img/64-64.png" alt="" class="img-rounded" />
									</a>
									<div class="media-body">
										<h4 class="media-heading">Welcome,</h4>
										<h5><%=currentUser.getLecturerFirstName() + " "
					+ currentUser.getLecturerLastName()%>
										</h5>
									</div>
								</div>
								<hr />
								<center>
									<a href="../userLecturer/logout.jsp"
										class="btn btn-danger btn-sm">Logout</a>
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
							<li><a class="menu-top-active"
								href="../userLecturer/home.jsp">Home</a></li>
							<li><a href="../userLecturer/myaccount.jsp">My Account</a></li>
							<li><a href="../userLecturer/createquestion.jsp">Create
									Question</a></li>
							<li><a href="../userLecturer/managequestion.jsp">Manage
									Question</a></li>
							<li><a href="../userLecturer/tst.jsp">Test Specification
									Table (TST)</a></li>
							<li><a href="../userLecturer/logout.jsp">Logout</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- MENU SECTION END-->
	<iframe src="D:\\EQC-SYS\\OUTPUT\\EXAM PAPER.pdf&embedded=true"
		style="width: 600px; height: 500px;" frameborder="0"></iframe>
	<div class="content-wrapper">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="alert alert-success">Welcome User. You can update
						your account information, create question, manage question and
						generate exam paper.</div>
				</div>
			</div>
			<div class="row">
				<a href="../userLecturer/myaccount.jsp">
					<div class="col-md-3 col-sm-3 col-xs-6">
						<div class="dashboard-div-wrapper bk-clr-one">
							<i class="fa fa-edit dashboard-div-icon"></i>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-warning"
									role="progressbar" aria-valuenow="100" aria-valuemin="0"
									aria-valuemax="100" style="width: 100%"></div>

							</div>
							<h5>View Account Information</h5>
						</div>
					</div>
				</a> <a href="../userLecturer/myaccount.jsp">
					<div class="col-md-3 col-sm-3 col-xs-6">
						<div class="dashboard-div-wrapper bk-clr-two">
							<i class="fa fa-edit dashboard-div-icon"></i>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-danger" role="progressbar"
									aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"
									style="width: 100%"></div>

							</div>
							<h5>Update Account Information</h5>
						</div>
					</div>
				</a> <a href="../userLecturer/createquestion.jsp">
					<div class="col-md-3 col-sm-3 col-xs-6">
						<div class="dashboard-div-wrapper bk-clr-three">
							<i class="fa fa-cogs dashboard-div-icon"></i>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-success"
									role="progressbar" aria-valuenow="100" aria-valuemin="0"
									aria-valuemax="100" style="width: 100%"></div>

							</div>
							<h5>Create Exam Question Manually</h5>
						</div>
					</div>
				</a> <a href="../userLecturer/createquestion.jsp">
					<div class="col-md-3 col-sm-3 col-xs-6">
						<div class="dashboard-div-wrapper bk-clr-four">
							<i class="fa fa-cogs dashboard-div-icon"></i>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-primary"
									role="progressbar" aria-valuenow="100" aria-valuemin="0"
									aria-valuemax="100" style="width: 100%"></div>

							</div>
							<h5>Create Exam Question Automatically</h5>
						</div>
					</div>
				</a> <a href="../userLecturer/managequestion.jsp">
					<div class="col-md-3 col-sm-3 col-xs-6">
						<div class="dashboard-div-wrapper bk-clr-five">
							<i class="fa fa-cogs dashboard-div-icon"></i>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-warning"
									role="progressbar" aria-valuenow="100" aria-valuemin="0"
									aria-valuemax="100" style="width: 100%"></div>

							</div>
							<h5>View Exam Question</h5>
						</div>
					</div>
				</a> <a href="../userLecturer/managequestion.jsp">
					<div class="col-md-3 col-sm-3 col-xs-6">
						<div class="dashboard-div-wrapper bk-clr-six">
							<i class="fa fa-cogs dashboard-div-icon"></i>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-danger" role="progressbar"
									aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"
									style="width: 100%"></div>

							</div>
							<h5>Update Exam Question</h5>
						</div>
					</div>
				</a> <a href="../userLecturer/managequestion.jsp">
					<div class="col-md-3 col-sm-3 col-xs-6">
						<div class="dashboard-div-wrapper bk-clr-seven">
							<i class="fa fa-cogs dashboard-div-icon"></i>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-success"
									role="progressbar" aria-valuenow="100" aria-valuemin="0"
									aria-valuemax="100" style="width: 100%"></div>

							</div>
							<h5>Delete Exam Question</h5>
						</div>
					</div>
				</a> <a href="../userLecturer/tst.jsp">
					<div class="col-md-3 col-sm-3 col-xs-6">
						<div class="dashboard-div-wrapper bk-clr-eight">
							<i class="fa fa-bell-o dashboard-div-icon"></i>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-primary"
									role="progressbar" aria-valuenow="100" aria-valuemin="0"
									aria-valuemax="100" style="width: 100%"></div>

							</div>
							<h5>Generate Exam Paper</h5>
						</div>
					</div>
				</a>
			</div>
		</div>
	</div>
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
