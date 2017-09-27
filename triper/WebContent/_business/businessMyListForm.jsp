<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
<jsp:include page="../_command/loginChecker.jsp?page=businessMyList"></jsp:include>
<jsp:include page="../_main_login/header.jsp"></jsp:include>
<table class="table table-striped"style="text-align: left; border: 3px solid #dddddd">
	<tr>
		<th>상호명</th>
		<th>사업자번호</th>
		<th>사업장 소재지</th>
		<th>사업장 전화번호</th>
		<th>카테고리</th>
		<th>승인 여부</th>
	</tr>
	<c:forEach var="list1" items="${list}">
		<tr>
			<th>${list1.business_name }</th>
			<th>${list1.business_id }</th>
			<c:if test="${list1.business_road_address!=null}">
				<td>${list1.business_road_address}</td>
			</c:if>
			<c:if test="${list1.business_road_address==null}">
				<td>${list1.business_address}</td>
			</c:if>
			<th>${list1.business_tel }</th>
			<th>${list1.business_category }</th>
			<th>${list1.business_assent }</th>
		</tr>
	</c:forEach>
</table>
</body>
</html>