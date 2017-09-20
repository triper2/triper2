<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dbconn.util.*, dbclose.util.*, kosta.rental.*"%>
<%@ page import="java.sql.*"%>

<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>

<!doctype html>
<html lang="kr">
	<head>
	<meta charset="UTF-8">
	<title>Rental Shop</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
  
<style rel="stylesheet">
html {
  width: 100%;
  height: 200%;
}

body {
  background: -webkit-linear-gradient(45deg, rgba(66, 183, 245, 0.8) 0%, rgba(66, 245, 189, 0.4) 100%);
  background: linear-gradient(45deg, rgba(66, 183, 245, 0.8) 0%, rgba(66, 245, 189, 0.4) 100%);
  color: rgba(0, 0, 0, 0.6);
  font-family: "Roboto", sans-serif;
  font-size: 14px;
  line-height: 1.6em;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

.overlay, .form-panel.one:before {
  position: absolute;
  top: 0;
  left: 0;
  display: none;
  background: rgba(0, 0, 0, 0.8);
  width: 100%;
  height: 100%;
}

.form {
  z-index: 15;
  position: relative;
  background: #FFFFFF;
  width: 600px;
  border-radius: 4px;
  box-shadow: 0 0 30px rgba(0, 0, 0, 0.1);
  box-sizing: border-box;
  margin: 60px auto 10px;
  overflow: hidden;
}
.form-toggle {
  z-index: 10;
  position: absolute;
  top: 40px;
  right: 20px;
  background: #FFFFFF;
  width: 50px;
  height: 50px;
  border-radius: 100%;
  -webkit-transform-origin: center;
      -ms-transform-origin: center;
          transform-origin: center;
  -webkit-transform: translate(0, -25%) scale(0);
      -ms-transform: translate(0, -25%) scale(0);
          transform: translate(0, -25%) scale(0);
  opacity: 0;
  cursor: pointer;
  -webkit-transition: all 0.3s ease;
          transition: all 0.3s ease;
}
.form-toggle:before, .form-toggle:after {
  content: '';
  display: block;
  position: absolute;
  top: 50%;
  left: 50%;
  width: 30px;
  height: 4px;
  background: #4285F4;
  -webkit-transform: translate(-50%, -50%);
      -ms-transform: translate(-50%, -50%);
          transform: translate(-50%, -50%);
}
.form-toggle:before {
  -webkit-transform: translate(-50%, -50%) rotate(45deg);
      -ms-transform: translate(-50%, -50%) rotate(45deg);
          transform: translate(-50%, -50%) rotate(45deg);
}
.form-toggle:after {
  -webkit-transform: translate(-50%, -50%) rotate(-45deg);
      -ms-transform: translate(-50%, -50%) rotate(-45deg);
          transform: translate(-50%, -50%) rotate(-45deg);
}
.form-toggle.visible {
  -webkit-transform: translate(0, -25%) scale(1);
      -ms-transform: translate(0, -25%) scale(1);
          transform: translate(0, -25%) scale(1);
  opacity: 1;
}
.form-group {
  display: -webkit-box;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-flex-wrap: wrap;
      -ms-flex-wrap: wrap;
          flex-wrap: wrap;
  -webkit-box-pack: justify;
  -webkit-justify-content: space-between;
      -ms-flex-pack: justify;
          justify-content: space-between;
  margin: 0 0 20px;
}
.form-group:last-child {
  margin: 0;
}
.form-group label {
  display: block;
  margin: 0 0 10px;
  color: rgba(0, 0, 0, 0.6);
  font-size: 12px;
  font-weight: 500;
  line-height: 1;
  text-transform: uppercase;
  letter-spacing: .2em;
}
.two .form-group label {
  color: #FFFFFF;
}
.form-group input {
  outline: none;
  display: block;
  background: rgba(0, 0, 0, 0.1);
  width: 100%;
  border: 0;
  border-radius: 4px;
  box-sizing: border-box;
  padding: 12px 20px;
  color: rgba(0, 0, 0, 0.6);
  font-family: inherit;
  font-size: inherit;
  font-weight: 500;
  line-height: inherit;
  -webkit-transition: 0.3s ease;
          transition: 0.3s ease;
}
.form-group input:focus {
  color: rgba(0, 0, 0, 0.8);
}
.two .form-group input {
  color: #FFFFFF;
}
.two .form-group input:focus {
  color: #FFFFFF;
}
.form-group button {
  outline: none;
  background: #4285F4;
  width: 100%;
  border: 0;
  border-radius: 4px;
  padding: 12px 20px;
  color: #FFFFFF;
  font-family: inherit;
  font-size: inherit;
  font-weight: 500;
  line-height: inherit;
  text-transform: uppercase;
  cursor: pointer;
}
.two .form-group button {
  background: #FFFFFF;
  color: #4285F4;
}
.form-group .form-remember {
  font-size: 12px;
  font-weight: 400;
  letter-spacing: 0;
  text-transform: none;
}
.form-group .form-remember input[type='checkbox'] {
  display: inline-block;
  width: auto;
  margin: 0 10px 0 0;
}
.form-group .form-recovery {
  color: #4285F4;
  font-size: 12px;
  text-decoration: none;
}
.form-panel {
  padding: 20px calc(5% + 40px) 60px 60px;
  box-sizing: border-box;
}
.form-panel.one:before {
  content: '';
  display: block;
  opacity: 0;
  visibility: hidden;
  -webkit-transition: 0.3s ease;
          transition: 0.3s ease;
}
.form-panel.one.hidden:before {
  display: block;
  opacity: 1;
  visibility: visible;
}
.form-panel.two {
  z-index: 5;
  position: absolute;
  top: 0;
  left: 95%;
  background: #4285F4;
  width: 100%;
  min-height: 200%;
  padding: 20px calc(10% + 60px) 60px 60px;
  -webkit-transition: 0.3s ease;
          transition: 0.3s ease;
  cursor: pointer;
}
.form-panel.two:before, .form-panel.two:after {
  content: '';
  display: block;
  position: absolute;
  top: 40px;
  left: 1.5%;
  background: rgba(255, 255, 255, 0.2);
  height: 30px;
  width: 2px;
  -webkit-transition: 0.3s ease;
          transition: 0.3s ease;
}
.form-panel.two:after {
  left: 3%;
}
.form-panel.two:hover {
  left: 93%;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}
.form-panel.two:hover:before, .form-panel.two:hover:after {
  opacity: 0;
}
.form-panel.two.active {
  left: 10%;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  cursor: default;
}
.form-panel.two.active:before, .form-panel.two.active:after {
  opacity: 0;
}
.form-header {
  margin: 0 0 40px;
}
.form-header h1 {
  padding: 4px 0;
  color: #4285F4;
  font-size: 24px;
  font-weight: 700;
  text-transform: uppercase;
}
.two .form-header h1 {
  position: relative;
  z-index: 40;
  color: #FFFFFF;
}

.pen-footer {
  display: -webkit-box;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-orient: horizontal;
  -webkit-box-direction: normal;
  -webkit-flex-direction: row;
      -ms-flex-direction: row;
          flex-direction: row;
  -webkit-box-pack: justify;
  -webkit-justify-content: space-between;
      -ms-flex-pack: justify;
          justify-content: space-between;
  width: 600px;
  margin: 20px auto 100px;
}
.pen-footer a {
  color: #FFFFFF;
  font-size: 12px;
  text-decoration: none;
  text-shadow: 1px 2px 0 rgba(0, 0, 0, 0.1);
}
.pen-footer a .material-icons {
  width: 12px;
  margin: 0 5px;
  vertical-align: middle;
  font-size: 12px;
}

.cp-fab {
  background: #FFFFFF !important;
  color: #4285F4 !important;
}


a:link, a:visited, a:hover, a:active {
   text-decoration: none;
   color: black;
}

a.other:link, a.other:visited, a.other:hover, a.other:active {
   text-docoration: none;
   color: black;
}

</style>

<script type="text/javascript">
$(function() {
	/* $('#temp_img').hide(); */
	
	$('#member_img').click(function() {
		$('#temp_img').click();
	});
	
	$('#temp_img').change(function() {
		document.getElementById("member_img").value = $(this).val();
	});
	
	$('#member_id').keyup(function() {
		if ($('#member_id').val().length < 5 || $('#member_id').val().length > 15) {
			$('#idcheck').text('ID 5~15 자리입니다.').css('color', 'red');
		} else {
			$.ajax({
				type: 'post', //post방식
				url: 'idCheck.do', //요청처리
				data: {"member_id" : $('#member_id').val()}, //파라미터
				success:function(result){
					if(result == "true"){//true:DB에 ID 있음(중복)
		                $('#idcheck').text('사용할 수 없는 아이디입니다.(중복)').css('color', 'red');
					} else { //false:DB에 ID 없음 (사용가능)
						$('#idcheck').text('사용할 수 있는 아이디입니다.').css('color', 'blue');
					}
				},
				error:function(msg,error) {
					alert("error");
				}
			});
		}
	});
	
	$('#member_pwd').focusout(function() {
		$.ajax({
			type: 'post', //post방식
			url: 'pwCheck.do', //요청처리
			data: {"member_pwd" : $('#member_pwd').val()}, //파라미터
			success:function(result){
				if(result == "false"){
	                $('#pwcheck').text('비밀번호는 6~20자, 영문/숫자를 조합해야합니다').css('color', 'red');
				} else { 
					$('#pwcheck').text('Password OK').css('color', 'blue');
				}
			},
			error:function(msg,error) {
				alert("error");
			}
		});
	});
	
	$('#cpassword').keyup(function() {
		if ($('#member_pwd').val() != $('#cpassword').val()) {
			$('#pwcheck2').text('암호불일치!').css('color', 'red');
		} else {
			$('#pwcheck2').text('암호일치!').css('color', 'blue');
		}
	});

	$('#member_email').focusout(function() {
		$.ajax({
			type: 'post', //post방식
			url: 'emailCheck.do', //요청처리
			data: {"member_email" : $('#member_email').val()}, //파라미터
			success:function(result){
				if(result == "false"){
	                $('#emailcheck').text('Email 형식 맞춰주세요').css('color', 'red');
				} else { 
					$('#emailcheck').text('Email OK').css('color', 'blue');
				}
			},
			error:function(msg,error) {
				alert("error");
			}
		});
	});
	
	$('#member_phone').focusout(function() {
		$.ajax({
			type: 'post', //post방식
			url: 'phoneCheck.do', //요청처리
			data: {"member_phone" : $('#member_phone').val()}, //파라미터
			success:function(result){
				if(result == "false"){
	                $('#phonecheck').text('(-)포함 폰 번호 맞춰주세요').css('color', 'red');
				} else { 
					$('#phonecheck').text('Phone OK').css('color', 'blue');
				}
			},
			error:function(msg,error) {
				alert("error");
			}
		});
	});

	$('#ssubmitbtn').click(function() {
		if ($('#member_id').val() == ""
				|| $('#member_name').val() == ""
				|| $('#member_pwd').val() == ""
				|| $('#cpassword').val() == ""
				|| $('#member_phone').val() == ""
				|| $('#member_email').val() == ""
				|| ($('#member_pwd').val() != $(
						'#cpassword').val())
				|| ($('#member_id').val().length < 5 || $(
						'#member_id').val().length > 15)) {
			alert('필수 값 및 정확히 입력하세요');
			return false;
		} else {
			$("#fssubmit").submit();
		}
	});
});


</script>

${ sessionScope.dto }
<c:set var="dto" value="${ sessionScope.dto }"/>

<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
<!-- Form-->
<div class="form">
  <div class="form-toggle"></div>
  <div class="form-panel one">
    <div class="form-header">
      <h1>Account Login</h1>
    </div>
    <div class="form-content" >
      <form action="loginPro.do" id="flsubmit" method="post">
        <div class="form-group">
          <label for="username">ID</label>
          <input type="text" id="id" name="id" required="required"/>
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" id="password" name="password" required="required"/>
        </div>
        <div class="form-group">
          <!-- <label class="form-remember">
            <input type="checkbox"/>Remember Me
          </label><a href="#" class="form-recovery">Forgot Password?</a> -->
        </div>
        <div class="form-group">
          <button type="submit">Log In</button>
        </div>
        <a style="color: gray;" href="">아이디 찾기</a>, 
        <a style="color: gray;" href="">비밀번호 찾기</a>
        <a style="float:right ;color: gray;" href="#" onclick="$('.form-panel.two').click()">회원가입</a>
      </form>      <br>
      
      <div id="naver_id_login"></div>
  <script type="text/javascript">
  	var naver_id_login = new naver_id_login("jG6JK4zeWYdD6NtIKfw4", "http://localhost:8080/triper/callback.jsp");
  	var state = naver_id_login.getUniqState();
  	naver_id_login.setButton("white", 2,40);
  	naver_id_login.setDomain("http://localhost:8080/triper/_main_login/index.jsp");
  	naver_id_login.setState(state);
  	//naver_id_login.setPopup();
  	naver_id_login.init_naver_id_login();
  </script>
     
      <!-- <form action="naverlogin.do" method="post">
      <div>
		<button type="submit" id="naverlogin" >
		<img height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/>
		</button>
      </div>      
      </form> -->
        <input type="file" id="temp_img" name="temp_img" />
    </div>
  </div>
  <div class="form-panel two">
    <div class="form-header">
      <h1>Register Account</h1>
    </div>
    <div class="form-content">
      <form action="registerPro.do" id="fssubmit" method="post" encType="multipart/form-data" >
        <div class="form-group">
          <label for="username">ID</label>
          <input type="text" id="member_id" name="member_id" required="required"/>
          <font id="idcheck" name="idcheck"></font>
        </div>
        <div class="form-group">
          <label for="name">Name</label>
          <input type="text" id="member_name" name="member_name" required="required"/>
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" id="member_pwd" name="member_pwd" required="required"/>
          <font id="pwcheck" name="pwcheck"></font>
        </div>
        <div class="form-group">
          <label for="cpassword">Password Check</label>
          <input type="password" id="cpassword" name="cpassword" required="required"/>
          <font id="pwcheck2" name="pwcheck2"></font>
        </div>
        <div class="form-group">
          <label for="phone">Phone number</label>
          <input type="phone" id="member_phone" name="member_phone" required="required"/>
          <font id="phonecheck" name="phonecheck"></font>
        </div>
        <div class="form-group">
          <label for="email">Email Address</label>
          <input type="email" id="member_email" name="member_email" required="required"/>
          <font id="emailcheck" name="emailcheck"></font>
        </div>
        
          <!-- <div class="form-group">
          <label for="image">Image</label>
          <input type="file" id="member_img" name="member_img"/>
        </div> -->
        
        <br>
        <div class="form-group">
          <button type="submit" id="ssubmitbtn">Register</button>
        </div>
      </form>
    </div>
  </div>
</div>

<script type="text/javascript">
$(document).ready(function() {
  var panelOne = $('.form-panel.two').height(),
    panelTwo = $('.form-panel.two')[0].scrollHeight;

  $('.form-panel.two').not('.form-panel.two.active').on('click', function(e) {
    e.preventDefault();
    $('.form-toggle').addClass('visible');
    $('.form-panel.one').addClass('hidden');
    $('.form-panel.two').addClass('active');
    $('.form').animate({'height': panelTwo}, 200);
  });

  $('.form-toggle').on('click', function(e) {
    e.preventDefault();
    $(this).removeClass('visible');
    $('.form-panel.one').removeClass('hidden');
    $('.form-panel.two').removeClass('active');
    $('.form').animate({
      'height': panelOne
    }, 200);
  });
});
</script>
</body>
</html>
