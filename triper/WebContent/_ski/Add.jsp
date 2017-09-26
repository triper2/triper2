<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
.button2 {
    background-color: black; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}

.button2 {border-radius: 4px;}



h3 {
	color: #eee;
	font: 30px Arial, sans-serif;
	-webkit-font-smoothing: antialiased;
	text-shadow: 0px 1px black;
	text-align: left;
	margin-bottom: 50px;
}

select {
    width: 200px;
    height: 30px;
    padding-left: 10px;
    font-size: 18px;
    color: #8C8C8C;
    border: 1px solid #8C8C8C;
    border-radius: 3px;
}
/* 
.container { padding:40px; }
.container ul {
 list-style: outside none none;
 margin: 0;
 padding: 0;
 width: 800px;
}
.container li {
 float: left;
 line-height: 32px;
 width: 20%;
}

.input-style {
 display: none;
}
.input-style + label {
 -moz-user-select: none;
 color: black;
 cursor: pointer;
 display: block;
 font-family: tahoma;
 font-size: 15px;
 padding: 0 0 0 50px;
 position: relative;
}
.input-style + label:before, .input-style + label:after {
 position: absolute;
 display: inline-block;
 left: 0;
 width: 40px;
 height: 40px;
 vertical-align: middle;
 content: "";
}
.input-style + label:before {
 box-shadow: inset 0px 0px 4px 0px rgba(0, 0, 0, 0.3);
 background: #fff;
}
.input-style + label:after {
 background: gray;
 transform: scale(0, 0);
 transition: all 0.1s ease-out;
}
.input-style:checked + label:after { 
 transform: scale(0.7, 0.7);
}
.input-style[type="radio"] + label:before,
.input-style[type="radio"] + label:after {
 border-radius: 50%;
}
.input-style.toggle + label {
 padding-left: 3.5em;
} */
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
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>
	<div class="container">
		<h2>차량 등록 하기<button class="button button2" style="float: right;" onclick="location.href='/triper/_ski/Skimain2.jsp'">되돌아가기</button></h2>
	
	</div>

	<form class="w3-container" action="../AddController.do" method="post" encType="multipart/form-data">
	
	
 <h3>상품 종류</h3>
	  <select name="ski">
        <option value="ski"> SKI </option>
        <option value="skicloth"> SKICLOTH </option>
        <option value="board"> BOARD </option>
        <option value="boardcloth"> BOARDCLOTH </option>
    </select> 
		<p>
			<label>번 호</label> <input class="w3-input" type="text" name="no" placeholder="숫자만 입력하세요">
		</p>
		<p>
			<label>상 품 이 름</label> <input class="w3-input" type="text" name= "name">
		</p>
		<p>
			<label>상 품 가 격</label> <input class="w3-input" type="text" name= "price" placeholder="숫자만 입력하세요">
		</p>
		<p>
			<label>상 품 정 보</label> <input class="w3-input" type="file" name= "info">
		</p>
		<p>
			<label>상품 이미지</label> <input class="w3-input" type="file" name= "img">
		</p>
	
		
	<div class="w3-panel">
	
  			<input type="submit" class="w3-btn w3-block" value="등ㅇ" >
	</div>
	</form>

</body>
</html>