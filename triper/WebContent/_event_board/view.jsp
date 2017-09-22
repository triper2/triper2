<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<%@ page import="event.board.*" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap/css">
<title>JSP 게시판 웹 사이트</title>
${ sessionScope.dto }
<c:set var="dto" value="${ sessionScope.dto }"/>
</head>
<body>
<jsp:include page="../_main_login/header.jsp"></jsp:include>
	
	<%
	String member_id = null;
	if(session.getAttribute("member_id") != null) {
		member_id = (String) session.getAttribute("member_id");
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
	%>
	
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align:center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3" style="background-color:#eeeeee; text-align:center;">게시판 글보기</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width:20%;">글제목</td>
						<td colspan="2"><%= ebdto.getEbTitle().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>") %></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td colspan="2"><%= ebdto.getMember_id() %></td>
					</tr>
					<tr>
						<td>작성일자</td>
						<td colspan="2"><%= ebdto.getEbDate().substring(0, 11)+ebdto.getEbDate().substring(11, 13)+"시"+ ebdto.getEbDate().substring(14, 16)+"분" %></td>
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="2" style="min-height:200px; text-align_left;"><%= ebdto.getEbContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>") %></td>
					</tr>
				</tbody>
			</table>
			<a href="eblist.jsp" class="btn btn-primary">목록</a>
			<%
			if(member_id != null && member_id.equals(ebdto.getMember_id())) {
			%>
			<a href="update.jsp?ebNum=<%= ebNum %>" class="btn btn-primary">수정</a>
			<a onclick="return confirm('정말 삭제하시겠습니까?')" href="deleteAction.jsp?ebNum=<%= ebNum %>" class="btn btn-primary">삭제</a>
			<%
			}
			%>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="../js/bootstrap.js"></script>
</body>
</html>