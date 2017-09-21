<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../../css/bootstrap.css">
<link rel="stylesheet" href="../../css/custom.css">

<title>글목록</title>

<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="../../js/bootstrap.js"></script>
<script src="./js/jquery.bpopup.min.js"></script>

<script type="text/javascript">
  function searchMessage(){
   if(document.search.keyWord.value==""){
     alert("검색어를 입력하세요");
     document.search.keyWord.focus();
     return false;
   }
   return true;
  }
  
  function openWin(url,name){  //opneWin()호출시 팝업창띄움 url경로와 name값을 받는다.
	  window.open(url,name,"scrollbars=no,status=no,resizable=no,width=300,height=150");
	 }

</script>


</head>
<body>
<jsp:include page="../../_main_login/header.jsp"></jsp:include>
<c:if test="${page.service_readcount == 0}">
<table width="70%" border="1" cellpadding="0" cellspacing="0" align="center">
<tr>
    <td bgcolor="#e9e9e9">
    앨범에 저장된 글이 없습니다.
    </td>
</table>
</c:if>

<c:if test="${page.service_readcount > 0}">


<table class="table table-striped"style="text-align: center; border: 3px solid #dddddd">
<!-- <table  width="70%" border="1" cellpadding="0" cellspacing="0" align="center"> -->
<tr>
<th width="70" style="background-color: #eeeeee; text-align: center;">번호</th>
<th style="background-color: #eeeeee; text-align: center;">글제목</th>
<th width="120" style="background-color: #eeeeee; text-align: center;">작성자</th>
<th width="70" style="background-color: #eeeeee; text-align: center;">조회수</th>
<th width="180" style="background-color: #eeeeee; text-align: center;">작성일</th>
</tr>
<c:set var="number" value="${page.number}"/>
<c:forEach var="album" items="${albumList}">
<tr> 
    <td>${number}<c:set var="number" value="${number - 1}"/></td>
    		
	
    <td align="left">
	<c:forEach var="j" begin="0" end="${album.service_level }">
	&nbsp;&nbsp;&nbsp;
	</c:forEach>
	<c:if test="${album.service_level > 0}" >
	<img src="../_faq/service/images/reply_icon.gif"> 
	</c:if>
	
     <a href="content.service?service_id=${album.service_id}">
     <c:if test="${album.service_pwd == null }">
     	 ${album.service_title}
     </c:if>
     <c:if test="${album.service_pwd != null }">
     	
    	<%-- <a href="checkForm.service?service_id=${album.service_id}" onclick="window.open(this.href, '_blanck', 'width=550, height=400', 'scrollbars=no','status=no','resizable=no'); return false">비공개 글 입니다</a>  --%>
		<a href="checkForm.service?service_id=${album.service_id}" id="bpopup1" onclick="window.open(this.href, '_blanck', 'width=550, height=400, left=380px, top=150px', 'scrollbars=no','status=no','resizable=no', 'location=no'); return false">비공개 글 입니다</a>
		
     </c:if>
    <%--  ${album.service_title}</a></td> --%>
    <td>${album.member_id}</td>
     <td>${album.service_readcount}</td>
    <td><fmt:formatDate value="${album.service_reg_date}" pattern="yyyy년MM월dd일"/></td>
</tr>
</c:forEach>
</table>





</c:if>





 <form action="list.service" name="search" method="get" onsubmit="return searchMessage()">
<table class="table table-striped"style="text-align: center; border: 3px solid #dddddd">
  <tr><td width="200"><a href="writeForm.service" class="btn btn-success">글쓰기</a></td>
    <td align="center" valign="bottom">
      <select class="form-control" name="keyField" >
          <option value="service_title">제목</option>      
          <option value="member_id">이름</option>
          <option value="service_content">내용</option>
      </select>
     </td>
     <td>
     <div class="col-xs-9">
     <input type="text" size=16 id="keyWord" placeholder="검 색 하 기" name="keyWord" class="form-control">
     </div>
     <input type="submit" class="btn btn-success"value="검 색 하 기">
     
     </td>
   </tr> 
   <tr><td colspan="3" align="center">
   
<c:if test="${page.service_readcount > 0}">
   <c:set var="pageCount" value="${(page.service_readcount - 1) / page.pageSize + 1}"/>
   <c:set var="pageBlock" value="${10}"/>
   <fmt:parseNumber var="rs" value="${(currentPage - 1) / pageBlock}" integerOnly="true" />
   <c:set var="startPage" value="${rs*pageBlock+1}"/>
   <c:set var="endPage" value="${startPage + pageBlock-1}"/>
   <c:if test="${endPage > pageCount}">
        <c:set var="endPage" value="${pageCount}"/>
   </c:if> 
          

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
      
          <a href="list.service?pageNum=${i}&keyField=${page.keyField}&keyWord=${page.keyWord}"class="btn btn-success btn-arraw-left">${i}</a>
     
       
   </c:forEach>
   

</c:if>
   </td></tr>
</table>
</form>
</body>
</html>