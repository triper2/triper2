<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<center>
	<h1> ���� �ֹ� ���� ���� </h1>
	
	<form action="../_car/CarConfirmDeleteController.do?business_id=${param.business_id }" method="post">
	<p>
	<table width="400" border="0">
	<c:set var="result" value="${ result }"  />
	<c:if test="${ result==null }">
		<c:set var="result" value="${1 }"  />
	</c:if>	
	
	<c:if test="${result==0 }">
		<script>
			alert("��й�ȣ�� Ʋ���ϴ�.");
			history.go(-1);
			</script>
	</c:if>
	
	
	<tr align="center">
		<td align="center"> ��й�ȣ �Է� : 
		<input type="hidden" value="${ param.orderid }" name="orderid">
		<input type="password" name="memberpass"> &nbsp;&nbsp;&nbsp;
		<input type="submit" value="���� �ϱ�"></td>
	</tr>	
			
			
	
	</table>	
	</form>	
</center>	
	

</body>
</html>





