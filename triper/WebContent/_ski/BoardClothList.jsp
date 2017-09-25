<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/skrlvkf.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:set var="j" value="0" />
		<c:forEach var="v" items="${v}">
		<c:if test="${j%3==0}">
		<div class="wrap">
		</c:if>
			<a href="BoardClothInfoController.do?product_boardclothno=${v.product_boardclothno}">
				<div class="tile">
				<img src="img/${v.product_boardclothimg}">
				<div class="text">
				의류명 : ${v.product_boardclothname }<br>
				
				대여금액 : ${v.product_boardclothprice} 원
			</div></div>
			</a>
			<c:if test="${j%3==2 }">
			</div>
			</c:if>
			<c:set var="j" value="${j+1 }"/>			
		</c:forEach>
		
</body>
</html>