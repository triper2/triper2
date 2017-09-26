<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang='en'>
	<head>
		<meta charset="utf-8"/>
		<title>Nowstartwebdesign.com-  Pure CSS Horizontal Drop Down Menu Bar</title>
<style>
body {
  font-family: "Lucida Sans Typewriter", "Lucida Console", Monaco, "Bitstream Vera Sans Mono", monospace;
  margin: 0px;
  padding: 50px;
  background: white;
}
.menu {
  position: relative;
  height: 44px;
  background: #2b2f3a;
  width: auto;
}
.menu ul {
  list-style: none;
  padding: 0;
  margin: 0;
  line-height: 1;
}
.menu > ul {
  position: relative;
  display: block;
  background: #2b2f3a;
  width: 100%;
  z-index: 500;
}
.menu:after, .menu > ul:after {
  content: ".";
  display: block;
  clear: both;
  visibility: hidden;
  line-height: 0;
  height: 0;
}
.menu.align-right > ul > li {
  float: right;
}
.menu.align-center ul {
  text-align: center;
}
.menu.align-center ul ul {
  text-align: left;
}
.menu > ul > li {
  display: inline-block;
  position: relative;
  margin: 0;
  padding: 0;
}
.menu > ul > #menu-button {
  display: none;
}
.menu ul li a {
  display: block;
  font-family: Helvetica, sans-serif;
  text-decoration: none;
}
.menu > ul > li > a {
  font-size: 14px;
  font-weight: bold;
  padding: 15px 20px;
  color: #fff;
  text-transform: uppercase;
  -webkit-transition: color 0.25s ease-out;
  -moz-transition: color 0.25s ease-out;
  -ms-transition: color 0.25s ease-out;
  -o-transition: color 0.25s ease-out;
  transition: color 0.25s ease-out;
}
.menu > ul > li.sub > a {
  padding-right: 32px;
}
.menu > ul > li:hover > a {
  color: #ffffff;
}
.menu li.sub::after {
  display: block;
  content: "";
  position: absolute;
  width: 0;
  height: 0;
}
.menu > ul > li.sub::after {
  right: 10px;
  top: 20px;
  border: 5px solid transparent;
  border-top-color: #7a8189;
}
.menu > ul > li:hover::after {
  border-top-color: #ffffff;
}
.menu ul ul {
  position: absolute;
  left: -9999px;
  top: 70px;
  opacity: 0;
  -webkit-transition: opacity .3s ease, top .25s ease;
  -moz-transition: opacity .3s ease, top .25s ease;
  -ms-transition: opacity .3s ease, top .25s ease;
  -o-transition: opacity .3s ease, top .25s ease;
  transition: opacity .3s ease, top .25s ease;
  z-index: 1000;
}
.menu ul ul ul {
  top: 37px;
  padding-left: 5px;
}
.menu ul ul li {
  position: relative;
}
.menu > ul > li:hover > ul {
  left: auto;
  top: 44px;
  opacity: 1;
}
.menu.align-right > ul > li:hover > ul {
  left: auto;
  right: 0;
  opacity: 1;
}
.menu ul ul li:hover > ul {
  left: 170px;
  top: 0;
  opacity: 1;
}
.menu.align-right ul ul li:hover > ul {
  left: auto;
  right: 170px;
  top: 0;
  opacity: 1;
  padding-right: 5px;
}
.menu ul ul li a {
  width: 130px;
  border-bottom: 1px solid #eeeeee;
  padding: 10px 20px;
  font-size: 12px;
  color: #9ea2a5;
  background: #BDBDBD;
  -webkit-transition: all .35s ease;
  -moz-transition: all .35s ease;
  -ms-transition: all .35s ease;
  -o-transition: all .35s ease;
  transition: all .35s ease;
}
.menu.align-right ul ul li a {
  text-align: right;
}
.menu ul ul li:hover > a {
  background: #f2f2f2;
  color: #8c9195;
}
.menu ul ul li:last-child > a, .menu ul ul li.last > a {
  border-bottom: 0;
}
.menu > ul > li > ul::after {
  content: '';
  border: 6px solid transparent;
  width: 0;
  height: 0;
  border-bottom-color: #ffffff;
  position: absolute;
  top: -12px;
  left: 30px;
}
.menu.align-right > ul > li > ul::after {
  left: auto;
  right: 30px;
}
.menu ul ul li.sub::after {
  border: 4px solid transparent;
  border-left-color: #9ea2a5;
  right: 10px;
  top: 12px;
  -moz-transition: all .2s ease;
  -ms-transition: all .2s ease;
  -o-transition: all .2s ease;
  transition: all .2s ease;
  -webkit-transition: -webkit-transform 0.2s ease, right 0.2s ease;
}
.menu.align-right ul ul li.sub::after {
  border-left-color: transparent;
  border-right-color: #9ea2a5;
  right: auto;
  left: 10px;
}
.menu ul ul li.sub:hover::after {
  border-left-color: #ffffff;
  right: -5px;
  -webkit-transform: rotateY(180deg);
  -ms-transform: rotateY(180deg);
  -moz-transform: rotateY(180deg);
  -o-transform: rotateY(180deg);
  transform: rotateY(180deg);
}
.menu.align-right ul ul li.sub:hover::after {
  border-right-color: #ffffff;
  border-left-color: transparent;
  left: -5px;
  -webkit-transform: rotateY(180deg);
  -ms-transform: rotateY(180deg);
  -moz-transform: rotateY(180deg);
  -o-transform: rotateY(180deg);
  transform: rotateY(180deg);
}

