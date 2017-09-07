<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="bbs.BbsDAO"%>
<%@ page import="bbs.Bbs"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width" ,intial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>Insert title here</title>
<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="js/bootstrap.js"></script>

<style rel="stylesheet">
body {
	background-color: #eee
}

.wrap {
	margin: 50px auto 0 auto;
	width: 100%;
	display: flex;
	align-items: space-around;
	max-width: 1200px;
}

.tile {
	width: 380px;
	height: 380px;
	margin: 10px;
	background-color: #99aeff;
	display: inline-block;
	background-size: cover;
	position: relative;
	cursor: pointer;
	transition: all 0.4s ease-out;
	box-shadow: 0px 35px 77px -17px rgba(0, 0, 0, 0.44);
	overflow: hidden;
	color: white;
	font-family: 'Roboto';
}

.tile img {
	height: 100%;
	width: 100%;
	position: absolute;
	top: 0;
	left: 0;
	z-index: 0;
	transition: all 0.4s ease-out;
}

.tile .text {
	/*   z-index:99; */
	position: absolute;
	padding: 30px;
	height: calc(100% - 60px);
	height: calc(100% - 60px);
}

.tile h1 {
	font-weight: 300;
	margin: 0;
	text-shadow: 2px 2px 10px rgba(0, 0, 0, 0.3);
}

.tile h2 {
	font-weight: 100;
	margin: 20px 0 0 0;
	font-style: italic;
	transform: translateX(200px);
}

.tile p {
	font-weight: 300;
	margin: 20px 0 0 0;
	line-height: 25px;
	/*   opacity:0; */
	transform: translateX(-200px);
	transition-delay: 0.2s;
}

.animate-text {
	opacity: 0;
	transition: all 0.6s ease-in-out;
}

.tile:hover {
	/*   background-color:#99aeff; */
	box-shadow: 0px 35px 77px -17px rgba(0, 0, 0, 0.64);
	transform: scale(1.05);
}

.tile:hover img {
	opacity: 0.2;
}

.tile:hover .animate-text {
	transform: translateX(0);
	opacity: 1;
}

.dots {
	position: absolute;
	bottom: 20px;
	right: 30px;
	margin: 0 auto;
	width: 30px;
	height: 30px;
	color: currentColor;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: space-around;
}

.dots span {
	width: 5px;
	height: 5px;
	background-color: currentColor;
	border-radius: 50%;
	display: block;
	opacity: 0;
	transition: transform 0.4s ease-out, opacity 0.5s ease;
	transform: translateY(30px);
}

.tile:hover span {
	opacity: 1;
	transform: translateY(0px);
}

.dots span:nth-child(1) {
	transition-delay: 0.05s;
}

.dots span:nth-child(2) {
	transition-delay: 0.1s;
}

.dots span:nth-child(3) {
	transition-delay: 0.15s;
}

@media ( max-width : 1000px) {
	.wrap {
		flex-direction: column;
		width: 400px;
	}
}
</style>

</head>
<body>
	<%
		String userID = "123";
		if (session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
		}
		int pageNumber = 1;
		if (request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}
	%>
	
	<a href="write.jsp" class="btn btn-primary pull-right">글쓰기</a>

	<%
		BbsDAO bbsDAO = new BbsDAO();
		ArrayList<Bbs> list = bbsDAO.getList(pageNumber);
		for (int i = 0; i < list.size(); i++) {
			if (i % 3 == 0) {
	%>

	<div class="wrap">
		<div class="tile">
			<img src='http://www.blueb.co.kr/SRC2/_image/s_01.jpg' />
			<div class="text">
				<h2 class="animate-text"><%=list.get(i).getBbsID()%></h2>
				<p class="animate-text"><%=list.get(i).getBbsDate()%></p>
			</div>
		</div>
	<%
		} else if (i % 3 == 1) {
	%>
	<div class="tile">
		<img src='http://www.blueb.co.kr/SRC2/_image/s_01.jpg' />
		<div class="text">
			<h2 class="animate-text"><%=list.get(i).getBbsID()%></h2>
			<p class="animate-text"><%=list.get(i).getBbsDate()%></p>
	</div>
	</div>
	<%
		} else {
	%>
	<div class="tile">
		<img src='http://www.blueb.co.kr/SRC2/_image/s_01.jpg' />
		<div class="text">
			<h2 class="animate-text"><%=list.get(i).getBbsID()%></h2>
			<p class="animate-text"><%=list.get(i).getBbsDate()%></p>
	</div>
	</div>
	</div>
	<%
			}
		}
	%>

</body>
</html>