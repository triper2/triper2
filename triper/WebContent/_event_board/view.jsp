<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="event.board.EboardDAO, event.board.EboardDTO" %>
<%@ page import="dbconn.util.*, dbclose.util.*, kosta.rental.loginModel.*"%>
<%@ page import="java.io.PrintWriter" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="css/bootstrap/css">
<title> 게시판 </title>
</head>
<body>
<jsp:include page="../_main_login/header.jsp"></jsp:include>

			<table class="table table-striped" style="text-align:center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="2" style="background-color:#eeeeee; text-align:center;">게시판 글보기</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width:10%;">글제목</td>
						<td>${ ebdto.getEbTitle() } </td> <!-- .replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>") -->
					</tr>
					<tr>
						<td>작성자</td>
						<td>${ ebdto.getMember_id() } </td>
					</tr>
					<tr>
						<td>작성일</td>
						<td>${ ebdto.getEbDate() }</td>
					</tr>
					<tr>
						<td>내용</td>
						<td style="min-height:200px; text-align_left;">${ ebdto.getEbContent() } </td> <!-- .replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>") -->
					</tr>
				</tbody>
			</table>
			<a href="eblist.eb" class="btn btn-primary">목록</a>
			<c:if test="${ member_id != null && member_id.equals(ebdto.getMember_id()) }">
			<a href="update.eb?ebNum=${ ebNum }" class="btn btn-primary">수정</a>
			<a onclick="return confirm('정말 삭제하시겠습니까?')" href="deleteAction.eb?ebNum=${ ebNum }" class="btn btn-primary">삭제</a>
			</c:if>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="../js/bootstrap.js"></script>
</body>
</html>