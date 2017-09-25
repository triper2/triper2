<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<%@ page import="event.board.EboardDAO, event.board.EboardDTO" %>
<%@ page import="dbconn.util.*, dbclose.util.*, kosta.rental.loginModel.*"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.ArrayList" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap/css">
<title>JSP 게시판 웹 사이트</title>
<style type="text/css">
	a, a:hover {
		color: #000000;
		text-decoration: none;
	}
</style>
${ sessionScope.dto }
<c:set var="dto" value="${ sessionScope.dto }"/>
</head>
<body>
<jsp:include page="../_main_login/header.jsp"></jsp:include>
	
	<%
	String member_id=null;
	//RentalDTO dto = (RentalDTO)request.getSession().getAttribute("dto");
	//String member_id = dto.getMember_id();
	try {
		RentalDTO dto = (RentalDTO)request.getSession().getAttribute("dto");
		member_id = dto.getMember_id();
	} catch (Exception e) {
		member_id = null;
	}
	int pageNumber = 1; //기본페이지
	if(request.getParameter("pageNumber") != null) {
		pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
	}
	%>
	
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align:center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color:#eeeeee; text-align:center;">번호</th>
						<th style="background-color:#eeeeee; text-align:center;">제목</th>
						<th style="background-color:#eeeeee; text-align:center;">작성자</th>
						<th style="background-color:#eeeeee; text-align:center;">작성일</th>
					</tr>
				</thead>
					<tbody>
					<%
						EboardDAO ebdao = new EboardDAO();
						ArrayList<EboardDTO> list = ebdao.getList(pageNumber);
						for(int i=0; i<list.size(); i++) {
					%>	
					<tr>
						<td><%= list.get(i).getEbNum()%></td>
						<td><a href="view.jsp?ebNum=<%= list.get(i).getEbNum() %>"><%=list.get(i).getEbTitle()%></a></td>
						<td><%= list.get(i).getMember_id() %></td>
						<td><%= list.get(i).getEbDate().substring(0, 11) + list.get(i).getEbDate().substring(11, 13) + "시" + list.get(i).getEbDate().substring(14, 16)+"분" %> </td>
					</tr>
					<%	
						}
					%>						
					</tbody>
			</table>
			<%
				if(pageNumber != 1) {
			%>
			<a href="eblist.jsp?pageNumber=<%=pageNumber-1 %>" class="btn btn-success btn-arraw-left">이전</a>
			<%
				} if(ebdao.nextPage(pageNumber+1)) {
			%>
			<a href="eblist.jsp?pageNumber=<%=pageNumber+1 %>" class="btn btn-success btn-arraw-left">다음</a>
			<%
				}
			%>
			<a href="write.jsp" class="btn btn-primary pull-right">글쓰기</a>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="../js/bootstrap.js"></script>
</body>
</html>