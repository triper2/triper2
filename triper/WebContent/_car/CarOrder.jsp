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
<c:if test="${compare <0 }">
<script>
			alert("날짜를 다시 선택해 주세요.");
			history.go(-1);
		</script>
</c:if>
<c:if test="${compare1 <0 }">
<script>
			alert("날짜를 다시 선택해 주세요.");
			history.go(-1);
		</script>
</c:if>
<c:if test="${calDateDays <0 }">
<script>
			alert("날짜를 다시 선택해 주세요.");
			history.go(-1);
		</script>
</c:if>
<center>


	<img alt="" src="img/haki.jpg" border="0">
	
	<form action="CarOrderController.do" method="post">
	<p>
	<font size="13" color="blue">차량 렌트 비용 : ￦ ${totalreserve } 원</font>
	<p>
	<font size="13" color="blue">차량 옵션 비용 : ￦ ${totaloption } 원</font>
	<p>

	<font size="17" color="red"> 총 비용 : ￦ ${totalreserve + totaloption } 원</font>
	<!-- 예약에 관련된 데이터를 carordercontroller.do 파일로 -->
	<input type="hidden" name="carno" value="${cbean.product_carno }">
	<input type="hidden" name="carqty" value="${cbean.reserved_product_count }">
	<input type="hidden" name="carins" value="${cbean.reserved_option_usein }">
	<input type="hidden" name="carwifi" value="${cbean.reserved_option_carwifi }">
	<input type="hidden" name="carnavi" value="${cbean.reserved_option_carnavi }">
	<input type="hidden" name="carbabyseat" value="${cbean.reserved_option_carbabyseat }">
	<input type="hidden" name="carbegindate" value="${cbean.reserved_carbegindate }">
	<input type="hidden" name="carenddate" value="${cbean.reserved_carenddate }">
	<input type="hidden" name="totalprice" value="${cbean.totalprice }">
	<input type="hidden" name="caldateDays" value="${cbean.calDateDays }">
	
	
	<p>
	비회원 전화번호 예약 : 
	<input type="text" name = "memberphone" size="10">&nbsp;&nbsp;&nbsp;
	비밀 번호 : 
	<input type="password" name = "memberpass" size="10">
	<input type="submit" value="결재하기">
	</form>
</center>

</body>
</html>