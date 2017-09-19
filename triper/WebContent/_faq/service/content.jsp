<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib    prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>

<table width ="70%" border ="1" cellpadding="0" cellspacing="0" align="center">
<tr><td  colspan="2" align="center"><h1>상세보기</h1></tr>
<tr>
<td>글번호</td>
<td>${album.service_id}</td>
</tr>

<tr>
<td>작성자</td>
<td>${album.member_id}</td>
</tr>

<tr>
<td>IP</td>
<td>${album.service_ip}</td>
</tr>
<tr>
<td>조회수</td>
<td>${album.service_readcount}</td>
</tr>

<tr>
<td>작성일</td>
<td><fmt:formatDate value="${album.service_reg_date}" pattern="yyyy년MM월dd일"/></td>
</tr>
<tr>
    <td>이메일</td>
    
<c:if test="${! empty album.service_email}">
    <td>${album.service_email}</td>
</c:if>
<c:if test="${empty album.service_email}">    
    <td>&nbsp;</td>
</c:if>    
</tr>
<tr><td>이미지</td><td>
<img src="./faq/service/upload/${album.service_img}">
</td></tr>
<tr><td>글제목</td><td>
${album.service_title}
</td></tr>
<tr><td>내용</td><td>
${album.service_content}
</td></tr>
<tr><td colspan="2" align="center">
<input type = "button" value ="답글작성" onclick="document.location.href='writeForm.service?service_id=${album.service_id}&service_ref=${album.service_ref}&service_re_step=${album.service_re_step}&service_level=${album.service_level}'">
 <input type="button" value="수정하기" onClick="location.href='updateForm.service?service_id=${album.service_id}'">  
  <input type="button" value="삭제하기" onClick="location.href='deleteForm.service?service_id=${album.service_id}'">
  <input type="button" value="목록보기" onClick="location.href='list.service'">      
</td></tr>
</table>

</body>
</html>