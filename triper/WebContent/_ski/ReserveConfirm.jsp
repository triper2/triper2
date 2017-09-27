<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/button.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/custom.css">
<title></title>
<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="../js/bootstrap.js"></script>
</head>
<body>
<center>
	
	<form action="../ReserveConfirmController.do" method="post">
	<table width="50%" border="0" style=" background : rgba(0, 0, 0, 0.6); border-radius: 10px;">
		<tr height="60" align="center">
			<td align="center"><div class="col-xs-12"><input class="form-control" placeholder="전화번호 입력" type="text" name="memberphone"></div></td>
		</tr>
		<tr height="60" align="center">
			<td align="center"><div class="col-xs-12"><input class="form-control" placeholder="비밀번호 입력" type="password" name="memberpass"></div></td>
		</tr>
		<tr height="60" align="center">
			<td colspan="2" align="center">
			<button class="button button5" onclick="submit()">검 색 하 기
			</button></td>
		</tr>
	</table>
	
	</form>

</center>
</body>
</html>