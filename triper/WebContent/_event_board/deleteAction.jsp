<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="event.board.EboardDAO, event.board.EboardDTO" %>
<%@ page import="dbconn.util.*, dbclose.util.*, kosta.rental.loginModel.*"%>
<%@ page import="java.io.PrintWriter" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

${ sessionScope.dto }
<c:set var="dto" value="${ sessionScope.dto }"/>
<meta http-equiv="Refresh"  content="0; url=deleteAction.eb?ebNum=${ param.ebNum }">
