<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jstl/fmt_rt" %>
  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<link rel="stylesheet" href="../../css/bootstrap.css">
<link rel="stylesheet" href="../../css/custom.css">

<head><title>글삭제</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="../../js/bootstrap.js"></script>

   <script type="text/javascript">
     <!--
       function begin(){
         document.myform.passwd.focus();
       }

       function checkIt(){
          if(!document.myform.passwd.value){
           alert("비밀번호를 입력하지 않으셨습니다.");
           document.myform.passwd.focus();
           return false;
         }
       return true;
       }   
     //-->
   </script>
</head>
<jsp:include page="../../_main_login/header.jsp"></jsp:include>
<BODY onload="begin()">
<form name="myform" action="deletePro.service?service_id=${service_id}" method="post" onSubmit="return checkIt()">
<div class="container">
<div class="row">
<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
  <tr height="30">
    <td colspan="2" align="center">
      <font size="+1" ><b>글삭제</b></font></td></tr>
  
  <tr>
<!-- <td colspan=2><input type="password" class="form-control" placeholder="비밀번호" size="8" name="service_pwd" maxlength="12"></td> -->
<td colspan="2"><input type="text" class="form-control" value="글을 삭제하실거면 삭제 버튼을 다시 눌러주세요">
</tr>
  <tr height="30">
    <td colspan="2" align="center">
      <input type=submit value="글삭제하기" class="btn btn-success"> 
      <input type="button" value="취  소" class="btn btn-success" onclick="location.href='list.service'"></TD></TR>
</TABLE>
</div>
</div>
</form>
</BODY>
</HTML>