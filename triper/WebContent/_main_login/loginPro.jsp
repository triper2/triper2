<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dbconn.util.*, dbclose.util.*, kosta.rental.loginModel.*"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>

<fmt:requestEncoding value="utf-8"/>

<c:if test="${ check == 0 }">
<script type="text/javascript">
alert("비밀번호 틀림");
history.go(-1); 
</script>	
</c:if>

<c:if test="${ check == -1 }">
<script type="text/javascript">
alert("아이디가 없음");
history.go(-1); 
</script>	
</c:if>

<meta http-equiv="Refresh"  content="0; url=loginForm.do ">
