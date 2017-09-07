<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dbconn.util.*, dbclose.util.*, kosta.rental.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style type="text/css">
video {
	position: absolute;
	top: 0px;
	left: 0px;
	width: 100%;
	height: 700px;
	z-index: -1;
	overflow: hidden;
}
</style>

<title>Rental Shop</title>

<!-- Bootstrap Core CSS -->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
<!-- Custom CSS -->
<link href="../css/stylish-portfolio.css" rel="stylesheet">
</head>

<body>
	<!-- Navigation -->
	<a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i class="fa fa-bars"></i></a>
	<nav id="sidebar-wrapper">
		<ul class="sidebar-nav">
			<a id="menu-close" href="#"
				class="btn btn-light btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
			<li class="sidebar-brand"><a href="./login.jsp" onclick=$("#menu-close").click();>Login</a></li>
			<li><a href="./mypage.jsp" onclick=$("#menu-close").click();>My Page</a></li>
			<li><a href="#portfolio" onclick=$("#menu-close").click();>리뷰</a></li>
			<li><a href="#contact" onclick=$("#menu-close").click();>예약(지도)</a></li>
			<li><a href="#services" onclick=$("#menu-close").click();>고객센터</a></li>
			<li><a href="#introduce" onclick=$("#menu-close").click();>회사소개</a></li>
		</ul>
	</nav>

	<!-- Header -->
	<video id="video" preload="auto" autoplay="true" loop="loop"
		muted="muted" volume="0">
		<source src="../img/Triper.mp4">
	</video>		
	
	<header class="header" id="top">
		<div class="text-vertical-center">
			<!-- <h1>Rental Shop</h1>
			<h3>Ski &amp; Snow board</h3> -->
			<br> <a href="#about" class="page-scroll btn btn-dark btn-lg">아래로고고</a>
		</div>
	</header>
<br>
	<!-- About -->
	<!-- <section id="about" class="about">
		<div class="container text-center">
			<h2>Rental Shop</h2>
			<p class="lead">Ski &amp; Snow board</p>
		</div>
		/.container
	</section> -->

	
<!-- 리뷰 채팅+썸네일 -->
<br/><br/>
	<section id="portfolio" class="portfolio">
		<div class="container">
			<div class="row">
				<div class="col-lg-10 mx-auto text-center">
					<h2>리뷰 채팅+썸네일</h2>
					<hr class="small">
					<div class="row">
						<div class="col-md-6">
							<div class="portfolio-item">
								<a href="#top"> <img class="img-portfolio img-fluid"
									src="../img/portfolio-1.jpg">
								</a>
							</div>
						</div>
						<div class="col-md-6">
							<div class="portfolio-item">
								<a href="#"> <img class="img-portfolio img-fluid"
									src="../img/portfolio-2.jpg">
								</a>
							</div>
						</div>
						<div class="col-md-6">
							<div class="portfolio-item">
								<a href="#"> <img class="img-portfolio img-fluid"
									src="../img/portfolio-3.jpg">
								</a>
							</div>
						</div>
						<div class="col-md-6">
							<div class="portfolio-item">
								<a href="#"> <img class="img-portfolio img-fluid"
									src="../img/portfolio-4.jpg">
								</a>
							</div>
						</div>
					</div>
					<!-- /.row (nested) -->
					<a href="#" class="btn btn-dark">View More Items</a>
				</div>
				<!-- /.col-lg-10 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container -->
	</section>


<!-- 예약(지도) -->
<br/><br/>
	<section id="contact" class="map">
		<iframe width="100%" height="100%" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"
			src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;aq=0&amp;oq=twitter&amp;sll=28.659344,-81.187888&amp;sspn=0.128789,0.264187&amp;ie=UTF8&amp;hq=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;t=m&amp;z=15&amp;iwloc=A&amp;output=embed"></iframe>
		<br /> <small> <a href="https://maps.google.com/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;aq=0&amp;oq=twitter&amp;sll=28.659344,-81.187888&amp;sspn=0.128789,0.264187&amp;ie=UTF8&amp;hq=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;t=m&amp;z=15&amp;iwloc=A"></a>
		</small>
	</section>
	
