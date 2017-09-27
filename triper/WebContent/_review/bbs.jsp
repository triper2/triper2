<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>

<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width" ,intial-scale="1">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/custom.css">
<link rel="stylesheet" href="../css/review.css">
<title>Insert title here</title>

<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="../js/bootstrap.js"></script>



<script>
$(document).ready(function(){
    $("#writeButton").click(function(){
    	if ('${ sessionScope.dto }'==null||'${ sessionScope.dto }'==""){
    	alert('로그인을 하세요');
    	location.href='bbs.review';
    	}else{
    		location.href='write.review';
    	}
    });
});

</script>


</head>
<body>
	<jsp:include page="../_main_login/header.jsp"></jsp:include>



	<div>
		<c:set var="num" value="0" />
		<c:forEach var="list" items="${list }">
			<c:if test="${ num%3 == 0 }">
				<div class="wrap">
			</c:if>

			<a href="view.review?review_ID=${list.review_ID}">
				<div class="tile">
				<img src="${list.review_Image_1}" alt="찾을수 없음"/>
					<div class="text">
						<h1>${list.review_Title}</h1>
						<h2 class="animate-text">${list.review_ID}</h2>
						<p class="animate-text">${list.review_Date}</p>
					</div>
				</div>
			</a>

			<c:if test="${ num%3 == 2  }">
	</div>
	</c:if>
	<c:set var="num" value="${num+1 }" />
	</c:forEach>
	</div>



	<div class="form-group" style="text-align: center; ma rgin: 0 auto;">
		<c:forEach var="page" begin="1" end="${pageCount}" step="1">
			<a href="bbs.review?pageNumber=${page}"
				class="btn btn-success btn-arraw-left"> ${page} </a>
		</c:forEach>
		
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<tr>
					<form method="post" action="bbs.review">
					<td colspan="2" width="500"><input type="text"
						class="form-control" placeholder="글 제목" name="review_Title"
						maxlength="50"></td>

					<td colspan="1"><input type="submit" class="btn btn-primary" value="검색"> 
					</form>
						<a class="btn btn-primary" id="writeButton">글쓰기</a>
					</td>
				</tr>
			</table>
	</div>
</body>
</html>