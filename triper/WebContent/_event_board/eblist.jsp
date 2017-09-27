<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="event.board.EboardDAO, event.board.EboardDTO" %>
<%@ page import="dbconn.util.*, dbclose.util.*, kosta.rental.loginModel.*"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.ArrayList" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap/css">
<title> Triper </title>
<style type="text/css">
	a, a:hover {
		color: #000000;
		text-decoration: none;
	}
</style>
</head>
<body>
<jsp:include page="../_main_login/header.jsp"></jsp:include>
	
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
					<c:forEach var="list" items="${list }">
					<tr>
						<td>${ list.ebNum }</td>
						<td><a href="view.eb?ebNum=${ list.ebNum }">${ list.ebTitle }</a></td>
						<td>${ list.member_id }</td>
						<td>${ list.ebDate }</td>
					</tr>
					</c:forEach>					
					</tbody>
			</table>
			<c:if test="${ pageNumber != 1 }">
			<a href="eblist.eb?pageNumber=${ pageNumber-1 }" class="btn btn-success btn-arraw-left">이전</a>
			</c:if>
			<c:if test="${ ebdao.nextPage(pageNumber+1) }">
			<a href="eblist.eb?pageNumber=${ pageNumber+1 }" class="btn btn-success btn-arraw-left">다음</a>
			</c:if>
			<a href="write.eb" class="btn btn-primary pull-right">글쓰기</a>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="../js/bootstrap.js"></script>
</body>
</html>