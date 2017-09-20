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
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/custom.css">
<title>Insert title here</title>
<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="../js/bootstrap.js"></script>


<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>

<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<script type="text/javascript">

$(document).ready(function(){
	commentListFunction('today');
});

function submitFunction() {
	
	var review_comment_content = $('#review_comment_content').val();
	var review_ID = ${bbs.review_ID};
	var member_ID = "${sessionScope.id}";
	$.ajax({
		type : "POST",
		url : "../commentSubmitServlet",
		data : {
			review_comment_content :  encodeURIComponent(review_comment_content),
			review_ID :  encodeURIComponent(review_ID),
			member_ID :  encodeURIComponent(member_ID)
		},
		success : function(result) {
			if (result == 1) {
				
				commentListFunction('today');
				autoClosingAlert('#successMessage', 2000);
			} else if (result == 0) {
				autoClosingAlert('#dangerMessage', 2000);
			} else {
				autoClosingAlert('#warningMessage', 2000);
			}
			
			
		}, error : function(msg, error) {
			alert(error);
		}
	});
	$('#review_comment_content').val('');
 
}
function commentListFunction(type) {
	var review_ID = ${bbs.review_ID};
	var commentPageNumber = ${commentPageNumber};
	$.ajax({
		type : "POST",
		url : "../CommentServlet",
		data : {
			review_ID :  encodeURIComponent(review_ID),
			commentPageNumber :  encodeURIComponent(commentPageNumber),
			listType : type,
			
		},
		success : function(data) {
			if(data == "") return;
			$('#commentList').html("");
			var parsed = JSON.parse(data);
			var result = parsed.result;
			for (var i = 0; i < result.length; i++) {
				addComment(result[i][0].value, result[i][1].value,
						result[i][2].value);
			}
		}
	});

}


function addComment(commentName, commentContent, commentTime) {
	$('#commentList').append(
	'<tr><td rowspan="2" colspan="1" width="20"><img class="media-object img-circle" src="../image/sugi.gif" height="100" width="100" alt=""></td>'
	+'<td colspan="2" colspan="1">'+commentName+' &nbsp;&nbsp;&nbsp;&nbsp; '+commentTime+'</td></tr>'
	+'<tr height="80"><td colspan="3">'+commentContent+'</td></tr>');

}
</script>

</head>
<body>
<jsp:include page="../_main_login/header.jsp"></jsp:include>

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
				<tr style="background-color: #eeeeee; text-align: center;">
				<td colspan="3">
				<a href="bbs.review?pageNumber=1" class="btn btn-primary">목록</a>
				<c:if test="${bbs.member_ID != null && bbs.member_ID.equals(member_ID)}">

				<a href = "update.review?review_ID=${bbs.review_ID}" class="btn btn-primary">수정</a>
				<a onclick ="return confirm('정말로 삭제하시겠습니까?')" href= "deleteAction.review?review_ID=${bbs.review_ID}" class="btn btn-primary">삭제</a>

				</c:if>
				</td>
				</tr>
				</table>
				
				
			</div>

		</div>
		
		<div class="container">
			<div class="row">
				<table class="table table-striped" style="text-align: left;">
					<thead>
						<tr>
							<th colspan="3"
								style="background-color: #eeeeee; text-align: center;">댓글</th>

						</tr>
					</thead>
					<tr>
							<td colspan="3"><textarea class="form-control"
									placeholder="댓글 달기" name="review_comment_content"
									id="review_comment_content" maxlength="500"
									style="height: 100px;"></textarea></td>
						</tr>
						<tr>
							<td colspan="3"><button type="button" class="btn btn-default pull-right"
									onclick="submitFunction();">댓글 달기</button></td>
						</tr> 
					<tbody id = commentList>

					</tbody>
					
						<tr>
							<td colspan="3">
								<c:forEach var="page" begin="1" end="${commentPageCount}" step="1">
									<a href="view.review?review_ID=${review_ID}&commentPageNumber=${page}"
					
										class="btn btn-success" onclick="commentListFunction('today');"> ${page} </a>
								</c:forEach>
							</td>
						</tr>
				</table>

			</div>
			
		</div>
		
	</center>
</body>
</html>