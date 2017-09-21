<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="user.User" scope="page"/>
<jsp:setProperty property="user_id" name="user"/>
<jsp:setProperty property="user_pwd" name="user"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> JSP 게시판 웹 사이트 </title>
</head>
<body>

	<%
	String user_id = null;
	if(session.getAttribute("user_id") != null){
		user_id = (String)session.getAttribute("user_id");
	}
	if(user_id != null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alret('이미 로그인 되어있습니다.')");
		script.println("location.href='main.jsp'");
		script.println("</script>");
	}
	UserDAO userdao = new UserDAO();
	int result = userdao.login(user.getUser_id(), user.getUser_pwd());
	if(result == 1) {
		session.setAttribute("user_id", user.getUser_id());
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("location.href='main.jsp'");
		script.println("</script>");
	} 
	else if(result == 0) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alret('비번 틀림!')");
		script.println("history.back()");
		script.println("</script>");
	}
	else if(result == -1) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alret('아이디 없음!')");
		script.println("history.back()");
		script.println("</script>");
	}
	else if(result == -2) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alret('DB 오류!')");
		script.println("history.back()");
		script.println("</script>");
	}
	%> 
	
</body>
</html>