<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="bbs.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width",intial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>Insert title here</title>
<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="js/bootstrap.js"></script>

	
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="se2/js/HuskyEZCreator.js" charset="utf-8"></script>

<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</head>
<body>

<%
		String userID ="123";
		int bbsID =0;
		if(session.getAttribute("userID") !=null){
			userID= (String) session.getAttribute("userID");
		}
		if (request.getParameter("bbsID") != null) {
			bbsID = Integer.parseInt(request.getParameter("bbsID"));
			System.out.println("asd"+bbsID);
		}
		if(userID == null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('로그인을 하세요')");
			script.println("location.href = 'login.jsp'");//로그인 페이지
			script.println("</script>");
		}else{
			BbsDAO bbsDAO = new BbsDAO();
			int result = bbsDAO.delete(bbsID);
			if(result == -1){
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('글 삭제에 실패했습니다')");
				script.println("history.back()");
				script.println("</script>");
			}else{
				
				
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href = 'bbs.jsp'");//로그인 페이지
				script.println("</script>");
			}
				
		}
	
		Bbs bbs = new BbsDAO().getBbs(bbsID);
		if(!userID.equals(bbs.getUserID())){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('권한이 없습니다.')");
			script.println("location.href='bbs.jsp'");
			script.println("</script>");
		}
	
	%>

<center>
	<div class="container">
	<div class="row">
	<form method="post" action="writeAction.jsp">
	<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
	<thead>
	<tr>
	<th colspan="2" style="background-color:#eeeeee; text-align: center;">글 쓰기</th>

	</tr>	
	</thead>
	<tbody>
	<tr>
	<td><input type="text" class="form-control" placeholder="글 제목" name="bbsTitle" maxlength="50"></td>
	</tr>
	
	 <tr>
   <td>
   <div class="form-group" style="text-align: center; ma rgin: 0 auto;">
   <div class="btn-group" data-toggle="buttons">
   <label class="btn btn-primary active">
      <input type="radio" name="userChat" autocomplete="off" value="채팅 사용" checked>채팅 사용
   </label>
   
   <label class="btn btn-primary ">
      <input type="radio" name="userChat" autocomplete="off" value="채팅 사용안함" >채팅 사용안함
   </label>
   </div>
   </div>
   </td>
   </tr>
	
	
	<tr>
	<td><textarea class="form-control" placeholder="글 제목" name="bbsContent" id="bbsContent" maxlength="2048" style="height:350px;"></textarea></td>
	</tr>
	
	</tbody>
	
	</table>
	<input type="submit" name=savebutton id="savebutton" class="btn btn-primary pull-right" value="글쓰기">
	</form>
	</div>
	
	</div>
</center>
</body>
</html>
