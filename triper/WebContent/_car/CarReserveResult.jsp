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
		<td align="center" width="150">�����̹���</td>
		<td align="center" width="100">������</td>
		<td align="center" width="100">�뿩��</td>
		<td align="center" width="100">�ݳ���</td>
		<td align="center" width="50">�뿩�Ⱓ</td>
		<td align="center" width="100">�� �ݾ�</td>
		<td align="center" width="70">���迩��</td>
		<td align="center" width="70">����wifi</td>
		<td align="center" width="70">�׺���̼�</td>
		<td align="center" width="70">���̺��Ʈ</td>
		<td align="center" width="100">����</td>
		<td align="center" width="100">����</td>
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
			<c:if test="${v.reserved_option_usein==1 }">���谡��</c:if>
			<c:if test="${v.reserved_option_usein==0 }">����̰���</c:if>
		</td>
		<td align="center" width="70">
			<c:if test="${v.reserved_option_carwifi==1 }">�뿩</c:if>
			<c:if test="${v.reserved_option_carwifi==0 }">�̴뿩</c:if>
		</td>
		<td align="center" width="70">
			<c:if test="${v.reserved_option_carnavi==1 }">�뿩</c:if>
			<c:if test="${v.reserved_option_carnavi==0 }">�̴뿩</c:if>
		</td>
		<td align="center" width="70">
			<c:if test="${v.reserved_option_carseat==1 }">�뿩</c:if>
			<c:if test="${v.reserved_option_carseat==0 }">�̴뿩</c:if>
		</td>
		<td align="center" width="100">
			<button onclick="location.href='CarConfirmUpdateController.do?orderid=${v.orderid}&carimg=${v.product_carimg }'">����</button>
		</td>
		<td align="center" width="100">
			<button onclick="location.href='/CarReserVationProject/_car/CarMain.jsp?center=CarConfirmDelete.jsp&orderid=${v.orderid}'">����</button>
		</td>	
	
	</c:forEach>	
	
	
	</table>
</center>
</body>
</html>