<!-- 고객센터 -->
<br/><br/>
	<!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
	<section id="services" class="services bg-primary text-white">
		<div class="container">
			<div class="row text-center">
				<div class="col-lg-10 mx-auto">
					<h2>고객센터 메뉴</h2>
					<hr class="small">
					<div class="row">
						<div class="col-md-3 col-sm-6">
							<div class="service-item">
								<span class="fa-stack fa-4x"> <i
									class="fa fa-circle fa-stack-2x"></i> <i
									class="fa fa-cloud fa-stack-1x text-primary"></i>
								</span>
								<h4>
									<strong>Q & A</strong>
								</h4>
								<p>자주 하는 질문</p>
								<a href="#" class="btn btn-light">버튼을 냅둘까 말까</a>
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<div class="service-item">
								<span class="fa-stack fa-4x"> <i
									class="fa fa-circle fa-stack-2x"></i> <i
									class="fa fa-compass fa-stack-1x text-primary"></i>
								</span>
								<h4>
									<strong>(유저+관리자)채팅</strong>
								</h4>
								<p>실시간 문의</p>
								<a href="#" class="btn btn-light">Learn More</a>
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<div class="service-item">
								<span class="fa-stack fa-4x"> <i
									class="fa fa-circle fa-stack-2x"></i> <i
									class="fa fa-flask fa-stack-1x text-primary"></i>
								</span>
								<h4>
									<strong>게시판</strong>
								</h4>
								<p>비번,사진,지도,댓글(코멘트만),사용자끼리 채팅,수정,삭제</p>
								<a href="#" class="btn btn-light">Learn More</a>
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<div class="service-item">
								<span class="fa-stack fa-4x"> <i
									class="fa fa-circle fa-stack-2x"></i> <i
									class="fa fa-shield fa-stack-1x text-primary"></i>
								</span>
								<h4>
									<strong>메뉴하나남음ㅇㅅㅇ</strong>
								</h4>
								<p>Q&A, (유저+사장)채팅, 게시판</p>
								<a href="#" class="btn btn-light">Learn More</a>
							</div>
						</div>
					</div>
					<!-- /.row (nested) -->
				</div>
				<!-- /.col-lg-10 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container -->
	</section>


 	<!-- Callout -->
	<aside class="callout">
		<div class="text-vertical-center">
			<h1>~ 이건 어쩔까 1 ~<br>핫딜 할까?</h1>
		</div>
	</aside>
	
	
 	<!-- Call to Action -->
	<aside class="call-to-action bg-primary text-white">
		<div class="container text-center">
			<h3>~ 이건 어쩔까 2 ~</h3>
			<a href="#" class="btn btn-lg btn-light">Click Me!</a> <a href="#"
				class="btn btn-lg btn-dark">Look at Me!</a>
		</div>
	</aside> 
	

	<!-- 회사소개 -->
	<footer id="introduce">
		<div class="container">
			<div class="row">
				<div class="col-lg-10 mx-auto text-center">
					<h4>
						<strong>회사소개 합시다. 로고만들어야함</strong>
					</h4>
					<p>
						3481 Melrose Place <br>Beverly Hills, CA 90210
					</p>
					<ul class="list-unstyled">
						<li><i class="fa fa-phone fa-fw"></i> (123) 456-7890</li>
						<li><i class="fa fa-envelope-o fa-fw"></i> <a
							href="mailto:name@example.com">name@example.com</a></li>
					</ul>
					<br>
					<ul class="list-inline">
						<li class="list-inline-item"><a href="#"><i
								class="fa fa-facebook fa-fw fa-3x"></i></a></li>
						<li class="list-inline-item"><a href="#"><i
								class="fa fa-twitter fa-fw fa-3x"></i></a></li>
						<li class="list-inline-item"><a href="#"><i
								class="fa fa-dribbble fa-fw fa-3x"></i></a></li>
					</ul>
					<hr class="small">
					<p class="text-muted">Copyright &copy; Your Website 2017</p>
				</div>
			</div>
		</div>
		<a id="to-top" href="#top" class="btn btn-dark btn-lg page-scroll"><i
			class="fa fa-chevron-up fa-fw fa-1x"></i></a>
	</footer>
</body>

	<!-- Bootstrap core JavaScript -->
	<script src="../vendor/jquery/jquery.min.js"></script>
	<script src="../vendor/popper/popper.min.js"></script>
	<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for this template -->
	<script src="../js/stylish-portfolio.js"></script>

</html>