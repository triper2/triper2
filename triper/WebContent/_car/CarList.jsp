<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<center>


	<img alt="" src="img/cis.jpg" border="0">
	<!-- 카테고리 분류 검색을 위하여 form데이터 처리 -->
	<form action="CarcategoryController.do" method="post">
	<table width="1000" border="0" height="470">
	<c:set var="j" value="0" />
		<c:forEach var="v" items="${v}">
		<c:if test="${j%4==0}">
		<tr align="center">
		</c:if>
			<td><a href="CarInfoController.do?product_carno=${v.product_carno}">
				<img src="./_car/img/${v.product_carimg}" border="0" width="220" height="180"></a><p>
				차량명 : ${v.product_carname }<br>
				
				대여금액 : ${v.product_carprice}
			</td>	
			
			<c:set var="j" value="${j+1 }"/>			
		</c:forEach>
		<tr height="70">
			<td colspan="4" align="center">
			차량 검색 : <select name="carcategory">
				   <option value="Small"> 소형 </option>	
				   <option value="Mid"> 중형 </option>	
				   <option value="Big"> 대형 </option>			
			</select>&nbsp;&nbsp;&nbsp;
			<input type="submit" value="차량검색">&nbsp;&nbsp;&nbsp;
			
					<input type="button" value="전체검색" onclick="location.href='CarListController.do'">
			</td>
		</tr>
	</table>	
	</form>
</center>

</body>
</html>

