<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="event.board.EboardDAO, event.board.EboardDTO" %>
<%@ page import="dbconn.util.*, dbclose.util.*, kosta.rental.loginModel.*"%>
<%@ page import="java.io.PrintWriter" %>
<jsp:useBean id="ebdto" class="event.board.EboardDTO" scope="page"/>
<jsp:setProperty property="ebTitle" name="ebdto"/>
<jsp:setProperty property="ebContent" name="ebdto"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<fmt:requestEncoding value="utf-8"/>

${ sessionScope.dto }
<c:set var="member_id" value="${ sessionScope.dto.member_id }"/>
<meta http-equiv="Refresh"  content="0; url=writeAction.eb">
