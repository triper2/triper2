<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!doctype html>
<html lang="ko">
<head>
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
	<script type="text/javascript">
  var naver_id_login = new naver_id_login("jG6JK4zeWYdD6NtIKfw4", "http://localhost:8080/triper/_main_login/index.jsp");
  // 접근 토큰 값 출력
  //alert(naver_id_login.oauthParams.access_token);
  // 네이버 사용자 프로필 조회
  naver_id_login.get_naver_userprofile("naverSignInCallback()");
  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
  function naverSignInCallback() {
 	  
	  var sessionInfo = naver_id_login.getProfileData('email');
	  document.getElementById("ID").value = naver_id_login.getProfileData('id');
	  document.getElementById("name").value = naver_id_login.getProfileData('name');
	  document.getElementById("email").value = naver_id_login.getProfileData('email');
  }
</script>

<form action="index.jsp">
<input id="ID"></input>
<input id="name"></input>
<input id="email"></input>
<input type="submit">
</form>
	
	<!-- <meta http-equiv="Refresh" content="0; url=_main_login/index.jsp "> -->
</body>
</html>