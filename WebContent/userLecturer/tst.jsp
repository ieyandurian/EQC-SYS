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
table, table1, td, th {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
	width: 100%;
}

table1 {
	border-collapse: collapse;
	width: 50%;
}

th {
	background-color: #4CAF50;
	color: white;
	height: 50px;
	font-size: 10px;
}

td {
	padding-left: 0px;
	padding-right: 0px;
	font-size: 10px;
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
							<li><a href="../userLecturer/managequestion.jsp">Manage
									Question</a></li>
							<li><a class="menu-top-active"
								href="../userLecturer/tst.jsp">Test Specification Table
									(TST)</a></li>
							<li><a href="../userLecturer/logout.jsp">Logout</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- MENU SECTION END-->
	<div class="content-wrapper">
		<div class="container" style="width:95%;">
			<div class="row">
				<div class="col-md-max">
					<form name="TSTValidateSevlet" action="../tstvalidate">
						<div class="panel panel-default">
							<div class="panel-heading">
								<div class="center">
									<h2>Test Specification Table (TST)</h2>
								</div>
							</div>
							<div class="table-responsive">
								<table id='worksheet_table' class="table">
									<thead>
										<tr>
											<th class="center" style="width:12px" rowspan=3>No.</th>
											<th class="center" rowspan=3>Topics</th>
											<th class="center" rowspan=3>PLO</th>
											<th class="center" rowspan=3>CLO</th>
											<th class="center" rowspan=3>Time<br>(HR)
											</th>
											<th class="center" rowspan=3>Time<br>(%)
											</th>
											<th class="center" rowspan=3>Exam<br>(%)
											</th>
											<th class="center" colspan=2>C1</th>
											<th class="center" colspan=2>C2</th>
											<th class="center" colspan=2>C3</th>
											<th class="center" colspan=2>C4</th>
											<th class="center" colspan=2>C5</th>
											<th class="center" colspan=2>C6</th>
											<th class="center" rowspan=3>Total<br />Question
											</th>
											<th class="center" rowspan=3>Total<br />Marks
											</th>
										</tr>
										<tr>
											<th class="center" colspan=2>Remembering/<br>Knowledge
											</th>
											<th class="center" colspan=2>Understanding/<br>Comprehension
											</th>
											<th class="center" colspan=2>Applying/<br>Application
											</th>
											<th class="center" colspan=2>Analysing/<br>Analysis
											</th>
											<th class="center" colspan=2>Creating/<br>Synthesis
											</th>
											<th class="center" colspan=2>Evaluating/<br>Evaluation
											</th>
										</tr>
										<tr>
											<th class="center">No. of<br />Question
											</th>
											<th class="center">Marks</th>
											<th class="center">No. of<br />Question
											</th>
											<th class="center">Marks</th>
											<th class="center">No. of<br />Question
											</th>
											<th class="center">Marks</th>
											<th class="center">No. of<br />Question
											</th>
											<th class="center">Marks</th>
											<th class="center">No. of<br />Question
											</th>
											<th class="center">Marks</th>
											<th class="center">No. of<br />Question
											</th>
											<th class="center">Marks</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td class="center">1</td>
											<td style="font-size:12px">Fundamental System Concepts</td>
											<td style="vertical-align:middle"><select id="PLO_TOPIC1" name="PLO_TOPIC1">
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
											</select></td>
											<td style="vertical-align:middle"><select id="CLO_TOPIC1" name="CLO_TOPIC1">
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
											</select></td>
											<td style="vertical-align:middle"><select id="HOUR_TOPIC1" name="HOUR_TOPIC1" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TIME_TOPIC1" name="TIME_TOPIC1" type="text" size="4" value="0" readonly></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="EXAM_TOPIC1" name="EXAM_TOPIC1" type="text" size="4" value="0" readonly></td>
											<td style="vertical-align:middle"><select id="QC1_TOPIC1" name="QC1_TOPIC1" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C1_TOPIC1" name="C1_TOPIC1" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC2_TOPIC1" name="QC2_TOPIC1" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C2_TOPIC1" name="C2_TOPIC1" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC3_TOPIC1" name="QC3_TOPIC1" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C3_TOPIC1" name="C3_TOPIC1" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC4_TOPIC1" name="QC4_TOPIC1" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C4_TOPIC1" name="C4_TOPIC1" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC5_TOPIC1" name="QC5_TOPIC1" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C5_TOPIC1" name="C5_TOPIC1" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC6_TOPIC1" name="QC6_TOPIC1" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C6_TOPIC1" name="C6_TOPIC1" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TOTALQ_TOPIC1" name="TOTALQ_TOPIC1" type="text" size="4" value="0" readonly></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TOTALM_TOPIC1" name="TOTALM_TOPIC1" type="text" size="4" value="0" readonly></td>
										</tr>
										<tr>
											<td class="center">2</td>
											<td style="font-size:12px">Types of System</td>
											<td style="vertical-align:middle"><select id="PLO_TOPIC2" name="PLO_TOPIC2">
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
											</select></td>
											<td style="vertical-align:middle"><select id="CLO_TOPIC2" name="CLO_TOPIC2">
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
											</select></td>
											<td style="vertical-align:middle"><select id="HOUR_TOPIC2" name="HOUR_TOPIC2" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TIME_TOPIC2" name="TIME_TOPIC2" type="text" size="4" value="0" readonly></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="EXAM_TOPIC2" name="EXAM_TOPIC2" type="text" size="4" value="0" readonly></td>
											<td style="vertical-align:middle"><select id="QC1_TOPIC2" name="QC1_TOPIC2" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C1_TOPIC2" name="C1_TOPIC2" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC2_TOPIC2" name="QC2_TOPIC2" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C2_TOPIC2" name="C2_TOPIC2" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC3_TOPIC2" name="QC3_TOPIC2" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C3_TOPIC2" name="C3_TOPIC2" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC4_TOPIC2" name="QC4_TOPIC2" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C4_TOPIC2" name="C4_TOPIC2" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC5_TOPIC2" name="QC5_TOPIC2" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C5_TOPIC2" name="C5_TOPIC2" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC6_TOPIC2" name="QC6_TOPIC2" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C6_TOPIC2" name="C6_TOPIC2" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TOTALQ_TOPIC2" name="TOTALQ_TOPIC2" type="text" size="4" value="0" readonly></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TOTALM_TOPIC2" name="TOTALM_TOPIC2" type="text" size="4" value="0" readonly></td>
										</tr>
										<tr>
											<td class="center">3</td>
											<td style="font-size:12px">System Thinking</td>
											<td style="vertical-align:middle"><select id="PLO_TOPIC3" name="PLO_TOPIC3">
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
											</select></td>
											<td style="vertical-align:middle"><select id="CLO_TOPIC3" name="CLO_TOPIC3">
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
											</select></td>
											<td style="vertical-align:middle"><select id="HOUR_TOPIC3" name="HOUR_TOPIC3" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TIME_TOPIC3" name="TIME_TOPIC3" type="text" size="4" value="0" readonly></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="EXAM_TOPIC3" name="EXAM_TOPIC3" type="text" size="4" value="0" readonly></td>
											<td style="vertical-align:middle"><select id="QC1_TOPIC3" name="QC1_TOPIC3" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C1_TOPIC3" name="C1_TOPIC3" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC2_TOPIC3" name="QC2_TOPIC3" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C2_TOPIC3" name="C2_TOPIC3" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC3_TOPIC3" name="QC3_TOPIC3" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C3_TOPIC3" name="C3_TOPIC3" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC4_TOPIC3" name="QC4_TOPIC3" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C4_TOPIC3" name="C4_TOPIC3" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC5_TOPIC3" name="QC5_TOPIC3" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C5_TOPIC3" name="C5_TOPIC3" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC6_TOPIC3" name="QC6_TOPIC3" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C6_TOPIC3" name="C6_TOPIC3" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TOTALQ_TOPIC3" name="TOTALQ_TOPIC3" type="text" size="4" value="0" readonly></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TOTALM_TOPIC3" name="TOTALM_TOPIC3" type="text" size="4" value="0" readonly></td>
										</tr>
										<tr>
											<td class="center">4</td>
											<td style="font-size:12px">The Enterprise Systems</td>
											<td style="vertical-align:middle"><select id="PLO_TOPIC4" name="PLO_TOPIC4">
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
											</select></td>
											<td style="vertical-align:middle"><select id="CLO_TOPIC4" name="CLO_TOPIC4">
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
											</select></td>
											<td style="vertical-align:middle"><select id="HOUR_TOPIC4" name="HOUR_TOPIC4" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TIME_TOPIC4" name="TIME_TOPIC4" type="text" size="4" value="0" readonly></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="EXAM_TOPIC4" name="EXAM_TOPIC4" type="text" size="4" value="0" readonly></td>
											<td style="vertical-align:middle"><select id="QC1_TOPIC4" name="QC1_TOPIC4" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C1_TOPIC4" name="C1_TOPIC4" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC2_TOPIC4" name="QC2_TOPIC4" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C2_TOPIC4" name="C2_TOPIC4" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC3_TOPIC4" name="QC3_TOPIC4" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C3_TOPIC4" name="C3_TOPIC4" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC4_TOPIC4" name="QC4_TOPIC4" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C4_TOPIC4" name="C4_TOPIC4" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC5_TOPIC4" name="QC5_TOPIC4" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C5_TOPIC4" name="C5_TOPIC4" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC6_TOPIC4" name="QC6_TOPIC4" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C6_TOPIC4" name="C6_TOPIC4" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TOTALQ_TOPIC4" name="TOTALQ_TOPIC4" type="text" size="4" value="0" readonly></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TOTALM_TOPIC4" name="TOTALM_TOPIC4" type="text" size="4" value="0" readonly></td>
										</tr>
										<tr>
											<td class="center">5</td>
											<td style="font-size:12px">Information Systems</td>
											<td style="vertical-align:middle"><select id="PLO_TOPIC5" name="PLO_TOPIC5">
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
											</select></td>
											<td style="vertical-align:middle"><select id="CLO_TOPIC5" name="CLO_TOPIC5">
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
											</select></td>
											<td style="vertical-align:middle"><select id="HOUR_TOPIC5" name="HOUR_TOPIC5" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TIME_TOPIC5" name="TIME_TOPIC5" type="text" size="4" value="0" readonly></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="EXAM_TOPIC5" name="EXAM_TOPIC5" type="text" size="4" value="0" readonly></td>
											<td style="vertical-align:middle"><select id="QC1_TOPIC5" name="QC1_TOPIC5" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C1_TOPIC5" name="C1_TOPIC5" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC2_TOPIC5" name="QC2_TOPIC5" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C2_TOPIC5" name="C2_TOPIC5" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC3_TOPIC5" name="QC3_TOPIC5" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C3_TOPIC5" name="C3_TOPIC5" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC4_TOPIC5" name="QC4_TOPIC5" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C4_TOPIC5" name="C4_TOPIC5" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC5_TOPIC5" name="QC5_TOPIC5" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C5_TOPIC5" name="C5_TOPIC5" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC6_TOPIC5" name="QC6_TOPIC5" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C6_TOPIC5" name="C6_TOPIC5" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TOTALQ_TOPIC5" name="TOTALQ_TOPIC5" type="text" size="4" value="0" readonly></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TOTALM_TOPIC5" name="TOTALM_TOPIC5" type="text" size="4" value="0" readonly></td>
										</tr>
										<tr>
											<td class="center">6</td>
											<td style="font-size:12px">Systems Methodology</td>
											<td style="vertical-align:middle"><select id="PLO_TOPIC6" name="PLO_TOPIC6">
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
											</select></td>
											<td style="vertical-align:middle"><select id="CLO_TOPIC6" name="CLO_TOPIC6">
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
											</select></td>
											<td style="vertical-align:middle"><select id="HOUR_TOPIC6" name="HOUR_TOPIC6" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TIME_TOPIC6" name="TIME_TOPIC6" type="text" size="4" value="0" readonly></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="EXAM_TOPIC6" name="EXAM_TOPIC6" type="text" size="4" value="0" readonly></td>
											<td style="vertical-align:middle"><select id="QC1_TOPIC6" name="QC1_TOPIC6" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C1_TOPIC6" name="C1_TOPIC6" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC2_TOPIC6" name="QC2_TOPIC6" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C2_TOPIC6" name="C2_TOPIC6" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC3_TOPIC6" name="QC3_TOPIC6" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C3_TOPIC6" name="C3_TOPIC6" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC4_TOPIC6" name="QC4_TOPIC6" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C4_TOPIC6" name="C4_TOPIC6" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC5_TOPIC6" name="QC5_TOPIC6" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C5_TOPIC6" name="C5_TOPIC6" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC6_TOPIC6" name="QC6_TOPIC6" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C6_TOPIC6" name="C6_TOPIC6" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TOTALQ_TOPIC6" name="TOTALQ_TOPIC6" type="text" size="4" value="0" readonly></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TOTALM_TOPIC6" name="TOTALM_TOPIC6" type="text" size="4" value="0" readonly></td>
										</tr>
										<tr>
											<td class="center">7</td>
											<td style="font-size:12px">Soft Systems Methodology</td>
											<td style="vertical-align:middle"><select id="PLO_TOPIC7" name="PLO_TOPIC7">
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
											</select></td>
											<td style="vertical-align:middle"><select id="CLO_TOPIC7" name="CLO_TOPIC7">
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
											</select></td>
											<td style="vertical-align:middle"><select id="HOUR_TOPIC7" name="HOUR_TOPIC7" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TIME_TOPIC7" name="TIME_TOPIC7" type="text" size="4" value="0" readonly></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="EXAM_TOPIC7" name="EXAM_TOPIC7" type="text" size="4" value="0" readonly></td>
											<td style="vertical-align:middle"><select id="QC1_TOPIC7" name="QC1_TOPIC7" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C1_TOPIC7" name="C1_TOPIC7" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC2_TOPIC7" name="QC2_TOPIC7" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C2_TOPIC7" name="C2_TOPIC7" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC3_TOPIC7" name="QC3_TOPIC7" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C3_TOPIC7" name="C3_TOPIC7" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC4_TOPIC7" name="QC4_TOPIC7" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C4_TOPIC7" name="C4_TOPIC7" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC5_TOPIC7" name="QC5_TOPIC7" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C5_TOPIC7" name="C5_TOPIC7" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC6_TOPIC7" name="QC6_TOPIC7" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C6_TOPIC7" name="C6_TOPIC7" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TOTALQ_TOPIC7" name="TOTALQ_TOPIC7" type="text" size="4" value="0" readonly></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TOTALM_TOPIC7" name="TOTALM_TOPIC7" type="text" size="4" value="0" readonly></td>
										</tr>
										<tr>
											<td class="center">8</td>
											<td style="font-size:12px">Systems Development and System Practices</td>
											<td style="vertical-align:middle"><select id="PLO_TOPIC8" name="PLO_TOPIC8">
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
											</select></td>
											<td style="vertical-align:middle"><select id="CLO_TOPIC8" name="CLO_TOPIC8">
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
											</select></td>
											<td style="vertical-align:middle"><select id="HOUR_TOPIC8" name="HOUR_TOPIC8" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TIME_TOPIC8" name="TIME_TOPIC8" type="text" size="4" value="0" readonly></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="EXAM_TOPIC8" name="EXAM_TOPIC8" type="text" size="4" value="0" readonly></td>
											<td style="vertical-align:middle"><select id="QC1_TOPIC8" name="QC1_TOPIC8" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C1_TOPIC8" name="C1_TOPIC8" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC2_TOPIC8" name="QC2_TOPIC8" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C2_TOPIC8" name="C2_TOPIC8" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC3_TOPIC8" name="QC3_TOPIC8" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C3_TOPIC8" name="C3_TOPIC8" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC4_TOPIC8" name="QC4_TOPIC8" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C4_TOPIC8" name="C4_TOPIC8" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC5_TOPIC8" name="QC5_TOPIC8" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C5_TOPIC8" name="C5_TOPIC8" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="QC6_TOPIC8" name="QC6_TOPIC8" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td style="vertical-align:middle"><select id="C6_TOPIC8" name="C6_TOPIC8" onclick="getValues()">
													<option value="0" selected>0</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
											</select></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TOTALQ_TOPIC8" name="TOTALQ_TOPIC8" type="text" size="4" value="0" readonly></td>
											<td bgcolor="#ccffb3" class="center" style="vertical-align:middle"><input type="text" id="TOTALM_TOPIC8" name="TOTALM_TOPIC8" type="text" size="4" value="0" readonly></td>
										</tr>
										<tr style="font-weight: bold;">
											<td bgcolor="#9fff80" class="center" colspan="4" style="font-size:12px">Total</td>
											<td bgcolor="#9fff80" class="center"><input type="text" id="TOTALTIME_HR" name="TOTALTIME_HR" type="text" size="4" value="0" readonly></td>
											<td bgcolor="#9fff80" class="center"><input type="text" id="TOTALTIME_PERCENTAGE" name="TOTALTIME_PERCENTAGE" type="text" size="4" value="0" readonly></td>
											<td bgcolor="#9fff80" class="center"><input type="text" id="TOTALEXAM_PERCENTAGE" name="TOTALEXAM_PERCENTAGE" type="text" size="4" value="0" readonly></td>
											<td bgcolor="#9fff80" class="center" colspan="2"><input type="text" id="TOTALM_C1" name="TOTALM_C1" type="text" size="4" value="0" value="0" readonly></td>
											<td bgcolor="#9fff80" class="center" colspan="2"><input type="text" id="TOTALM_C2" name="TOTALM_C2" type="text" size="4" value="0" value="0" readonly></td>
											<td bgcolor="#9fff80" class="center" colspan="2"><input type="text" id="TOTALM_C3" name="TOTALM_C3" type="text" size="4" value="0" value="0" readonly></td>
											<td bgcolor="#9fff80" class="center" colspan="2"><input type="text" id="TOTALM_C4" name="TOTALM_C4" type="text" size="4" value="0" value="0" readonly></td>
											<td bgcolor="#9fff80" class="center" colspan="2"><input type="text" id="TOTALM_C5" name="TOTALM_C5" type="text" size="4" value="0" value="0" readonly></td>
											<td bgcolor="#9fff80" class="center" colspan="2"><input type="text" id="TOTALM_C6" name="TOTALM_C6" type="text" size="4" value="0" value="0" readonly></td>
											<td bgcolor="#9fff80" class="center"><input type="text" id="TOTALQ_ALL" name="TOTALQ_ALL" type="text" size="4" value="0" value="0" readonly></td>
											<td bgcolor="#9fff80" class="center"><input type="text" id="TOTALM_ALL" name="TOTALM_ALL" type="text" size="4" value="0" value="0" readonly></td>
										</tr>
									</tbody>
								</table>
								<script id="jsbin-javascript">
    function getValues()
  {
	var PLO_TOPIC1 = document.getElementById('PLO_TOPIC1').value;
	var PLO_TOPIC2 = document.getElementById('PLO_TOPIC2').value;
	var PLO_TOPIC3 = document.getElementById('PLO_TOPIC3').value;
	var PLO_TOPIC4 = document.getElementById('PLO_TOPIC4').value;
	var PLO_TOPIC5 = document.getElementById('PLO_TOPIC5').value;
	var PLO_TOPIC6 = document.getElementById('PLO_TOPIC6').value;
	var PLO_TOPIC7 = document.getElementById('PLO_TOPIC7').value;
	var PLO_TOPIC8 = document.getElementById('PLO_TOPIC8').value;
	
	var CLO_TOPIC1 = document.getElementById('CLO_TOPIC1').value;
	var CLO_TOPIC2 = document.getElementById('CLO_TOPIC2').value;
	var CLO_TOPIC3 = document.getElementById('CLO_TOPIC3').value;
	var CLO_TOPIC4 = document.getElementById('CLO_TOPIC4').value;
	var CLO_TOPIC5 = document.getElementById('CLO_TOPIC5').value;
	var CLO_TOPIC6 = document.getElementById('CLO_TOPIC6').value;
	var CLO_TOPIC7 = document.getElementById('CLO_TOPIC7').value;
	var CLO_TOPIC8 = document.getElementById('CLO_TOPIC8').value;
	
	var HOUR_TOPIC1 = parseFloat(document.getElementById('HOUR_TOPIC1').value);
	var HOUR_TOPIC2 = parseFloat(document.getElementById('HOUR_TOPIC2').value);
	var HOUR_TOPIC3 = parseFloat(document.getElementById('HOUR_TOPIC3').value);
	var HOUR_TOPIC4 = parseFloat(document.getElementById('HOUR_TOPIC4').value);
	var HOUR_TOPIC5 = parseFloat(document.getElementById('HOUR_TOPIC5').value);
	var HOUR_TOPIC6 = parseFloat(document.getElementById('HOUR_TOPIC6').value);
	var HOUR_TOPIC7 = parseFloat(document.getElementById('HOUR_TOPIC7').value);
	var HOUR_TOPIC8 = parseFloat(document.getElementById('HOUR_TOPIC8').value);
	
	var QC1_TOPIC1 = parseFloat(document.getElementById('QC1_TOPIC1').value);
	var QC1_TOPIC2 = parseFloat(document.getElementById('QC1_TOPIC2').value);
	var QC1_TOPIC3 = parseFloat(document.getElementById('QC1_TOPIC3').value);
	var QC1_TOPIC4 = parseFloat(document.getElementById('QC1_TOPIC4').value);
	var QC1_TOPIC5 = parseFloat(document.getElementById('QC1_TOPIC5').value);
	var QC1_TOPIC6 = parseFloat(document.getElementById('QC1_TOPIC6').value);
	var QC1_TOPIC7 = parseFloat(document.getElementById('QC1_TOPIC7').value);
	var QC1_TOPIC8 = parseFloat(document.getElementById('QC1_TOPIC8').value);	
	
	var C1_TOPIC1 = parseFloat(document.getElementById('C1_TOPIC1').value);
	var C1_TOPIC2 = parseFloat(document.getElementById('C1_TOPIC2').value);
	var C1_TOPIC3 = parseFloat(document.getElementById('C1_TOPIC3').value);
	var C1_TOPIC4 = parseFloat(document.getElementById('C1_TOPIC4').value);
	var C1_TOPIC5 = parseFloat(document.getElementById('C1_TOPIC5').value);
	var C1_TOPIC6 = parseFloat(document.getElementById('C1_TOPIC6').value);
	var C1_TOPIC7 = parseFloat(document.getElementById('C1_TOPIC7').value);
	var C1_TOPIC8 = parseFloat(document.getElementById('C1_TOPIC8').value);	
	
	var QC2_TOPIC1 = parseFloat(document.getElementById('QC2_TOPIC1').value);
	var QC2_TOPIC2 = parseFloat(document.getElementById('QC2_TOPIC2').value);
	var QC2_TOPIC3 = parseFloat(document.getElementById('QC2_TOPIC3').value);
	var QC2_TOPIC4 = parseFloat(document.getElementById('QC2_TOPIC4').value);
	var QC2_TOPIC5 = parseFloat(document.getElementById('QC2_TOPIC5').value);
	var QC2_TOPIC6 = parseFloat(document.getElementById('QC2_TOPIC6').value);
	var QC2_TOPIC7 = parseFloat(document.getElementById('QC2_TOPIC7').value);
	var QC2_TOPIC8 = parseFloat(document.getElementById('QC2_TOPIC8').value);	
	
	var C2_TOPIC1 = parseFloat(document.getElementById('C2_TOPIC1').value);
	var C2_TOPIC2 = parseFloat(document.getElementById('C2_TOPIC2').value);
	var C2_TOPIC3 = parseFloat(document.getElementById('C2_TOPIC3').value);
	var C2_TOPIC4 = parseFloat(document.getElementById('C2_TOPIC4').value);
	var C2_TOPIC5 = parseFloat(document.getElementById('C2_TOPIC5').value);
	var C2_TOPIC6 = parseFloat(document.getElementById('C2_TOPIC6').value);
	var C2_TOPIC7 = parseFloat(document.getElementById('C2_TOPIC7').value);
	var C2_TOPIC8 = parseFloat(document.getElementById('C2_TOPIC8').value);		
	
	var QC3_TOPIC1 = parseFloat(document.getElementById('QC3_TOPIC1').value);
	var QC3_TOPIC2 = parseFloat(document.getElementById('QC3_TOPIC2').value);
	var QC3_TOPIC3 = parseFloat(document.getElementById('QC3_TOPIC3').value);
	var QC3_TOPIC4 = parseFloat(document.getElementById('QC3_TOPIC4').value);
	var QC3_TOPIC5 = parseFloat(document.getElementById('QC3_TOPIC5').value);
	var QC3_TOPIC6 = parseFloat(document.getElementById('QC3_TOPIC6').value);
	var QC3_TOPIC7 = parseFloat(document.getElementById('QC3_TOPIC7').value);
	var QC3_TOPIC8 = parseFloat(document.getElementById('QC3_TOPIC8').value);	
	
	var C3_TOPIC1 = parseFloat(document.getElementById('C3_TOPIC1').value);
	var C3_TOPIC2 = parseFloat(document.getElementById('C3_TOPIC2').value);
	var C3_TOPIC3 = parseFloat(document.getElementById('C3_TOPIC3').value);
	var C3_TOPIC4 = parseFloat(document.getElementById('C3_TOPIC4').value);
	var C3_TOPIC5 = parseFloat(document.getElementById('C3_TOPIC5').value);
	var C3_TOPIC6 = parseFloat(document.getElementById('C3_TOPIC6').value);
	var C3_TOPIC7 = parseFloat(document.getElementById('C3_TOPIC7').value);
	var C3_TOPIC8 = parseFloat(document.getElementById('C3_TOPIC8').value);		
	
	var QC4_TOPIC1 = parseFloat(document.getElementById('QC4_TOPIC1').value);
	var QC4_TOPIC2 = parseFloat(document.getElementById('QC4_TOPIC2').value);
	var QC4_TOPIC3 = parseFloat(document.getElementById('QC4_TOPIC3').value);
	var QC4_TOPIC4 = parseFloat(document.getElementById('QC4_TOPIC4').value);
	var QC4_TOPIC5 = parseFloat(document.getElementById('QC4_TOPIC5').value);
	var QC4_TOPIC6 = parseFloat(document.getElementById('QC4_TOPIC6').value);
	var QC4_TOPIC7 = parseFloat(document.getElementById('QC4_TOPIC7').value);
	var QC4_TOPIC8 = parseFloat(document.getElementById('QC4_TOPIC8').value);	
	
	var C4_TOPIC1 = parseFloat(document.getElementById('C4_TOPIC1').value);
	var C4_TOPIC2 = parseFloat(document.getElementById('C4_TOPIC2').value);
	var C4_TOPIC3 = parseFloat(document.getElementById('C4_TOPIC3').value);
	var C4_TOPIC4 = parseFloat(document.getElementById('C4_TOPIC4').value);
	var C4_TOPIC5 = parseFloat(document.getElementById('C4_TOPIC5').value);
	var C4_TOPIC6 = parseFloat(document.getElementById('C4_TOPIC6').value);
	var C4_TOPIC7 = parseFloat(document.getElementById('C4_TOPIC7').value);
	var C4_TOPIC8 = parseFloat(document.getElementById('C4_TOPIC8').value);		
	
	var QC5_TOPIC1 = parseFloat(document.getElementById('QC5_TOPIC1').value);
	var QC5_TOPIC2 = parseFloat(document.getElementById('QC5_TOPIC2').value);
	var QC5_TOPIC3 = parseFloat(document.getElementById('QC5_TOPIC3').value);
	var QC5_TOPIC4 = parseFloat(document.getElementById('QC5_TOPIC4').value);
	var QC5_TOPIC5 = parseFloat(document.getElementById('QC5_TOPIC5').value);
	var QC5_TOPIC6 = parseFloat(document.getElementById('QC5_TOPIC6').value);
	var QC5_TOPIC7 = parseFloat(document.getElementById('QC5_TOPIC7').value);
	var QC5_TOPIC8 = parseFloat(document.getElementById('QC5_TOPIC8').value);	
	
	var C5_TOPIC1 = parseFloat(document.getElementById('C5_TOPIC1').value);
	var C5_TOPIC2 = parseFloat(document.getElementById('C5_TOPIC2').value);
	var C5_TOPIC3 = parseFloat(document.getElementById('C5_TOPIC3').value);
	var C5_TOPIC4 = parseFloat(document.getElementById('C5_TOPIC4').value);
	var C5_TOPIC5 = parseFloat(document.getElementById('C5_TOPIC5').value);
	var C5_TOPIC6 = parseFloat(document.getElementById('C5_TOPIC6').value);
	var C5_TOPIC7 = parseFloat(document.getElementById('C5_TOPIC7').value);
	var C5_TOPIC8 = parseFloat(document.getElementById('C5_TOPIC8').value);		
	
	var QC6_TOPIC1 = parseFloat(document.getElementById('QC6_TOPIC1').value);
	var QC6_TOPIC2 = parseFloat(document.getElementById('QC6_TOPIC2').value);
	var QC6_TOPIC3 = parseFloat(document.getElementById('QC6_TOPIC3').value);
	var QC6_TOPIC4 = parseFloat(document.getElementById('QC6_TOPIC4').value);
	var QC6_TOPIC5 = parseFloat(document.getElementById('QC6_TOPIC5').value);
	var QC6_TOPIC6 = parseFloat(document.getElementById('QC6_TOPIC6').value);
	var QC6_TOPIC7 = parseFloat(document.getElementById('QC6_TOPIC7').value);
	var QC6_TOPIC8 = parseFloat(document.getElementById('QC6_TOPIC8').value);	
	
	var C6_TOPIC1 = parseFloat(document.getElementById('C6_TOPIC1').value);
	var C6_TOPIC2 = parseFloat(document.getElementById('C6_TOPIC2').value);
	var C6_TOPIC3 = parseFloat(document.getElementById('C6_TOPIC3').value);
	var C6_TOPIC4 = parseFloat(document.getElementById('C6_TOPIC4').value);
	var C6_TOPIC5 = parseFloat(document.getElementById('C6_TOPIC5').value);
	var C6_TOPIC6 = parseFloat(document.getElementById('C6_TOPIC6').value);
	var C6_TOPIC7 = parseFloat(document.getElementById('C6_TOPIC7').value);
	var C6_TOPIC8 = parseFloat(document.getElementById('C6_TOPIC8').value);		
	    
	var TIME_TOPIC1 = 0;
	var TIME_TOPIC2 = 0;
	var TIME_TOPIC3 = 0;
	var TIME_TOPIC4 = 0;
	var TIME_TOPIC5 = 0;
	var TIME_TOPIC6 = 0;
	var TIME_TOPIC7 = 0;
	var TIME_TOPIC8 = 0;
	
	var EXAM_TOPIC1 = 0;
	var EXAM_TOPIC2 = 0;
	var EXAM_TOPIC3 = 0;
	var EXAM_TOPIC4 = 0;
	var EXAM_TOPIC5 = 0;
	var EXAM_TOPIC6 = 0;
	var EXAM_TOPIC7 = 0;
	var EXAM_TOPIC8 = 0;
	
	var TOTALQ_TOPIC1 = 0;
	var TOTALM_TOPIC1 = 0;		
	var TOTALQ_TOPIC2 = 0;
	var TOTALM_TOPIC2 = 0;	
	var TOTALQ_TOPIC3 = 0;
	var TOTALM_TOPIC3 = 0;	
	var TOTALQ_TOPIC4 = 0;
	var TOTALM_TOPIC4 = 0;	
	var TOTALQ_TOPIC5 = 0;
	var TOTALM_TOPIC5 = 0;	
	var TOTALQ_TOPIC6 = 0;
	var TOTALM_TOPIC6 = 0;	
	var TOTALQ_TOPIC7 = 0;
	var TOTALM_TOPIC7 = 0;	
	var TOTALQ_TOPIC8 = 0;
	var TOTALM_TOPIC8 = 0;	
	
	var TOTALTIME_HR = 0;	
	var TOTALTIME_PERCENTAGE = 0;	
	var TOTALEXAM_PERCENTAGE = 0;	
	var TOTALM_C1 = 0;	
	var TOTALM_C2 = 0;	
	var TOTALM_C3 = 0;	
	var TOTALM_C4 = 0;	
	var TOTALM_C5 = 0;	
	var TOTALM_C6 = 0;	
	var TOTALQ_ALL = 0;	
	var TOTALM_ALL = 0;
    
	if (HOUR_TOPIC1==0) {
		TIME_TOPIC1 = 0;
		TIME_TOPIC2 = 0;
		TIME_TOPIC3 = 0;
		TIME_TOPIC4 = 0;
		TIME_TOPIC5 = 0;
		TIME_TOPIC6 = 0;
		TIME_TOPIC7 = 0;
		TIME_TOPIC8 = 0;
		EXAM_TOPIC1 = 0;
		EXAM_TOPIC2 = 0;
		EXAM_TOPIC3 = 0;
		EXAM_TOPIC4 = 0;
		EXAM_TOPIC5 = 0;
		EXAM_TOPIC6 = 0;
		EXAM_TOPIC7 = 0;
		EXAM_TOPIC8 = 0;
	} else {
	TOTALTIME_HR = HOUR_TOPIC1 + HOUR_TOPIC2 + HOUR_TOPIC3 + HOUR_TOPIC4 + HOUR_TOPIC5 + HOUR_TOPIC6 + HOUR_TOPIC7 + HOUR_TOPIC8;	

	TIME_TOPIC1 = Math.round(HOUR_TOPIC1 / TOTALTIME_HR * 100);
	TIME_TOPIC2 = Math.round(HOUR_TOPIC2 / TOTALTIME_HR * 100);
	TIME_TOPIC3 = Math.round(HOUR_TOPIC3 / TOTALTIME_HR * 100);
	TIME_TOPIC4 = Math.round(HOUR_TOPIC4 / TOTALTIME_HR * 100);
	TIME_TOPIC5 = Math.round(HOUR_TOPIC5 / TOTALTIME_HR * 100);
	TIME_TOPIC6 = Math.round(HOUR_TOPIC6 / TOTALTIME_HR * 100);
	TIME_TOPIC7 = Math.round(HOUR_TOPIC7 / TOTALTIME_HR * 100);
	TIME_TOPIC8 = Math.round(HOUR_TOPIC8 / TOTALTIME_HR * 100);
	
	EXAM_TOPIC1 = Math.round(TIME_TOPIC1);
	EXAM_TOPIC2 = Math.round(TIME_TOPIC2);
	EXAM_TOPIC3 = Math.round(TIME_TOPIC3);
	EXAM_TOPIC4 = Math.round(TIME_TOPIC4);
	EXAM_TOPIC5 = Math.round(TIME_TOPIC5);
	EXAM_TOPIC6 = Math.round(TIME_TOPIC6);
	EXAM_TOPIC7 = Math.round(TIME_TOPIC7);
	EXAM_TOPIC8 = Math.round(TIME_TOPIC8);
	}
	
	TOTALQ_TOPIC1 = QC1_TOPIC1 + QC2_TOPIC1 + QC3_TOPIC1 + QC4_TOPIC1 + QC5_TOPIC1 + QC6_TOPIC1;
	TOTALM_TOPIC1 = QC1_TOPIC1 * C1_TOPIC1 + QC2_TOPIC1 * C2_TOPIC1 + QC3_TOPIC1 * C3_TOPIC1 + QC4_TOPIC1 * C4_TOPIC1 + QC5_TOPIC1 * C5_TOPIC1 + QC6_TOPIC1 * C6_TOPIC1;
	TOTALQ_TOPIC2 = QC1_TOPIC2 + QC2_TOPIC2 + QC3_TOPIC2 + QC4_TOPIC2 + QC5_TOPIC2 + QC6_TOPIC2;
	TOTALM_TOPIC2 = QC1_TOPIC2 * C1_TOPIC2 + QC2_TOPIC2 * C2_TOPIC2 + QC3_TOPIC2 * C3_TOPIC2 + QC4_TOPIC2 * C4_TOPIC2 + QC5_TOPIC2 * C5_TOPIC2 + QC6_TOPIC2 * C6_TOPIC2;
	TOTALQ_TOPIC3 = QC1_TOPIC3 + QC2_TOPIC3 + QC3_TOPIC3 + QC4_TOPIC3 + QC5_TOPIC3 + QC6_TOPIC3;
	TOTALM_TOPIC3 = QC1_TOPIC3 * C1_TOPIC3 + QC2_TOPIC3 * C2_TOPIC3 + QC3_TOPIC3 * C3_TOPIC3 + QC4_TOPIC3 * C4_TOPIC3 + QC5_TOPIC3 * C5_TOPIC3 + QC6_TOPIC3 * C6_TOPIC3;
	TOTALQ_TOPIC4 = QC1_TOPIC4 + QC2_TOPIC4 + QC3_TOPIC4 + QC4_TOPIC4 + QC5_TOPIC4 + QC6_TOPIC4;
	TOTALM_TOPIC4 = QC1_TOPIC4 * C1_TOPIC4 + QC2_TOPIC4 * C2_TOPIC4 + QC3_TOPIC4 * C3_TOPIC4 + QC4_TOPIC4 * C4_TOPIC4 + QC5_TOPIC4 * C5_TOPIC4 + QC6_TOPIC4 * C6_TOPIC4;
	TOTALQ_TOPIC5 = QC1_TOPIC5 + QC2_TOPIC5 + QC3_TOPIC5 + QC4_TOPIC5 + QC5_TOPIC5 + QC6_TOPIC5;
	TOTALM_TOPIC5 = QC1_TOPIC5 * C1_TOPIC5 + QC2_TOPIC5 * C2_TOPIC5 + QC3_TOPIC5 * C3_TOPIC5 + QC4_TOPIC5 * C4_TOPIC5 + QC5_TOPIC5 * C5_TOPIC5 + QC6_TOPIC5 * C6_TOPIC5;
	TOTALQ_TOPIC6 = QC1_TOPIC6 + QC2_TOPIC6 + QC3_TOPIC6 + QC4_TOPIC6 + QC5_TOPIC6 + QC6_TOPIC6;
	TOTALM_TOPIC6 = QC1_TOPIC6 * C1_TOPIC6 + QC2_TOPIC6 * C2_TOPIC6 + QC3_TOPIC6 * C3_TOPIC6 + QC4_TOPIC6 * C4_TOPIC6 + QC5_TOPIC6 * C5_TOPIC6 + QC6_TOPIC6 * C6_TOPIC6;
	TOTALQ_TOPIC7 = QC1_TOPIC7 + QC2_TOPIC7 + QC3_TOPIC7 + QC4_TOPIC7 + QC5_TOPIC7 + QC6_TOPIC7;
	TOTALM_TOPIC7 = QC1_TOPIC1 * C1_TOPIC7 + QC2_TOPIC7 * C2_TOPIC7 + QC3_TOPIC7 * C3_TOPIC7 + QC4_TOPIC7 * C4_TOPIC7 + QC5_TOPIC7 * C5_TOPIC7 + QC6_TOPIC7 * C6_TOPIC7;
	TOTALQ_TOPIC8 = QC1_TOPIC8 + QC2_TOPIC8 + QC3_TOPIC8 + QC4_TOPIC8 + QC5_TOPIC8 + QC6_TOPIC8;
	TOTALM_TOPIC8 = QC1_TOPIC1 * C1_TOPIC8 + QC2_TOPIC8 * C2_TOPIC8 + QC3_TOPIC8 * C3_TOPIC8 + QC4_TOPIC8 * C4_TOPIC8 + QC5_TOPIC8 * C5_TOPIC8 + QC6_TOPIC8 * C6_TOPIC8;
	
	TOTALTIME_PERCENTAGE = TOTALTIME_PERCENTAGE + TIME_TOPIC1 + TIME_TOPIC2 + TIME_TOPIC3 + TIME_TOPIC4 + TIME_TOPIC5 + TIME_TOPIC6 + TIME_TOPIC7 + TIME_TOPIC8;	
	TOTALEXAM_PERCENTAGE = TOTALEXAM_PERCENTAGE + EXAM_TOPIC1 + EXAM_TOPIC2 + EXAM_TOPIC3 + EXAM_TOPIC4 + EXAM_TOPIC5 + EXAM_TOPIC6 + EXAM_TOPIC7 + EXAM_TOPIC8;	
	TOTALM_C1 = QC1_TOPIC1 * C1_TOPIC1 + QC1_TOPIC2 * C1_TOPIC2 + QC1_TOPIC3 * C1_TOPIC3 + QC1_TOPIC4 * C1_TOPIC4 + QC1_TOPIC5 * C1_TOPIC5 + QC1_TOPIC6 * C1_TOPIC6 + QC1_TOPIC7 * C1_TOPIC7 + QC1_TOPIC8 * C1_TOPIC8;	
	TOTALM_C2 = QC2_TOPIC1 * C2_TOPIC1 + QC2_TOPIC2 * C2_TOPIC2 + QC2_TOPIC3 * C2_TOPIC3 + QC2_TOPIC4 * C2_TOPIC4 + QC2_TOPIC5 * C2_TOPIC5 + QC2_TOPIC6 * C2_TOPIC6 + QC2_TOPIC7 * C2_TOPIC7 + QC2_TOPIC8 * C2_TOPIC8;
	TOTALM_C3 = QC3_TOPIC1 * C3_TOPIC1 + QC3_TOPIC2 * C3_TOPIC2 + QC3_TOPIC3 * C3_TOPIC3 + QC3_TOPIC4 * C3_TOPIC4 + QC3_TOPIC5 * C3_TOPIC5 + QC3_TOPIC6 * C3_TOPIC6 + QC3_TOPIC7 * C3_TOPIC7 + QC3_TOPIC8 * C3_TOPIC8;
	TOTALM_C4 = QC4_TOPIC1 * C4_TOPIC1 + QC4_TOPIC2 * C4_TOPIC2 + QC4_TOPIC3 * C4_TOPIC3 + QC4_TOPIC4 * C4_TOPIC4 + QC4_TOPIC5 * C4_TOPIC5 + QC4_TOPIC6 * C4_TOPIC6 + QC4_TOPIC7 * C4_TOPIC7 + QC4_TOPIC8 * C4_TOPIC8;	
	TOTALM_C5 = QC5_TOPIC1 * C5_TOPIC1 + QC5_TOPIC2 * C5_TOPIC2 + QC5_TOPIC3 * C5_TOPIC3 + QC5_TOPIC4 * C5_TOPIC4 + QC5_TOPIC5 * C5_TOPIC5 + QC5_TOPIC6 * C5_TOPIC6 + QC5_TOPIC7 * C5_TOPIC7 + QC5_TOPIC8 * C5_TOPIC8;
	TOTALM_C6 = QC6_TOPIC1 * C6_TOPIC1 + QC6_TOPIC2 * C6_TOPIC2 + QC6_TOPIC3 * C6_TOPIC3 + QC6_TOPIC4 * C6_TOPIC4 + QC6_TOPIC5 * C6_TOPIC5 + QC6_TOPIC6 * C6_TOPIC6 + QC6_TOPIC7 * C6_TOPIC7 + QC6_TOPIC8 * C6_TOPIC8;
	TOTALQ_ALL = TOTALQ_TOPIC1 + TOTALQ_TOPIC2 + TOTALQ_TOPIC3 + TOTALQ_TOPIC4 + TOTALQ_TOPIC5 + TOTALQ_TOPIC6 + TOTALQ_TOPIC7 + TOTALQ_TOPIC8;	
	TOTALM_ALL = TOTALM_TOPIC1 + TOTALM_TOPIC2 + TOTALM_TOPIC3 + TOTALM_TOPIC4 + TOTALM_TOPIC5 + TOTALM_TOPIC6 + TOTALM_TOPIC7 + TOTALM_TOPIC8;	
	
	document.getElementById('TIME_TOPIC1').value = TIME_TOPIC1;
	document.getElementById('TIME_TOPIC2').value = TIME_TOPIC2;
	document.getElementById('TIME_TOPIC3').value = TIME_TOPIC3;
	document.getElementById('TIME_TOPIC4').value = TIME_TOPIC4;
	document.getElementById('TIME_TOPIC5').value = TIME_TOPIC5;
	document.getElementById('TIME_TOPIC6').value = TIME_TOPIC6;
	document.getElementById('TIME_TOPIC7').value = TIME_TOPIC7;
	document.getElementById('TIME_TOPIC8').value = TIME_TOPIC8;
	
	document.getElementById('EXAM_TOPIC1').value = EXAM_TOPIC1;
	document.getElementById('EXAM_TOPIC2').value = EXAM_TOPIC2;
	document.getElementById('EXAM_TOPIC3').value = EXAM_TOPIC3;
	document.getElementById('EXAM_TOPIC4').value = EXAM_TOPIC4;
	document.getElementById('EXAM_TOPIC5').value = EXAM_TOPIC5;
	document.getElementById('EXAM_TOPIC6').value = EXAM_TOPIC6;
	document.getElementById('EXAM_TOPIC7').value = EXAM_TOPIC7;
	document.getElementById('EXAM_TOPIC8').value = EXAM_TOPIC8;
	
	document.getElementById('TOTALQ_TOPIC1').value = TOTALQ_TOPIC1;
	document.getElementById('TOTALM_TOPIC1').value = TOTALM_TOPIC1;		
	document.getElementById('TOTALQ_TOPIC2').value = TOTALQ_TOPIC2;
	document.getElementById('TOTALM_TOPIC2').value = TOTALM_TOPIC2;	
	document.getElementById('TOTALQ_TOPIC3').value = TOTALQ_TOPIC3;
	document.getElementById('TOTALM_TOPIC3').value = TOTALM_TOPIC3;	
	document.getElementById('TOTALQ_TOPIC4').value = TOTALQ_TOPIC4;
	document.getElementById('TOTALM_TOPIC4').value = TOTALM_TOPIC4;	
	document.getElementById('TOTALQ_TOPIC5').value = TOTALQ_TOPIC5;
	document.getElementById('TOTALM_TOPIC5').value = TOTALM_TOPIC5;	
	document.getElementById('TOTALQ_TOPIC6').value = TOTALQ_TOPIC6;
	document.getElementById('TOTALM_TOPIC6').value = TOTALM_TOPIC6;	
	document.getElementById('TOTALQ_TOPIC7').value = TOTALQ_TOPIC7;
	document.getElementById('TOTALM_TOPIC7').value = TOTALM_TOPIC7;	
	document.getElementById('TOTALQ_TOPIC8').value = TOTALQ_TOPIC8;
	document.getElementById('TOTALM_TOPIC8').value = TOTALM_TOPIC8;	
	
	document.getElementById('TOTALTIME_HR').value = TOTALTIME_HR;	
	document.getElementById('TOTALTIME_PERCENTAGE').value = TOTALTIME_PERCENTAGE;	
	document.getElementById('TOTALEXAM_PERCENTAGE').value = TOTALEXAM_PERCENTAGE;	
	document.getElementById('TOTALM_C1').value = TOTALM_C1;	
	document.getElementById('TOTALM_C2').value = TOTALM_C2;	
	document.getElementById('TOTALM_C3').value = TOTALM_C3;	
	document.getElementById('TOTALM_C4').value = TOTALM_C4;	
	document.getElementById('TOTALM_C5').value = TOTALM_C5;	
	document.getElementById('TOTALM_C6').value = TOTALM_C6;	
	document.getElementById('TOTALQ_ALL').value = TOTALQ_ALL;	
	document.getElementById('TOTALM_ALL').value = TOTALM_ALL;	
  }
</script>
							</div>
						</div>
						<div class="center">
							<button type="submit" class="btn btn-success">Submit</button>
						</div>
					</form>
					<hr />
				</div>
				<div class="col-md-4 col-sm-4"></div>
				<div class="col-md-4 col-sm-4">
					<div class="table-responsive">
						<br>
						<table class="table">
							<tbody>
								<tr>
									<th class="center" colspan="3">Cognitive Levels</th>
								</tr>
								<tr class="success">
									<td>C1</td>
									<td>Remembering/Knowledge</td>
									<td rowspan="2">Easy</td>
								</tr>
								<tr class="success">
									<td>C2</td>
									<td>Understanding/Comprehension</td>
								</tr>
								<tr class="warning">
									<td>C3</td>
									<td>Applying/Application</td>
									<td rowspan="2">Medium</td>
								</tr>
								<tr class="warning">
									<td>C4</td>
									<td>Analysing/Analysis</td>
								</tr>
								<tr class="danger">
									<td>C5</td>
									<td>Creating/Synthesis</td>
									<td rowspan="2">Hard</td>
								</tr>
								<tr class="danger">
									<td>C6</td>
									<td>Evaluating/Evaluation</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="col-md-4 col-sm-4"></div>
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