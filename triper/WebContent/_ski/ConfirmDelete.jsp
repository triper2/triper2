<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1> 주문 정보 취소 </h1>
	
	<form action="../ConfirmDeleteController.do" method="post">
	<p>
	<table width="400" border="0">
	
	<tr align="center">
		<td align="center"> 비밀번호 입력 : 
		<input type="hidden" value="${ param.s_orderid }" name="s_orderid">
		<input type="hidden" value="${ param.sc_orderid }" name="sc_orderid">
		<input type="hidden" value="${ param.b_orderid }" name="b_orderid">
		<input type="hidden" value="${ param.bl_orderid }" name="bl_orderid">
		<input type="password" name="memberpass"> &nbsp;&nbsp;&nbsp;
		<input type="submit" value="취소 하기"></td>
	</tr>	
			
	
	
	
	</table>	
	</form>	
</center>	
</body>
</html>