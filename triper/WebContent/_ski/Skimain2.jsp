<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dbconn.util.*, dbclose.util.*, kosta.rental.loginModel.*, kosta.rental.loginAction.*"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title> header.jsp </title>
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/custom.css">
<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="./js/bootstrap.js"></script>
<!-- Bootstrap styles -->
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/font-awesome/4.6.2/css/font-awesome.min.css">

<style>
@import url(https://fonts.googleapis.com/css?family=Roboto:400,700,500);

/* main Styles */
html {
	box-sizing: border-box;
}

*, *:before, *:after {
	box-sizing: inherit;
}

body {
	background: #E8FFFF;
	font-family: "Roboto", sans-serif;
	font-size: 14px;
	margin: 0;
	padding : 0;
	background : url (img.jpg) center center fixed no-repeat;
}

a {
	text-decoration: none;
}

.container {
	width: 1000px;
	margin: auto;
}

h1 {
	text-align: center;
	margin-top: 150px;
}

/* Navigation Styles */
nav {
	background: #2ba0db;
}

nav ul {
	font-size: 0;
	margin: 0;
	padding: 0;
}

nav ul li {
	display: inline-block;
	position: relative;
}

nav ul li a {
	color: #fff;
	display: block;
	font-size: 14px;
	padding: 15px 14px;
	transition: 0.3s linear;
}

nav ul li:hover {
	background: #126d9b;
}

nav ul li ul {
	border-bottom: 5px solid #2ba0db;
	display: none;
	position: absolute;
	width: 250px;
}

nav ul li ul li {
	border-top: 1px solid #444;
	display: block;
}

nav ul li ul li:first-child {
	border-top: none;
}

nav ul li ul li a {
	background: #373737;
	display: block;
	padding: 10px 14px;
}

nav ul li ul li a:hover {
	background: #126d9b;
}

nav .fa.fa-angle-down {
	margin-left: 6px;
}

body {
	margin : 0;
	padding : 0;
	background : url (img.jpg) center center fixed no-repeat;
}
video {
	position : fixed;
	top : -70px; 
	left : 0;
	min-width : 100 %;
	min-height : 100 %;
	width : 100%;
	z-index : -1;
	muted : false;
}


</style>


</head>

<body align="center">
	<nav>
		<div class="container">
			<ul>
				<li style="z-index: 999;"><a href="/triper/_main_login/main.jsp"><div style="width:80px; height: 40px;">Home</div></a></li>
				<li style="z-index: 999;"><a href="/triper/_ski/Skimain2.jsp">Ski Home</a></li>
				<li style="z-index: 999;"><a href="#">SKI<i class='fa fa-angle-down'></i></a>
					<ul>
						<li><a href="/triper/SkiListController2.ski">SKI</a></li>
						<li><a href="/triper/SkiClothListController.do">SKICLOTH</a></li>
						
					</ul></li>
				<li style="z-index: 999;"><a href="#">BOARD<i class='fa fa-angle-down'></i></a>
					<ul>
						<li><a href="/triper/BoardListController.do">BOARD</a></li>
						<li><a href="/triper/BoardClothListController.do">BOARDCLOTH</a></li>
					</ul></li>
				<li style="z-index: 999;"><a href="/triper/_ski/SkiMain.jsp?center=ReserveConfirm.jsp">예약확인<i class='fa fa-angle-down'></i></a>
					</li>
				<li style="z-index: 999;"><a href="/triper/_ski/SkiMain.jsp?center=Add.jsp">상품추가</a></li>
				<c:if test="${ sessionScope.dto != null }">
				<li style="float:right"><a href="../_main_login/logoutPro.jsp">Log out</a></li>
				<li style="float:right; margin-top:10px;">  
				<img class="media-object img-circle" src="../_main_login/mem_img/${ dto.member_img }" height="35" width="35" alt="">
					<ul>
						<li><a href="#">예매결제내역조회 아직</a></li>
						<li><a href="../_main_login/modifyFrom.jsp">회원 정보 수정</a></li>
						<!-- Fade & scale -->
						<li><a href="../_main_login/deleteForm.jsp">회원 탈퇴</a></li>
					</ul>
				</li>
				</c:if>
				<c:if test="${ sessionScope.dto == null }">
				<li style="float:right"> <a href="../_main_login/loginForm.jsp">Login</a></li>
				</c:if>
			</ul>
		</div>
	</nav>

	<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script>
		$('nav li').hover(function() {
			$('ul', this).stop().slideDown(200);
		}, function() {
			$('ul', this).stop().slideUp(200);
		});
	</script>
			
		<!-- Fade & scale -->
		<!-- <div id="fadeandscale" class="well">
			<label width="100" align="center">PASSWORD 
			<input type="password" name="password" size="15" maxlength="12">
		<br/><br/>
			<input type="submit" onclick="javascript:window.location='deletePro.jsp'" value="탈퇴"> 
			<input type="submit" onclick="javascript:window.location='index.html'" value="취소">
		</div> -->
		
		
		
		
		<!-- <div id='small-popup' class="needpopup">
				<div id="fadeandscale" class="well">
			<label width="100" align="center">PASSWORD 
			<input type="password" name="password" size="15" maxlength="12">
		<br/><br/>
			<input type="submit" onclick="javascript:window.location='deletePro.jsp'" value="탈퇴"> 
			<input type="submit" onclick="javascript:window.location='index.html'" value="취소"> -->
			
	<video autoplay loop poster = "img.jpg" muted="false">
		<source src = "../image/Untitled.mp4"type = "video/mp4">
	</video>
			
</body>
</html>
