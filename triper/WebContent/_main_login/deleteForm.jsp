<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dbconn.util.*, dbclose.util.*, kosta.rental.loginModel.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 회원 탈퇴 창 </title>
<!-- Bootstrap styles -->
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.6.2/css/font-awesome.min.css">

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
</style>
${ sessionScope.sessionInfo }
${ sessionScope.id }
<!-- <c:set var="sessionInfo" value="${ sessionScope.sessionInfo }"/> -->
</head>
<c:remove scope="session" var="sessionInfo" />
<c:remove scope="session" var="id" /> 
<body>
	<nav>
		<div class="container">
			<ul>
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">My page<i class='fa fa-angle-down'></i></a>
					<ul>
						<li><a href="#">예매결제내역조회 아직</a></li>
						<li><a href="modifyFrom.jsp">회원 정보 수정</a></li>
						<li><a href="deleteForm.jsp">회원 탈퇴</a></li>
					</ul></li>
				<li><a href="#">리뷰 아직<i class='fa fa-angle-down'></i></a>
					<ul>
						<li><a href="#">샘플1</a></li>
						<li><a href="#">샘플2</a></li>
						<li><a href="#">샘플3</a></li>
						<li><a href="#">샘플4</a></li>
					</ul></li>
				<li><a href="#">예약(지도) 아직<i class='fa fa-angle-down'></i></a>
					<ul>
						<li><a href="#">샘플1</a></li>
						<li><a href="#">샘플2</a></li>
						<li><a href="#">샘플3</a></li>
						<li><a href="#">샘플4</a></li>
					</ul></li>
				<li><a href="#">고객센터 아직<i class='fa fa-angle-down'></i></a>
					<ul>
						<li><a href="#">샘플1</a></li>
						<li><a href="#">샘플2</a></li>
						<li><a href="#">샘플3</a></li>
						<li><a href="#">샘플4</a></li>
					</ul></li>
				<li><a href="#">회사소개 아직</a></li>
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
<script type="text/javascript">
	/* function begin(){
		document.myform.password.focus();
	}
	
	function checkIt(){
		if(!document.myform.password.value){
			alert("취소! 메인으로 갑니다.");
			document.myform.password.focus();
			return false;
		}
	} */
</script>
<script type="text/javascript">
        // 비밀번호 미입력시 경고창
        function checkValue(){
            if(!document.deleteform.password.value){
                alert("비밀번호를 입력하지 않았습니다.");
                return false;
            }
        }
</script>

<body align="center"><br/><br/><br/><br/><br/>
<form name="myform"  method="post" action="deletePro.do" onsubmit="return checkValue()">
<div id="fadeandscale" class="well">
			<label width="100" align="center">PASSWORD 
			<input type="password" name="password" size="15" maxlength="15">
		<br/><br/>
			<input type="submit" value="탈퇴"> 
			<input type="submit"  value="취소" onclick="javascript:window.location='index.jsp'">
		</div>
</form>
</body>
</html>