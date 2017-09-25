<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<center>
	<img alt="" src="img/naeyeok.jpg" border="0">
	<p></p>
	<table width="1000" border="1" align="center">
	<tr align="center">
		<td align="center" width="150">차량이미지</td>
		<td align="center" width="100">차량명</td>
		<td align="center" width="100">대여일</td>
		<td align="center" width="100">반납입</td>
		<td align="center" width="50">대여기간</td>
		<td align="center" width="100">총 금액</td>
		<td align="center" width="70">보험여부</td>
		<td align="center" width="70">무선wifi</td>
		<td align="center" width="70">네비게이션</td>
		<td align="center" width="70">베이비시트</td>
		<td align="center" width="100">수정</td>
		<td align="center" width="100">삭제</td>
	</tr>
	<c:forEach var="v" items="${v }">
	<tr align="center" height="60">
		<td align="center" width="150">
		<img alt="" src="img/${v.product_carimg }" width="140" height="90" border="0"></td>
		<td align="center" width="100">${v.product_carname  }</td>
		<td align="center" width="100">${v.reserved_carbegindate }</td>
		<td align="center" width="100">${v.reserved_carenddate }</td>
		<td align="center" width="50">${v.calDateDays }</td>
		<td align="center" width="100">${v.totalprice } </td>
		<td align="center" width="70">
			<c:if test="${v.reserved_option_usein==1 }">보험가입</c:if>
			<c:if test="${v.reserved_option_usein==0 }">보험미가입</c:if>
		</td>
		<td align="center" width="70">
			<c:if test="${v.reserved_option_carwifi==1 }">대여</c:if>
			<c:if test="${v.reserved_option_carwifi==0 }">미대여</c:if>
		</td>
		<td align="center" width="70">
			<c:if test="${v.reserved_option_carnavi==1 }">대여</c:if>
			<c:if test="${v.reserved_option_carnavi==0 }">미대여</c:if>
		</td>
		<td align="center" width="70">
			<c:if test="${v.reserved_option_carseat==1 }">대여</c:if>
			<c:if test="${v.reserved_option_carseat==0 }">미대여</c:if>
		</td>
		<td align="center" width="100">
			<button onclick="location.href='CarConfirmUpdateController.do?orderid=${v.orderid}&carimg=${v.product_carimg }'">수정</button>
		</td>
		<td align="center" width="100">
			<button onclick="location.href='/CarReserVationProject/_car/CarMain.jsp?center=CarConfirmDelete.jsp&orderid=${v.orderid}'">삭제</button>
		</td>	
	
	</c:forEach>	
	
	
	</table>
</center>
</body>
</html>






