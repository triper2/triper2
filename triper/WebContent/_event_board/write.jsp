<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="event.board.EboardDAO, event.board.EboardDTO" %>
<%@ page import="dbconn.util.*, dbclose.util.*, kosta.rental.loginModel.*"%>
<%@ page import="java.io.PrintWriter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap/css">
<title> 게시판 </title>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="../se2/js/HuskyEZCreator.js"
	charset="utf-8"></script>

<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


<script type="text/javascript" src="<%=request.getContextPath()%>/se2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.0.min.js"></script>
<!-- Smart Editor -->
<script type="text/javascript">
var oEditors = [];
$(function(){
	 var review_Image_1=null;
      nhn.husky.EZCreator.createInIFrame({
          oAppRef: oEditors,
          elPlaceHolder: "ebContent", //textarea에서 지정한 id와 일치해야 합니다. 
          //SmartEditor2Skin.html 파일이 존재하는 경로
          sSkinURI: "<%=request.getContextPath()%>/se2/SmartEditor2Skin.html",  
          fCreator: "createSEditor2"
      });
      //저장버튼 클릭시 form 전송
      $("#savebutton").click(function(){
          oEditors.getById["ebContent"].exec("UPDATE_CONTENTS_FIELD", []);
          $("#frm").submit();
      });   
      
     
});
function pasteHTML(filepath){
       var sHTML = '<img src="<%=request.getContextPath()%>/image/'+filepath+'">';
       oEditors.getById["ebContent"].exec("PASTE_HTML", [sHTML]);
   }
</script>

</head>
<body>
<jsp:include page="../_main_login/header.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
		<form action="writeAction.eb" method="post">
			<table class="table table-striped" style="text-align:center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color:#eeeeee; text-align:center;">게시판 글쓰기 양식</th>
					</tr>
				</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control" placeholder="글 제목" name="ebTitle" maxlength="50"></td>
						</tr>
						<tr>
							<td><textarea class="form-control" placeholder="글 내용" id="ebContent" name="ebContent" maxlength="2048" style="height:350px;"></textarea></td>
						</tr>
						
					</tbody>
				</table>
				<input type="submit" id="savebutton" name="savebutton" class="btn btn-primary pull-right" value="글쓰기">
			</form>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>