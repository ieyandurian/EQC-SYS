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
							<li><a href="../userLecturer/home.jsp">Home</a></li>
							<li><a href="../userLecturer/myaccount.jsp">My Account</a></li>
							<li><a class="menu-top-active"
								href="../userLecturer/createquestion.jsp">Create Question</a></li>
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
	<div class="content-wrapper">
		<div class="container">
			<div class="row">
				<div class="" style="width: 100%; padding: 0 20% 0;">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="center">
								<h2>Create Question Manually</h2>
							</div>
						</div>
						<div class="panel-body">
							<form name="CreateQuestionManualServlet"
								action="../createquestionmanual">
								<div class="form-group">
									<label>Difficulty</label> <select class="form-control"
										name="questionDifficulty">
										<option value="C1" selected>C1</option>
										<option value="C2">C2</option>
										<option value="C3">C3</option>
										<option value="C4">C4</option>
										<option value="C5">C5</option>
										<option value="C6">C6</option>
									</select>
								</div>
								<div class="form-group">
									<label>Marks Allocated (%)</label> <select class="form-control"
										name="questionMarks">
										<option value="1" selected>1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
									</select>
								</div>
								<div class="form-group">
									<label>Topic Code</label> <select class="form-control"
										name="questionTopicCode">
										<option value="Topic 1" selected>Topic 1 - Fundamental System
											Concepts</option>
										<option value="Topic 2">Topic 2 - Types of System</option>
										<option value="Topic 3">Topic 3 - System Thinking</option>
										<option value="Topic 4">Topic 4 - The Enterprise
											Systems</option>
										<option value="Topic 5">Topic 5 - Information Systems</option>
										<option value="Topic 6">Topic 6 - Systems Methodology</option>
										<option value="Topic 7">Topic 7 - Soft Systems
											Methodology</option>
										<option value="Topic 8">Topic 8 - Systems Development
											and System Practices</option>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputQuestion">Question</label>
									<textarea class="form-control" rows="3" placeholder="Text Area"
										name="questionQuestion" required></textarea>
								</div>
								<div class="form-group">
									<label for="exampleInputAnswer">Answer</label>
									<textarea class="form-control" rows="3" placeholder="Text Area"
										name="questionAnswer" required></textarea>
								</div>
								<div class="form-group">
									<label for="share">Share With Others</label><br/>
									<input type="radio" name="questionShare" value="Yes" checked> I want to share this question with other lecturers.<br>
  									<input type="radio" name="questionShare" value="No"> I do not want to share this question with other lecturers.<br><br>
								</div>
								<hr />
								<div class="center">
									<button type="submit" class="btn btn-success" style="width:100px;">Submit</button>
									<button type="reset" class="btn btn-success" style="width:100px;">Reset</button>
									<a href="../userLecturer/createquestion.jsp"
										class="btn btn-success" style="width:100px;">Back</a>
								</div>
							</form>
						</div>
					</div>
				</div>
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
