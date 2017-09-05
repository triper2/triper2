<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dbconn.util.*, dbclose.util.*, kosta.rental.*"%>
<%@page import="java.sql.*"%>
    <jsp:useBean id="dto" class="kosta.rental.RentalDTO" />
	<jsp:setProperty property="*" name="dto"  />
	<% 
		request.setCharacterEncoding("UTF-8");
		String id = (String)session.getAttribute("memID");
		dto.setMember_id(id);
		Connection conn = RentalDAO.loadOracleDriver();
		RentalDAO dao = RentalDAO.getInstance();
		dao.modify(dto);
	%>

<style type="text/javascript">
<!--
alert("수정완료! 3초 후 로그인 페이지로 갑니다.");

-->
</style>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> modifyPro.jsp </title>
</head>
<body>
<meta http-equiv="Refresh" content="3; url=login.jsp">
</body>
</html>