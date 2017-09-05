<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dbconn.util.*, dbclose.util.*, kosta.rental.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 회원 탈퇴 처리 </title>
</head>
<%
	String id = (String)session.getAttribute("memID");
	String pwd = request.getParameter("password");
	
	RentalDAO dao = RentalDAO.getInstance();
	int check = dao.delete(id, pwd);
	
	if( check == 1 ) {
		session.invalidate();
%>
<body>
	<form action="index.html" method="post" name="userinput">
		<table width="300" border="0" align="center" cellspacing="0" cellpadding="0">
			<tr>
				<td height="39" align="center">
					<font size="1+"> <b>회원 정보가 삭제 되었습니다.</b></font>
				</td>
			</tr>
			
			<tr>
				<td align="center">
					<p>흑흑......서운하군요..잘~~~가 </p>
					<meta http-equiv="Refresh" content="5; url=index.html" >
				</td>
			</tr>
			
			<tr>
				<td align="center">
					<input type="submit" value="확인" >
				</td>
			</tr>
		</table>
	</form>

<%	} else { %>

<script type="text/javascript">
	alert("비밀번호가 맞지 않습니다.");
	history.go(-1);
</script>
<%	}// if end  %>

</body>
</html>