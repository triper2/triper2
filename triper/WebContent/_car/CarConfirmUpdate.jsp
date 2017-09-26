<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1> 차량 주문 수정 페이지 </h1>
	<form action ="CarConfirmUpdateProcController.do?orderid=${cbean.orderid }&carprice=${cpbean.product_carprice}" method="post">
	<table width="1000" border="0" align="center">
		<tr align="center">
			<td rowspan="8" width="600">
				<img alt="" src="img/${cbean.product_carimg }" width="500" border="0">
			</td>
		</tr>
		<tr>
		<td align="center" >대여일</td>
		<td align="center">
		<input type="date" name="carbegindate" value="${cbean.reserved_carbegindate }"></td>
	</tr>
	<tr>
		<td align="center" >반납일</td>
		<td align="center">
		<input type="date" name="carenddate" value="${cbean.reserved_carenddate }"></td>
	</tr>
	<tr>
		<td align="center" width="200"> 차량수량 </td>
		<td align="center" width="200" >
					<select name="carqty">
						<option value="1">1대</option>
						<option value="2">2대</option>
						<option value="3">3대</option>
						<option value="4">4대</option>
						<option value="5">5대</option>
					</select></td>
	</tr>	
	<tr>
		<td align="center" width="200"> 보험적용 </td>
		<td align="center" width="200" >
					<select name="carins">
						<option value="1">적용(1일 만원)</option>
						<option value="0">비적용</option>
					</select></td>
	</tr>		
	<tr>
		<td align="center" width="200"> 무선wifi </td>
		<td align="center" width="200" >
					<select name="carwifi">
						<option value="1">적용(1일 만원)</option>
						<option value="0">비적용</option>
					</select></td>
	</tr>	
	<tr>
		<td align="center" width="200"> 베이비시트 </td>
		<td align="center" width="200" >
					<select name="carbabyseat">
						<option value="1">적용(1일 만원)</option>
						<option value="0">비적용</option>
					</select></td>
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