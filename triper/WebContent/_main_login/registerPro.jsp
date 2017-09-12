<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dbconn.util.*, dbclose.util.*, kosta.rental.loginModel.*, kosta.rental.loginAction.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.net.*  , java.util.*  ,  java.io.*" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
	<fmt:requestEncoding value="utf-8"/>

    <jsp:useBean id="dto" class="kosta.rental.loginModel.RentalDTO" />
	<jsp:setProperty property="*" name="dto"  />
	<jsp:useBean id="dao" class="kosta.rental.loginModel.RentalDAO" />
	

<script type="text/javascript">
alert("가입완료");
</script>	


<meta http-equiv="Refresh"  content="0; url=loginForm.do">
