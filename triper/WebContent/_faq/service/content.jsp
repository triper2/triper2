<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title> Triper </title>
<script type="text/javascript">


</script>
</head>
<body>
<jsp:include page="../../_main_login/header.jsp"></jsp:include>
<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">

<tr>					
	<th colspan="2"style="background-color: #eeeeee; text-align: center;"><h4>고 객 센 터</h4></th>					
</tr>


<tr>
<td style="width: 20%;">글제목
</td>
<td>
${album.service_title}
</td></tr>

<tr>
<td>작성자</td>
<td>${album.member_id}</td>
</tr>

<tr>
<td>이메일</td>
<td><A href="mailto:${album.service_email}">${album.service_email}</A></td>
</tr>


<tr>
<td>조회수</td>
<td>${album.service_readcount}</td>
</tr>

<tr>
<td>작성일</td>
<td><fmt:formatDate value="${album.service_reg_date}" pattern="yyyy년MM월dd일"/></td>
</tr>


<tr><td>내용</td>
<td style="height:350px; text-align: left;">
${album.service_content}
</td></tr>

<tr><td >이미지</td><td>
<c:if test="${album.service_img != null}">
<img src="../_faq/service/upload/${album.service_img}" width="400" height="300" >
</c:if>

</td></tr>

<tr>
<td colspan="2" align="center">
<form name="myform" action="deletePro.service?service_id=${service_id}" method="post" onSubmit="return checkIt()">
<input type = "button" value ="답글작성"  class="btn btn-success" onclick="document.location.href='writeForm.service?service_id=${album.service_id}&service_ref=${album.service_ref}&service_re_step=${album.service_re_step}&service_level=${album.service_level}'">
<c:if test="${album.member_id == sessionScope.dto.member_id}">
 <input type="button" value="수정하기"  class="btn btn-success" onClick="location.href='updateForm.service?service_id=${album.service_id}'">  
   <a onclick="return confirm('정말로 삭제하시겠습니까?')"
							href="deletePro.service?service_id=${album.service_id}"
							class="btn btn-success">삭제하기</a>
   <!-- <input type=submit value="삭제하기" class="btn btn-success">  -->
  <%-- <input type="button" value="삭제하기"  class="btn btn-success" onClick="location.href='deleteForm.service?service_id=${album.service_id}'"> --%>
  </c:if>
  <input type="button" value="목록보기"  class="btn btn-success" onClick="location.href='list.service'">      
</td></tr>
</table>
</form>
</body>
</html>