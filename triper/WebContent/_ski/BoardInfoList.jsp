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
	<form action="BoardReservation.do"method="post">
		<table width="1000" height="400">
			<tr>
				<td colspan="2" height="50"></td>
			</tr>
			<tr>
				<td rowspan="5" align="center"><img
					src="img/${bean.product_boardimg }" width="300" height="300"></td>
				<td width="500" align="center"><font color="gray" size="5">
						예 약 하 기 </font></td>
			</tr>
			<tr>
				<td align="center">대여일 <input type="date"
					name="boardbeginday"></td>
			</tr>
			<tr>
				<td align="center">반납일 <input type="date"
					name="boardendday"></td>
			</tr>
			<tr>
				<td align="center">사이즈 <select name="boardsize">
					<option value="250">250</option>
						<option value="255">255</option>
						<option value="260">260</option>
						<option value="265">265</option>
				</select>
			</tr>
			<tr>
				<td align="center">대여 가격 ${bean.product_boardprice } 원</td>
			</tr>
		



		</table>
		<center>
			<button class="button button5" onclick="submit()">예 약 하 기</button>
		</center>
		<hr>
		<img alt="" src="img/${bean.product_boardinfo }" width="1000">
		<input type="hidden" name="boardno" value="${bean.product_boardno }">
		 <input type="hidden"name="boardprice" value="${bean.product_boardprice }">
		<input type="hidden" name="product_boardname" value="${bean.product_boardname }"> 
		<input type="hidden" name="product_boardimg" value="${bean.product_boardimg }"> <br>
		<br>
	</form>
</body>
</html>