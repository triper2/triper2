<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="faq.service.dao.AlbumDao" %>
<%@ page import ="faq.service.domain.Album" %>   
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<c:if test="${check == 1}">
<script type="text/javascript">
alert("비밀번호가 맞습니다.");
window.opener.top.location.href="content.service?service_id=${param.service_id}";
window.close();  //현재 팝업창을 닫아줌
</script>
</c:if>
<c:if test="${check != 1}">    
    <script type="text/javascript">
        alert("비밀번호가 맞지 않습니다.");
        history.go(-1);
    </script>
</c:if>