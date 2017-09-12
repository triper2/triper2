<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dbconn.util.*, dbclose.util.*, kosta.rental.loginModel.*"%>
<%@page import="java.sql.*"%>
<jsp:useBean id="dto" class="kosta.rental.loginModel.RentalDTO" />
<jsp:setProperty property="*" name="dto"  />
<c:remove scope="session" var="sessionInfo" />
<c:remove scope="session" var="id" />


<meta http-equiv="Refresh" content="2; url=index.jsp">
