<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="faq.service.dao.AlbumDao" %>
<%@ page import ="faq.service.domain.Album" %>   
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jstl/fmt_rt" %>
    
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko" id="top">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title> Triper </title>
  <link type="text/css" rel="stylesheet" href="../_faq/service/css/popup.css" media="all" />
  <!--[if IE 6]>
    <link type="text/css" rel="stylesheet" href="/site/inc/css/design_ie6_fix.css" />
  <![endif]-->
  <!--[if IE 7]>
    <link type="text/css" rel="stylesheet" href="/site/inc/css/design_ie7_fix.css" />
  <![endif]-->
  <!--[if IE 8]>
    <link type="text/css" rel="stylesheet" href="/site/inc/css/design_ie8_fix.css" />
  <![endif]-->
  <script type="text/javascript" src="/site/inc/web1/js/design.js"></script>
	<script type="text/javascript">
		function checkPassWord() {
			var sBoardPassWord = document.getElementById("service_pwd"); 
			if(sBoardPassWord.value.replace(/\s/g, '')=="") {
				alert("비밀번호를 입력하세요");
			} else {
				document.getElementById("passWordForm").submit();
			}
		}
	</script>
	</head>
<body class="popup">
  <form name="passWordForm" id="passWordForm" action="checkPro.service?service_id=${service_id}" method="post">
	<div id="popWrap2">
  <div class="popbtm2">
    <div class="poptop2">
    	<h1><img src="../_faq/service/images/tit_pw.gif" alt="비밀번호 입력" /></h1>
      <div id="popCont2">
        <!-- contents -->
       <img src="../_faq/service/images/txt_pop002.gif" alt="비밀글입니다. 설정하신 비밀번호를 입력해 주세요." />
        <p class="input2"><input type="password" name="service_pwd" id="service_pwd" class="text" /></p>
        <div class="btnCenter">
         <a href="checkPro.service?service_id=${service_id}" onclick="checkPassWord(); return false;"><img src="../_faq/service/images/btn_ok.gif" alt="확인" /></a>
          <a href="#" onclick="window.close();" ><img src="../_faq/service/images/btn_cancel.gif" alt="취소" /></a>
        </div>
        <!-- //contents -->
      </div>
      <!-- <a href="#" onclick="window.close();" class="btn"><img src="../_faq/service/images/btn_close.gif" alt="창닫기" /></a> -->
		</div>
  </div>
</div>
</form>
</body>
</html>
