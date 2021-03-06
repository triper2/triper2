<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" autoFlush="true" buffer="500kb" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<bady style="background-color:white;">
<jsp:include page="../_main_login/header.jsp"></jsp:include>
	<!-- center는 사용자로부터 계속해서 정보가 바뀌는 부분 이기에 해당 Center의 정보를 받아줌 -->
	<c:set var="center" value="${param.center}"/>
	<!-- 처음 웹 페이지를 실행하면 param.값을 받아올수 없기에 -->
	<c:if test="${center == null}">
	<c:set var="center" value="Center.jsp" />
	</c:if>
	
	<c:set var="top" value="${param.top}"/>
	<c:if test="${param.top == null}">
	<c:set var="top" value="Top.jsp" />
	</c:if>
	<center>
		<table width="1000" height="700">
		
		<tr align="center" >
			<td> <jsp:include page="${top}"/></td> 	
		</tr>
		<tr >
			<td height="500"> <jsp:include page="${center}"/></td> 	
		</tr>
		<tr >
			<td> <jsp:include page="Bottom.jsp"/></td> 	
		</tr>		
		</table>
	</center>
</body>
</html>