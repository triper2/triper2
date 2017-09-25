<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/custom.css">
<link rel="stylesheet" href="../css/review.css">

<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="../js/bootstrap.js"></script>

<html>
<body>

	<form action="../_car/CarReserveConfirmController.do" method="post">
	<table  class="table" width="50%" style="background-color:white; text-align: center; border: 1px solid #dddddd">
	
		<tr>
		<td height="50px" style="text-align: left; font-size:32px;">예약확인<hr></td></tr>
		<tr>
		<td>	
			<input type="text" placeholder="전화번호 입력  " name="memberphone" class="form-control">
		
		</td>
		</tr>
		<tr>
		<td>
			<input type="password" placeholder="비밀번호 입력 " name="memberpass" class="form-control">
		
		</td>
		</tr>
		<tr height="60" align="center">
			<td align="center">
			<input class="btn btn-primary" type="submit" value="검색하기"></td>
		</tr>
	</table>
	</form>




</body>
</html>