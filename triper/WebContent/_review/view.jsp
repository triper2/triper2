<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="review.bbs.BbsVO"%>
<%@ page import="review.bbs.BbsDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width" ,intial-scale="1">
<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="./css/custom.css">
<title>Insert title here</title>
<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="./js/bootstrap.js"></script>


<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>

<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</head>
<body>

	<center>
		<div class="container">
			<div class="row">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
						
							<th colspan="3"style="background-color: #eeeeee; text-align: center;">게시판 글보기</th>
						
						</tr>
					</thead>
					<tbody>
						<tr>
							<td style="width: 20%;">글 제목</td>
							<td colspan="2">${bbs.review_Title}</td>
						</tr>
						<tr>
							<td>작성자</td>
							<td colspan="2">${bbs.member_ID}</td>
						</tr>
						<tr>
							<td>작성일자</td>
							<td colspan="2">${bbs.review_Date}</td>
						</tr>
						<tr>
							<td>내용</td>
							<td colspan="2" style="height:350px; text-align: left;">${bbs.review_Content}</td>
						</tr>

					</tbody>

				</table>
				
				
				<a href="bbs.review" class="btn btn-primary">목록</a>
				<c:if test="${bbs.member_ID != null && bbs.member_ID.equals(bbs.getMember_ID())}">

				<a href = "update.review?review_ID=${bbs.review_ID}" class="btn btn-primary">수정</a>
				<a onclick ="return confirm('정말로 삭제하시겠습니까?')" href= "deleteAction.review?review_ID=${bbs.review_ID}" class="btn btn-primary">삭제</a>

				</c:if>
				
			</div>

		</div>
	</center>
</body>
</html>
