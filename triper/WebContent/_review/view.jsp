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


<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.0.min.js"></script>

<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


<style type="text/css">
#layer_fixed {
	height: 75%;
	width: 17%;
	font-size: 15px;
	position: fixed;
	z-index: 999;
	top: 15%;
	right: 5px;
	-webkit-box-shadow: 0 1px 2px 0 #777;
	box-shadow: 0 1px 2px 0 #777;
	background-color: #dddddd;
	border-radius: 10px;
}
</style>

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
						result[i][2].value,result[i][3].value,result[i][4].value);
			}
		}
	});

}

function deletecommentFunction(type) {
	var review_comment_id = type;
	 $.ajax({
		type : "POST",
		url : "../CommentDeleteServlet",
		data : {
			review_comment_id :  encodeURIComponent(review_comment_id)
			
		},
		success : function(data) {
			commentListFunction('today');
		}
	}); 
}


function addComment(commentName, commentContent,commentImage,commentID, commentTime) {
	var str = '<c:set var="commentName" value="'+commentName+'"/>'
			+'<tr><td rowspan="2" colspan="1" width="20"><img class="media-object img-circle" src="../_main_login/mem_img/'+commentImage+'" height="100" width="100" alt=""></td>'
			+'<td colspan="3">'+commentName+' &nbsp;&nbsp;&nbsp;&nbsp; '+commentTime;
			
			if("${sessionScope.dto.member_id}" == commentName) {
				str += '<a class="btn btn-default pull-right" onclick="deletecommentFunction('+commentID+');">삭제</a>';
			}
			str += '</td></tr><tr height="80"><td colspan="3">'+commentContent+'</td></tr>'
	$('#commentList').append(str);
}
</script>


</head>
<body>
	<jsp:include page="../_main_login/header.jsp"></jsp:include>

		<table class="table table"
			style="border: 1px solid #dddddd; background-color: white; text-align: left;">

				<tr>
					<th colspan="3" style="background-color: white; text-align: left;">
						<span style="font-size: 50px;"> ${bbs.review_Title} </span><br>
						${bbs.review_Date}
						
					</th>
				</tr>
				<tr><td colspan="2" style="height: 500px;">${bbs.review_Content}</td>
					<td colspan="1" width=16% style="background-color: #dddddd;">
						<center>
							<img class="media-object img-circle"
								src="../_main_login/mem_img/${bbs.member_image}" height="150"
								width="150" alt=""> ${bbs.member_ID}
						</center>
						<hr>
						<form method="get" action="LikeHateCommand.review">
						<button type="submit" class="btn btn-primary "
							aria-label="right Align">
							<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>좋아요!
							<input type="hidden" name="like" value="1">
							<input type="hidden" name="review_ID" value="${bbs.review_ID}">
						</button>
						</form>
						<hr>
						<form method="get" action="LikeHateCommand.review">
						<button type="submit" class="btn btn-primary"
							aria-label="right Align">
							<span class="glyphicon glyphicon-thumbs-down" aria-hidden="true"></span>나빠요!
							<input type="hidden" name="hate" value="-1">
							<input type="hidden" name="review_ID" value="${bbs.review_ID}">
						</button>
						</form>
						<hr> <span class="glyphicon glyphicon-thumbs-up pull-left"aria-hidden="true"> 좋아요:</span>${bbs.review_Like}<br> 
						<span class="glyphicon glyphicon-thumbs-down pull-left" aria-hidden="true"> 나빠요:</span>${bbs.review_Hate}<br> 
						<span class="glyphicon glyphicon-eye-open pull-left" aria-hidden="true"> 조회수:</span>${bbs.review_Viewcount}<br> 
						<span class="glyphicon glyphicon-user pull-left" aria-hidden="true"> 댓 글:</span>${commentCount}
					</td>
				</tr>
				
					

			<tr style=" text-align: center;">
				<td colspan="3"><a href="bbs.review?pageNumber=1"
					class="btn btn-primary">목록</a> 
					<c:if test="${bbs.member_ID != null && bbs.member_ID.equals(member_ID)}">
						<a href="update.review?review_ID=${bbs.review_ID}"
							class="btn btn-primary">수정</a>
						<a onclick="return confirm('정말로 삭제하시겠습니까?')"
							href="deleteAction.review?review_ID=${bbs.review_ID}"
							class="btn btn-primary">삭제</a>

					</c:if></td>
			</tr>


			<tr>
				<td colspan="3"><textarea class="form-control"
						placeholder="댓글 달기" name="review_comment_content"
						id="review_comment_content" maxlength="500" style="height: 100px;"></textarea></td>
			</tr>
			<tr>
				<td colspan="3" style="background-color: #dddddd;"><button
						type="button" class="btn btn-primary pull-right"
						onclick="submitFunction();">댓글 달기</button></td>
			</tr>
			<tbody id=commentList>

			</tbody>

			<tr>
				<td colspan="3"><c:forEach var="page" begin="1"
						end="${commentPageCount}" step="1">
						<a
							href="view.review?review_ID=${review_ID}&commentPageNumber=${page}"
							class="btn btn-success" onclick="commentListFunction('today');">
							${page} </a>
					</c:forEach></td>
			</tr>
		</table>
		<%-- <div id="layer_fixed">
			<table class="table table"
				style="text-align: center; color: #D5D5D5;">
				<tr style="text-align: center; color: #D5D5D5;">
					<td>
						<center>
							<img class="media-object img-circle"
								src="../_main_login/mem_img/${bbs.member_image}" height="150"
								width="150" alt="">
						</center> ${bbs.member_ID}
						<hr>
						<form method="get" action="LikeHateCommand.review">
						<button type="submit" class="btn btn-primary "
							aria-label="right Align">
							<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>좋아요!
							<input type="hidden" name="like" value="1">
							<input type="hidden" name="review_ID" value="${bbs.review_ID}">
						</button>
						</form>
						<hr>
						<form method="get" action="LikeHateCommand.review">
						<button type="submit" class="btn btn-primary"
							aria-label="right Align">
							<span class="glyphicon glyphicon-thumbs-down" aria-hidden="true"></span>나빠요!
							<input type="hidden" name="hate" value="-1">
							<input type="hidden" name="review_ID" value="${bbs.review_ID}">
						
						</button>
						</form>
						<hr> <span class="glyphicon glyphicon-thumbs-up pull-left"
						aria-hidden="true"> 좋아요:</span> <br> <span
						class="glyphicon glyphicon-thumbs-down pull-left"
						aria-hidden="true"> 나빠요:</span> <br> <span
						class="glyphicon glyphicon-eye-open pull-left" aria-hidden="true">
							조회수:</span> <br> <span class="glyphicon glyphicon-user pull-left"
						aria-hidden="true"> 댓 글:</span>
					</td>
				</tr>
			</table>


		</div> --%>


</body>
</html>