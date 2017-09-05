<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dbconn.util.*, dbclose.util.*, kosta.rental.*"%>
<%@ page import="java.sql.*"%>
<% 
	request.setCharacterEncoding("UTF-8");
    
    String id = request.getParameter("id");
    String pwd = request.getParameter("password");
    
    RentalDAO dao = RentalDAO.getInstance();
    int check = dao.userCheck(id, pwd);
    
    if(check==1){
    	session.setAttribute("memID", id);
    	response.sendRedirect("index.jsp");
    } else if (check==0){
%>
<script type="text/javascript">
<!--
alert("비밀번호 틀림");
history.go(-1); 
//-->
</script>	
<%    } else {	%>
<script type="text/javascript">
<!--
alert("아이디가 없음");
history.go(-1); 
//-->
</script>	
<%	  }    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> loginPro.jsp </title>
</head>
<body>

</body>
</html>