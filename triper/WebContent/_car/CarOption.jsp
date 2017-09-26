<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

<center>
	<img src="img/option.jpg" border="0">
	
	<form action="../_car/CarOptionController.do?business_id=${param.business_id }" method="post">
	<table width="1000" border="0" align="center">
	<tr align="center">
		<td rowspan="9" width="600">
		<img alt="" src="img/${param.carimg }" width="500" >
		</td>
		<td align="center" width="200"> 대여일 </td>
		<td align="center"><input type="date" name="carbegindate"></td>
		
	</tr>
	<tr>
		<td align="center"> 빌릴시간 </td>
		<td align="center"><input type="time" name="carbegintime"></td>
	</tr>
	<tr>
		<td align="center"> 반납일 </td>
		<td align="center"><input type="date" name="carenddate"></td>
	</tr>
	<tr>
		<td align="center"> 반납시간 </td>
		<td align="center"><input type="time" name="carendtime"></td>
	</tr>	
	<tr>
		<td align="center"> 보험 적용 </td>
		<td align="center"><select name="carins">
							<option value="1">적용(1일 1만원)</option>
							<option value="0">비적용</option>
						   </select></td>
	</tr>	
	<tr>
		<td align="center"> 무선 wifi </td>
		<td align="center"><select name="carwifi">
							<option value="1">적용(1일 1만원)</option>
							<option value="0">비적용</option>
						   </select></td>
	</tr>	
	<tr>
		<td align="center"> 네비게이션 </td>
		<td align="center"><select name="carnavi">
							<option value="1">적용(무료)</option>
							<option value="0">비적용</option>
						   </select></td>
	</tr>	
	<tr>
		<td align="center"> 베이비 시트 </td>
		<td align="center"><select name="carbabyseat">
							<option value="1">적용(1일 1만원)</option>
							<option value="0">비적용</option>
						   </select></td>
	</tr>									
	<tr>
		<td align="center">
		<input type="hidden" name="carno" value="${param.carno }">
		<input type="hidden" name="carqty" value="${param.carqty }">
		<input type="hidden" name="carprice" value="${param.carprice }">
		<input type="button" onclick="location.href='../_car/CarListController.do?business_id=${param.business_id }'"
		 value="차량목록보기"></td>
		<td align="center">
			<input type="submit" value="예약하기"></td> 
	</tr>
	</table>
	</form>
</center>

</body>
</html>