<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="event.board.*" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> JSP 게시판 웹 사이트 </title>
${ sessionScope.dto }
<c:set var="dto" value="${ sessionScope.dto }"/>
</head>
<body>

	<%
	String member_id = null;
	if(session.getAttribute("member_id") != null){
		member_id = (String) session.getAttribute("member_id");
	}
	if(member_id == null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인 하세요.')");
		script.println("location.href='../_main_login/loginForm.jsp'");
		script.println("</script>");
	}
	int ebNum = 0;
	if(request.getParameter("ebNum") != null) {
		ebNum = Integer.parseInt(request.getParameter("ebNum"));
	}
	if (ebNum == 0) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('유효하지 않은 글입니다.')");
			script.println("location.href='eblist.jsp'");
			script.println("</script>");
	}
	EboardDTO ebdto = new EboardDAO().getEboardDTO(ebNum);
	if(!member_id.equals(ebdto.getMember_id())) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('권한이 없습니다.')");
		script.println("location.href='eblist.jsp'");
		script.println("</script>");
	} else {
		EboardDAO ebdao = new EboardDAO();
			int result = ebdao.delete(ebNum);
			if(result == -1) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('글 삭제 실패')");
				script.println("history.back()");
				script.println("</script>");
			} 
			else {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href='eblist.jsp'");
				script.println("</script>");
			}
		}
	%> 
	
</body>
</html>