<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="event.board.*" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="ebdto" class="event.board.EboardDTO" scope="page"/>
<jsp:setProperty property="bbsTitle" name="ebdto"/>
<jsp:setProperty property="bbsContent" name="ebdto"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> JSP 게시판 웹 사이트 </title>
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
		script.println("location.href='login.jsp'");
		script.println("</script>");
	} else {
		if (ebdto.getEbTitle() == null || ebdto.getEbContent() == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('입력 안 된 사항이 있습니다.')");
			script.println("history.back()");
			script.println("</script>");
			} else {
				EboardDAO ebdao = new EboardDAO();
				int result = ebdao.write(ebdto.getEbTitle(), member_id, ebdto.getEbContent());
				if(result == -1) {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('글쓰기 실패')");
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
	}
	%> 
	
</body>
</html>