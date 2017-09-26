<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dbconn.util.*, dbclose.util.*, kosta.rental.loginModel.*, kosta.rental.loginAction.*"%>
<%@page import="java.sql.*"%>

<!doctype html>
<html lang="kr">
	<head>
	<meta charset="UTF-8">
	<title>modifyForm.jsp</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
  
<style rel="stylesheet">
html {
  width: 100%;
  height: 100%;
}

body {
  background: -webkit-linear-gradient(45deg, rgba(66, 183, 245, 0.8) 0%, rgba(66, 245, 189, 0.4) 100%);
  background: linear-gradient(45deg, rgba(66, 183, 245, 0.8) 0%, rgba(66, 245, 189, 0.4) 100%);
  color: rgba(0, 0, 0, 0.6);
  font-family: "Roboto", sans-serif;
  font-size: 14px;
  line-height: 1.0em;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
.form {
  z-index: 15;
  position: relative;
  background: #FFFFFF;
  width: 500px;
  border-radius: 4px;
  box-shadow: 0 0 30px rgba(0, 0, 0, 0.1);
  box-sizing: border-box;
  margin: 60px auto 10px;
  overflow: hidden;
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
.form-group .form-remember {
  font-size: 12px;
  font-weight: 400;
  letter-spacing: 0;
  text-transform: none;
}
.form-panel {
  padding: 30px calc(5% + 30px) 60px 60px;
  box-sizing: border-box;
}
.form-header {
  margin: 0 0 0;
}
.form-header h1 {
  padding: 4px 0;
  color: #4285F4;
  font-size: 24px;
  font-weight: 700;
  text-transform: uppercase;
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

function FindAjax1() {
	$.ajax({
		url : "findID.do",
		type : "post",
		data : {"member_email" : $('#member_email').val()},
		success : function(id) {
			if (id == null) {
				alert('널널');
			} else {
				alert('아이디 : ' + id);
			}
		}
	});
}
	
function FindAjax2() {
	$.ajax({
		url : "findPWD.do",
		type : "post",
		data : {"member_id" : $('#member_id').val(), "member_phone" : $('#member_phone').val()},
		success : function(pwd) {
			if (pwd == null) {
				alert('널널');
			} else {
				alert('비밀번호 : ' + pwd);
			}
		}
	});
}
	
</script>

</head>

<body>

<div class="form">
 <div class="form-panel one">
    <div class="form-header">
      <h1>Find User</h1>
    </div><br/>
    <div class="form-content">
        <div class="form-group">
          <label for="username"><b>ID 찾기</b></label>
          <input type="text" id="member_email" name="member_email" placeholder="Email 입력"/>
          <button type="submit" onclick="FindAjax1()">찾기</button>
          <%-- <input type="text" name="namecheck" value="${ dto.member_id }"> --%>
        </div>
        <br><br>
        <div class="form-group">
          <label for="password"><b>password 찾기</b></label>
          <input type="text" id="member_id" name="member_id" placeholder="ID 입력"/>
          <input type="text" id="member_phone" name="member_phone" placeholder="Phone 입력"/>
          <button type="submit" onclick="FindAjax2()">찾기</button>
          <%-- <input type="text" name="phonecheck" value="${ dto.member_pwd }"> --%>
        </div>
    </div>
  </div>
</div>

</body>
</html>