</style>
	</head>
	<body>
			
<form>
		<div class='menu'>
			<ul>
				<li>
					<a href='/triper/_main_login/main.jsp'>Home</a>
				</li>
				
				<li>
					<a href='#'>About Us</a>
				</li>
				<li class='active sub'>
					<a href='#'>장비렌탈</a>
					<ul>
						<li class='sub'>
							<a href='/triper/SkiListController1.jsp'>SKI</a>
						<!-- 	<ul>
							
								<li>
									<a href='/triper/SkiListController1.jsp'>SKI</a>
								</li>
								<li class='last'>
									<a href='/triper/SkiClothListController.do'>SKI CLOTH</a>
								</li>
							</ul> -->
							
						</li>
						<li class='sub'>
							<a href='/triper/SkiClothListController.do'>SKICLOTH</a>
						<!-- 	<ul>
							
								<li>
									<a href='/triper/SkiListController1.jsp'>SKI</a>
								</li>
								<li class='last'>
									<a href='/triper/SkiClothListController.do'>SKI CLOTH</a>
								</li>
							</ul> -->
							
						</li>
						<li class='sub'>
							<a href='/triper/BoardListController.do'>Board</a>
						<!-- 	<ul>
							
								<li>
									<a href='/triper/SkiListController1.jsp'>SKI</a>
								</li>
								<li class='last'>
									<a href='/triper/SkiClothListController.do'>SKI CLOTH</a>
								</li>
							</ul> -->
							
						</li>
						<li class='sub'>
							<a href='/triper/BoardClothListController.do'>BoardCLOTH</a>
							<!-- <ul>
								<li>
									<a href='/triper/BoardListController.do'>Board</a>
								</li>
								<li class='last'>
									<a href='/triper/BoardClothListController.do'>Board Cloth</a>
								</li>
							</ul> -->
						</li>
					</ul>
				</li>
				<li>
					<a href='/triper/_ski/SkiMain.jsp?center=ReserveConfirm.jsp'>예약확인</a>
				</li>
				<li class='last'>
					<a href='/triper/_ski/SkiMain.jsp?center=Add.jsp'> 상품 추가</a>
				</li>
			</ul>
		</div>
</form>
	</body>
</html>