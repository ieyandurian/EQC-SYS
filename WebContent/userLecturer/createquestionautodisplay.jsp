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
<style>
table, td, th {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th {
	background-color: #4CAF50;
	color: white;
	height: 50px;
}

td {
	padding-left: 10px;
	text-align: left;
}

tr:hover {
	background-color: #f5f5f5
}
</style>
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
							<li><a href="../userLecturer/createquestion.jsp">Create
									Question</a></li>
							<li><a class="menu-top-active"
								href="../userLecturer/managequestion.jsp">Manage Question</a></li>
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
		<div class="container" style="width: 95%;">
			<div class="row">
				<div class="col-md-max">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="center">
								<h2>Generated Questions</h2>
							</div>
						</div>
						<div class="panel-body">
							<table>
								<tr>
									<th class="center">ID</th>
									<th class="center">Difficulty</th>
									<th class="center">Marks Allocated</th>
									<th class="center">Topic Code</th>
									<th class="center" width="25%">Questions</th>
									<th class="center" width="33%">Answer</th>
									<th class="center">Shared Access</th>
								</tr>
								<sql:setDataSource var="snapshot"
									driver="oracle.jdbc.driver.OracleDriver"
									url="jdbc:oracle:thin:@localhost:1521:xe" user="EQCSYS"
									password="oracle" />
								<sql:query dataSource="${snapshot}" var="result">
						SELECT * from questionbankstore order by questionID asc
						</sql:query>
								<c:forEach items="${result.rows}" var="row">
									<tr>
										<td><c:out value="${row.questionID}" /></td>
										<td><c:out value="${row.questionDifficulty}" /></td>
										<td><c:out value="${row.questionMarks}" /></td>
										<td><c:out value="${row.questionTopicCode}" /></td>
										<td><c:out value="${row.questionQuestion}" /></td>
										<td><c:out value="${row.questionAnswer}" /></td>
										<td class="center">
											<div class="btn-group">
												<button data-toggle="dropdown"
													class="btn btn-primary dropdown-toggle"
													aria-expanded="false">
													Click Here <span class="caret"></span>
												</button>
												<ul class="dropdown-menu">
													<li><a
														href="../addautoquestion?questionID=<c:out value="${row.questionID}" />&questionShare=Yes">Yes</a></li>
													<li><a
														href="../addautoquestion?questionID=<c:out value="${row.questionID}" />&questionShare=No">No</a></li>
												</ul>
											</div>
										</td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<div class="center">
							<a href="../deleteallquestion" class="btn btn-danger">Return
								to Previous Page</a>
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
