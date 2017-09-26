<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="./css/button.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${compare <0 }">
<script>
			alert("날짜를 다시 선택해 주세요.");
			history.go(-1);
		</script>
</c:if>
<c:if test="${compare1 <0 }">
<script>
			alert("날짜를 다시 선택해 주세요.");
			history.go(-1);
		</script>
</c:if>
<c:if test="${calDateDays <0 }">
<script>
			alert("날짜를 다시 선택해 주세요.");
			history.go(-1);
		</script>
</c:if>
<form action="BoardOrder.do" method="post"> 
	<center>

		<table>
<tr>
<td><img src="img/${bean.product_boardimg }" width="300" height="300"></td>
</tr>
			<tr>
				<td align="center">총 비 용 : ${b_total } 원</td>
				
			</tr>
			<tr>
			<td align="center">대 여 일 :${bean.boardbeginday }</td>
			</tr>
			<tr>
			<td align="center">반 납 일 :${bean.boardendday }</td>
			</tr>
			<tr>
			<td align="center">사 이 즈 :${bean.boardsize }</td>
			</tr>
		</table>
	<input type="hidden" name="product_boardimg" value="${bean.product_boardimg }">
	<input type="hidden" name="boardbeginday" value="${bean.boardbeginday }">
	<input type="hidden" name="boardendday" value="${bean.boardendday }">
	<input type="hidden" name="boardsize" value="${bean.boardsize }">
	<input type="hidden" name="product_boardno" value="${bean.product_boardno }">
	<input type="hidden" name="product_boardname" value="${bean.product_boardname }">
	<input type="hidden" name="product_boardprice" value="${b_total }">
	
		<p>
			비회원 전화번호 예약 : <input type="text" name="memberphone" size="10"><br><br>
			비밀 번호 : <input type="password" name="memberpass" size="10"> <br><br><br>
			
	<!-- 		<div class="back">
    <div class="button_base b08_3d_pushback" onclick="location.href='BoardclothOrder.do'">
        <div>예약하기</div>
        <div>예약하기</div>
    </div>
</div> -->


			<button class="button button5" onclick="submit()">예 약 하 기
			</button>
		
	</center>
	
</form> 

</body>
</html>