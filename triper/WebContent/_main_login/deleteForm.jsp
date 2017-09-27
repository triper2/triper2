<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dbconn.util.*, dbclose.util.*, kosta.rental.loginModel.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title> Triper </title>
<!-- Bootstrap styles -->
</head>

<body>
	<jsp:include page="../_main_login/header.jsp"></jsp:include>


<script type="text/javascript">
        // 비밀번호 미입력시 경고창
        function checkValue(){
            if(!document.myform.password.value){
                alert("비밀번호를 입력하지 않았습니다.");
                return false;
            }
        }
</script>

<body align="center"><br/><br/><br/><br/><br/>
<form name="myform"  method="post" action="deletePro.do" onsubmit="return checkValue()">
		<div id="fadeandscale" class="well">
			<label width="100px" align="center">PASSWORD 
			<input type="password" name="password" size="15" maxlength="15">
		<br/><br/>
			<input type="submit" value="탈퇴"> 
			<input type="button" value="취소" onclick="history.back(-1);">
		</div>
</form>
</body>
</html>