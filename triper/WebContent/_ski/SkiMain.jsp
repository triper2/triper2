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

	<!-- center는 사용자로부터 계속해서 정보가 바뀌는 부분 이기에 해당 Center의 정보를 받아줌 -->
	<c:set var="center" value="${param.center}"/>
	<!-- 처음 웹 페이지를 실행하면 param.값을 받아올수 없기에 -->
	<c:if test="${center == null}">
	<c:set var="center" value="Center.jsp" />
	</c:if>
	
	
	<c:set var="top" value="${param.top}"/>
	<c:if test="${param.top == null}">
	<c:set var="top" value="Skimain2.jsp" />
	</c:if>
	<center>
		<table width="100%">
		<tr align="center">
			<td> <jsp:include page="${top}"/></td> 	
		</tr>
		<tr >
			<td height="500"> <jsp:include page="${center}"/></td> 	
		</tr>
				
		</table>
	</center>
</body>
</html>