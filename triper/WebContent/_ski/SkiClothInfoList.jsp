<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 16px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	-webkit-transition-duration: 0.4s; /* Safari */
	transition-duration: 0.4s;
	cursor: pointer;
}

.button1 {
	background-color: white;
	color: black;
	border: 2px solid #4CAF50;
}

.button1:hover {
	background-color: #4CAF50;
	color: white;
}

.button2 {
	background-color: white;
	color: black;
	border: 2px solid #008CBA;
}

.button2:hover {
	background-color: #008CBA;
	color: white;
}

.button3 {
	background-color: white;
	color: black;
	border: 2px solid #f44336;
}

.button3:hover {
	background-color: #f44336;
	color: white;
}

.button4 {
	background-color: white;
	color: black;
	border: 2px solid #e7e7e7;
}

.button4:hover {
	background-color: #e7e7e7;
}

.button5 {
	background-color: white;
	color: black;
	border: 2px solid #555555;
}

.button5:hover {
	background-color: #555555;
	color: white;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="skiClothReservation.do">
		<table width="1000" height="400">
			<tr>
				<td colspan="2" height="50"></td>
			</tr>
			<tr>
				<td rowspan="5" align="center"><img
					src="img/${bean.product_skiclothimg }" width="300" height="300"></td>
				<td width="500" align="center"><font color="gray" size="5">
						예 약 하 기 </font></td>
			</tr>
			<tr>
				<td align="center">대여일 <input type="date"
					name="skiclothbeginday"></td>
			</tr>
			<tr>
				<td align="center">반납일 <input type="date"
					name="skiclothendday"></td>
			</tr>
			<tr>
				<td align="center">사이즈 <select name="skiclothsize">
						<option value="90">90</option>
						<option value="95">95</option>
						<option value="100">100</option>
						<option value="105">105</option>
				</select>
			</tr>
			<tr>
				<td align="center">대여 가격 ${bean.product_skiclothprice } 원</td>
			</tr>
			




		</table>
		<center>
			<button class="button button5" onclick="submit()">예 약 하 기</button>
		</center>
		<hr>
		<img alt="" src="img/${bean.product_skiclothinfo }" width="1000">
		<input type="hidden" name="skiclothno" value="${param.product_skiclothno }">
		 <input type="hidden"name="skiclothprice" value="${bean.product_skiclothprice }">
		<input type="hidden" name="product_skiclothname" value="${bean.product_skiclothname }"> 
		<input type="hidden" name="product_skiclothimg" value="${bean.product_skiclothimg }"> <br>
		<br>
	</form>
</body>
</html>