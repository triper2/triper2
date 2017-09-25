<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
<c:if test="${sessionScope.dto==null}">
	<script type="text/javascript">
		alert("로그인을 해야 이용가능한 페이지 입니다.");
		location.href = "../_main_login/loginForm.jsp?page=${param.page}";
	</script>
</c:if>
</html>