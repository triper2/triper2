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
	<h1>  주문 수정 페이지 </h1>
	<form action ="BoardUpdateProcController.do?b_orderid=${bbean.b_orderid }" method="post">
	<table width="1000" border="0" align="center">
		<tr align="center">
			<td rowspan="8" width="600">
				<img alt="" src="img/${bbean.product_boardimg }" width="500" border="0">
			</td>
		</tr>
	<tr>
		<td align="center" >대여일</td>
		<td align="center">
		<input type="date" name="boardbeginday" value="${bbean.boardbeginday }"></td>
	</tr>
	<tr>
		<td align="center" >반납일</td>
		<td align="center">
		<input type="date" name="boardendday" value="${bbean.boardendday }"></td>
	</tr>
	<tr>
		<td align="center" colspan="2">사이즈 <select name="boardsize">
					<option value="250">250</option>
						<option value="255">255</option>
						<option value="260">260</option>
						<option value="265">265</option>
				</select>
			</tr>
	
	<tr>
		<td	align="center" colspan="2">
		
		비밀번호 입력 : <input type="password" name="memberpass" size="10">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
			
		</td>
		
	</tr>
	<tr>
	<td align="center" colspan="2"><input type="submit" value = "수정하기"></td>
	</tr>	
			
			
	</table>
	
	</form>
</center>
</body>
</html>