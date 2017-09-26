<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<center>
	<img alt="" src="img/hwakin.jpg" border="0">
	<form action="../_car/CarReserveConfirmController.do?business_id=${business_id }" method="post">
	<table width="400" border="0">
		<tr height="60" align="center">
			<td align="center"	width="200"> 전화번호 입력 : </td>
			<td align="center"><input type="text" name="memberphone"></td>
		</tr>
		<tr height="60" align="center">
			<td align="center"	width="200"> 비밀번호 입력 : </td>
			<td align="center"><input type="password" name="memberpass"></td>
		</tr>
		<tr height="60" align="center">
			<td colspan="2" align="center">
			<input type="submit" value="검색하기"></td>
		</tr>
	</table>
	
	</form>

</center>

</body>
</html>