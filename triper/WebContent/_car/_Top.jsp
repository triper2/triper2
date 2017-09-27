<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<bady style="background-color:white;">
<!-- 	
	메인 로고를 누르면 메인페이지로 이동하도록 소스를 작성
	<a href="CarMain.jsp"> <img src="img/RENT.jpg" align="left" 
	width="300" height="80" border="0"> </a>
	
	<table width="1000" background="img/aa.jpg" height="5">
		<tr>
		 <td align="center" bgcolor="red">
		 	<a href="CarMain.jsp?center=CarReservation.jsp">
		 		<img alt="" src="img/bb.jpg" border="0"></a> 예약하기
		 </td>	
		 <td align="center" bgcolor="red">
		 	<a href="CarMain.jsp?center=CarReserveConfirm.jsp">
		 		<img alt="" src="img/cc.jpg" border="0"></a> 예약확인
		 </td>
		 <td align="center" bgcolor="red">
		 	<a href="CarMain.jsp?center=BoardListController.do">
		 		<img alt="" src="img/dd.jpg" border="0"></a>자유게시판
		 </td>
		 <td align="center" bgcolor="red">
		 	<a href="CarMain.jsp?center=CarEvent.jsp">
		 		<img alt="" src="img/even.jpg" border="0"></a>
		 </td>
		 <td align="center" bgcolor="red">
		 	<a href="CarAdd.jsp">
		 		<img alt="" src="img/ee.jpg" border="0"></a>
		 </td>	
	</table>
	<center> -->
	<table width="100%" border="1" bordercolor="white">
			<!-- <tr height="70">
				<td colspan="4"><a href="/triper//_car/CarMain.jsp"
					style="text-decoration: none"> <img src="img/aa.jpg"
						width="300" height="80" border="0">
				</a></td>
			</tr> -->
			<tr height="50">
			<td align="center" width="200" bgcolor="black">
				<a href="/triper/_car/CarMain.jsp?center=CarReservation.jsp&business_id=${param.business_id}" style="color:white;">예약하기</a></font>
			</td>
			<td align="center" width="200" bgcolor="black">
			<a href="../_car/CarReserveConfirmController.do?business_id=${param.business_id }" style="color:white;">예약확인</a></font>
			</td>
			<td align="center" width="200" bgcolor="black">
				<a href="/triper/_car/CarMain.jsp?center=CarAdd.jsp&business_id=${param.business_id }"style="color:white;">차량 추가</a></font>
			</td>
		</tr>
	</table>
	
</body>
</html>