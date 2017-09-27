<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<bady>
	<!-- 카테고리 분류 검색을 위하여 form데이터 처리 -->
	<form
		action="../_car/CarcategoryController.do?business_id=${param.business_id}"
		method="post">

		<c:set var="j" value="0" />
		<c:forEach var="v" items="${v}">
			<c:if test="${j%3==0}">
				<div class="wrap">
			</c:if>
			<a href="CarInfoController.do?product_carno=${v.product_carno}&business_id=${param.business_id}">
				<div class="tile">
					<img src="img/${v.product_skiimg}">
					<div class="text">
						차량명 : ${v.product_carname }<br> 대여금액 : ${v.product_carprice}
					</div>
				</div>
			</a>
			<c:if test="${j%3==2 }">
				</div>
			</c:if>
			<c:set var="j" value="${j+1 }" />
		</c:forEach>

		<table width="1000" border="0" height="470">
			<tr height="70">
				<td colspan="4" align="center">차량 검색 : </td>
				<td>
				<div class="col-xs-9"><select name="carcategory" class="form-control">
						<option value="Small">소형</option>
						<option value="Mid">중형</option>
						<option value="Big">대형</option>
				</select></div>
					<input type="submit" class="btn btn-primary" value="차량검색">&nbsp;&nbsp;&nbsp;

					<input type="button" class="btn btn-primary" value="전체검색"
					onclick="location.href='../_car/CarListController.do?business_id=${param.business_id}'">
				</td>
			</tr>
		</table>


	</form>

</body>
</html>

