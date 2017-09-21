<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<%@ page import="java.io.PrintWriter" %>
<%@ page import="event.board.*" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap/css">
<title>JSP 게시판 웹 사이트</title>
<style type="text/css">
	a, a:hover {
		color: #000000;
		text-decoration: none;
	}
</style>
</head>
<body>
<jsp:include page="../_main_login/header.jsp"></jsp:include>
	
	<%
	String member_id = null;
	if(session.getAttribute("member_id") != null) {
		member_id = (String) session.getAttribute("member_id");
	}
	int pageNumber = 1; //기본페이지
	if(request.getParameter("pageNumber") != null) {
		pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
	}
	%>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" 
			data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
			aria-expanded="false">
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
		</button>	
		<a class="navbar-brand" href="main.jsp"> JSP 게시판 웹 사이트 </a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="main.jsp"> 메인 </a></li>
				<li><a href="eblist.jsp"> 게시판 </a></li>
			</ul>
			<%
			if(member_id == null){
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
					</ul>
				</li>
			</ul>
			<%
			} else {
			%>	
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
					</ul>
				</li>
			</ul>
			<%
			}
			%>		
		</div>
	</nav>
	
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
						<td><a href="view.jsp?bbsID=<%= list.get(i).getEbNum() %>"><%=list.get(i).getEbTitle().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>")%></a></td>
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