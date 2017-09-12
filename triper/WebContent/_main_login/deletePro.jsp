<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dbconn.util.*, dbclose.util.*, kosta.rental.loginModel.*, kosta.rental.loginAction.*"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>

<fmt:requestEncoding value="utf-8"/>

<c:if test="${ check == 1 }">
<script type="text/javascript">
alert("탈퇴성공");
</script>	
</c:if>

<c:if test="${ check == 0 }">
<script type="text/javascript">
alert("비번틀림");
history.go(-1); 
</script>	
</c:if>

<meta http-equiv="Refresh"  content="0; url=mypage.do">







<!-- <body>
	<form action="index.jsp" method="post" name="userinput">
		<table width="300" border="0" align="center" cellspacing="0" cellpadding="0">
			<tr>
				<td height="39" align="center">
					<font size="1+"> <b>회원 정보가 삭제 되었습니다.</b></font>
				</td>
			</tr>
			
			<tr>
				<td align="center">
					<p>흑흑......서운하군요..잘~~~가 </p>
					<meta http-equiv="Refresh" content="5; url=index.jsp" >
				</td>
			</tr>
			
			<tr>
				<td align="center">
					<input type="submit" value="확인" >
				</td>
			</tr>
		</table>
	</form> -->