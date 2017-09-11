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
<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="./css/custom.css">
<link rel="stylesheet" href="./css/review.css">
<title>Insert title here</title>
<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="./js/bootstrap.js"></script>

</head>
<body>

	<a href="write.review" class="btn btn-primary pull-right">글쓰기</a>
	<br>
	<c:set var="num" value="0" />

	<c:forEach var="list" items="${list }">
		<c:if test="${ num%3 == 0 }">

			<div class="wrap">
				<a href="view.review?review_ID=${list.review_ID}">
					<div class="tile">
						 <img src='./image/test_1.jpg' />
						<div class="text">
							<h1>${list.review_Title}</h1>
							<h2 class="animate-text">${list.review_ID}</h2>
							<p class="animate-text">${list.review_Date}</p>
						</div>
					</div>
				</a>
		</c:if>

		<c:if test="${ num%3 == 1  }">
			<a href="view.review?review_ID=${list.review_ID}">
				<div class="tile">
					<img src='./image/test_2.jpg' />
					<div class="text">
						<h1>${list.review_Title}</h1>
						<h2 class="animate-text">${list.review_ID}</h2>
						<p class="animate-text">${list.review_Date}</p>
					</div>
				</div>
			</a>
		</c:if>

		<c:if test="${ num%3 == 2  }">
			<a href="view.review?review_ID=${list.review_ID}">
				<div class="tile">

					<img src='./image/test_3.jpg' alt="asd" />
					<div class="text">
						<h1>${list.review_Title}</h1>
						<h2 class="animate-text">${list.review_ID}</h2>
						<p class="animate-text">${list.review_Date}</p>
					</div>
				</div>
			</a>
			</div>
		</c:if>
		<c:set var="num" value="${num+1 }" />

	</c:forEach>

</body>
</html>