<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<center>
	<img alt="" src="img/cis.jpg" border="0">
	<form action="_car/CarMain.jsp?center=CarOption.jsp" method="post">
	<table width="1000" border="0" align="center">
	<tr align="center">
		<td rowspan="6" width="600">
		<img alt="" src="img/${bean.product_carimg }" width="450" border="0">
		</td>
		<td align="center" width="200"> 차량이름  </td>
		<td align="center" width="200"> ${bean.product_carname } </td> 
	</tr>
	<tr>
		<td align="center" width="200"> 대여수량  </td>
		<td align="center" width="200"> <select name="carqty">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>	
									</select> </td> 
	</tr>
	<tr>
		<td align="center" width="200"> 차량분류  </td>
		<td align="center" width="200"> 
		<c:if test="${ bean.product_carcategory=='Small'}">
		소 형
		</c:if> 
		<c:if test="${ bean.product_carcategory=='Mid'}">
		중 형
		</c:if> 
		<c:if test="${ bean.product_carcategory=='Big'}">
		대 형
		</c:if> 
	</td> 
	</tr>
	<tr>
		<td align="center" width="200"> 대여금액  </td>
		<td align="center"  width="200"> ${bean.product_carprice } </td> 
	</tr>
	<tr>
		<td align="center" width="200"> 제조회사  </td>
		<td align="center" width="200"> ${bean.product_carcompany } </td> 
	</tr>
	<tr>
		<td align="center" width="200"> 
		<input type="hidden" name="carno" value="${bean.product_carno }">
		<input type="hidden" name="carimg" value="${bean.product_carimg }">
		<input type="hidden" name="carprice" value="${bean.product_carprice }">
		<input type="button" value="이전" onclick="location.href='./CarListController.do'">
		</td>
		<td align="center" width="200"> 
			<input type="submit" value="옵션 선택하기">
		 </td> 
	</tr>
	</table>
	</form>	
	<p>
	<b>차량 정보 상세 보기</b><p>
	${bean.product_carinfo }
	</center>

</body>
</html>