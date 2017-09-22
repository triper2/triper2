<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>


th {
    background-color: #8C8C8C;
    color: white;
}


.button {
  background-color: gray;
    border: none;
    color: white;
    padding: 15px 35px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
    margin: 4px 2px;
    cursor: pointer;
}
.button4 {border-radius: 12px;}
</style>

<body>



	
	<h2> 스 키 </h2>
	<center>
	<table width="1000" height="120"align="center" boarder="0">
	<thead>
	<tr align="center">
		<th align="center" width="150">스 키</th>
		<th align="center" width="100">스키명</th>
		<th align="center" width="100">대여일</th>
		<th align="center" width="100">반납일</th>
		<th align="center" width="50">사이즈</th>
		<th align="center" width="70">가격</th>
		<th align="center" width="70">수정</th>
		<th align="center" width="70">취소</th>
	</tr>
	</thead>
	<c:forEach var="sv" items="${sv }">
	<tbody>
	<tr align="center" height="60">
		<td align="center" width="150">
		<img alt="" src="img/${sv.product_skiimg }" width="140" height="90" border="0"></td>
		<td align="center" width="100">${sv.product_skiname  }</td>
		<td align="center" width="100">${sv.skibeginday }</td>
		<td align="center" width="100">${sv.skiendday }</td>
		<td align="center" width="50">${sv.skisize } </td>
		<td align="center" width="100">${sv.product_skiprice } </td>
		<td align="center" width="70">
			<button  class="button button4"onclick="location.href='SkiUpdateController.do?s_orderid=${sv.s_orderid}&skiimg=${sv.product_skiimg }'">수정</button>
		</td>
		<td align="center" width="70">
			<button  class="button button4" onclick="location.href='/SkiReserVation/_ski/SkiMain.jsp?center=ConfirmDelete.jsp&s_orderid=${sv.s_orderid}&bl_orderid=0&sc_orderid=0&b_orderid=0'">삭제</button>
		</td>
	</c:forEach>	 
	</tbody>
	</table>
	</center>
	<br><h2> 스 키 복 </h2><br>
	<center>
	<table width="1000"  align="center" boarder="0">
	<thead>
	<tr align="center">
		<th align="center" width="150">스 키 복</th>
		<th align="center" width="100">스키복명</th>
		<th align="center" width="100">대여일</th>
		<th align="center" width="100">반납일</th>
		<th align="center" width="50">사이즈</th>
		<th align="center" width="70">가격</th>
		<th align="center" width="70">수정</th>
		<th align="center" width="70">취소</th>
	</tr>
	</thead>
	<c:forEach var="scv" items="${scv }">
	<tbody>
	<tr align="center" height="60">
		<td align="center" width="150">
		<img alt="" src="img/${scv.product_skiclothimg }" width="140" height="90" border="0"></td>
		<td align="center" width="100">${scv.product_skiclothname  }</td>
		<td align="center" width="100">${scv.skiclothbeginday }</td>
		<td align="center" width="100">${scv.skiclothendday }</td>
		<td align="center" width="50">${scv.skiclothsize } </td>
		<td align="center" width="100">${scv.product_skiclothprice } </td>
		<td align="center" width="70"><button class="button button4" onclick="location.href='SkiclothUpdateController.do?sc_orderid=${scv.sc_orderid}&skiclothimg=${scv.product_skiclothimg }'">수정</button></td>
		<td align="center" width="70">
			<button  class="button button4" onclick="location.href='/SkiReserVation/_ski/SkiMain.jsp?center=ConfirmDelete.jsp&sc_orderid=${scv.sc_orderid}&b_orderid=0&bl_orderid=0&s_orderid=0'">삭제</button>
		</td>
	</c:forEach>	
	
	</tbody>
	</table>
	</center>
	<br><h2> 보 드 </h2><br>
	<center>
	<table width="1000" align="center" boarder="0">
	<thead>
	<tr align="center">
		<th align="center" width="150">보 드</th>
		<th align="center" width="100">보드명</th>
		<th align="center" width="100">대여일</th>
		<th align="center" width="100">반납일</th>
		<th align="center" width="50">사이즈</th>
		<th align="center" width="70">가격</th>
		<th align="center" width="70">수정</th>
		<th align="center" width="70">취소</th>
	</tr>
	</thead>
	<c:forEach var="bv" items="${bv }">
	<tbody>
	<tr align="center" height="60">
		<td align="center" width="150">
		<img alt="" src="img/${bv.product_boardimg }" width="140" height="90" border="0"></td>
		<td align="center" width="100">${bv.product_boardname  }</td>
		<td align="center" width="100">${bv.boardbeginday }</td>
		<td align="center" width="100">${bv.boardendday }</td>
		<td align="center" width="50">${bv.boardsize } </td>
		<td align="center" width="100">${bv.product_boardprice } </td>
			<td align="center" width="70"><button class="button button4"  onclick="location.href='BoardUpdateController.do?b_orderid=${bv.b_orderid}&boardimg=${bv.product_boardimg }'">수정</button></td>
		<td align="center" width="70">
			<button  class="button button4" onclick="location.href='/SkiReserVation/_ski/SkiMain.jsp?center=ConfirmDelete.jsp&b_orderid=${bv.b_orderid}&s_orderid=0&sc_orderid=0&bl_orderid=0'">삭제</button>
		</td>
	</c:forEach>	
	
	</tbody>
	</table>
	</center>
	<br><h2> 보 드 복 </h2><br>
	<center>
	<table width="1000" align="center" boarder="0">
	<thead>
	<tr align="center">
		<th align="center" width="150">보 드 복</th>
		<th align="center" width="100">보드명</th>
		<th align="center" width="100">대여일</th>
		<th align="center" width="100">반납일</th>
		<th align="center" width="50">사이즈</th>
		<th align="center" width="70">가격</th>
		<th align="center" width="70">수정</th>
		<th align="center" width="70">취소</th>
	</tr>
	</thead>
	<c:forEach var="bcv" items="${bcv }">
	<tbody>
	<tr align="center" height="60">
		<td align="center" width="150">
		<img alt="" src="img/${bcv.product_boardclothimg }" width="140" height="90" border="0"></td>
		<td align="center" width="100">${bcv.product_boardclothname  }</td>
		<td align="center" width="100">${bcv.boardclothbeginday }</td>
		<td align="center" width="100">${bcv.boardclothendnday }</td>
		<td align="center" width="50">${bcv.boardclothsize } </td>
		<td align="center" width="100">${bcv.product_boardclothprice } </td>
			<td align="center" width="70"><button class="button button4" onclick="location.href='BoardClothUpdateController.do?bl_orderid=${bcv.bl_orderid}&boardclothimg=${bcv.product_boardclothimg }'">수정</button></td>
		<td align="center" width="70">
			<button  class="button button4" onclick="location.href='/SkiReserVation/_ski/SkiMain.jsp?center=ConfirmDelete.jsp&bl_orderid=${bcv.bl_orderid}&s_orderid=0&sc_orderid=0&b_orderid=0'">삭제</button>
		</td>
	</c:forEach>	
	
	</tbody>
	</table>
	
	 
</center>
</body>
</html>