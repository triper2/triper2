<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dbconn.util.*, dbclose.util.*, kosta.rental.loginModel.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.net.*  , java.util.*  ,  java.io.*" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>

    <jsp:useBean id="dto" class="kosta.rental.loginModel.RentalDTO" />
	<jsp:setProperty property="*" name="dto"  />
	<% 
		request.setCharacterEncoding("UTF-8");
		Connection conn = RentalDAO.loadOracleDriver();
		RentalDAO.insert(conn, dto);
		response.sendRedirect("login.jsp");			
	%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> insert </title>  
</head>
<body>

</body>
</html>