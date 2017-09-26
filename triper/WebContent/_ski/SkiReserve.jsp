<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/button.css">
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
<form action="SkiOrder.do" method="post"> 
	<center>

		<table>
<tr>
<td><img src="img/${bean.product_skiimg }" width="300" height="300"></td>
</tr>
			<tr>
				<td align="center">총 비 용 : ${s_total } 원</td>
				
			</tr>
			<tr>
			<td align="center">대 여 일 :${bean.skibeginday }</td>
			</tr>
			<tr>
			<td align="center">반 납 일 :${bean.skiendday }</td>
			</tr>
			<tr>
			<td align="center">사 이 즈 :${bean.skisize }</td>
			</tr>
		</table>
	<input type="hidden" name="product_skiimg" value="${bean.product_skiimg }">
	<input type="hidden" name="skibeginday" value="${bean.skibeginday }">
	<input type="hidden" name="skiendday" value="${bean.skiendday }">
	<input type="hidden" name="skisize" value="${bean.skisize }">
	<input type="hidden" name="product_skino" value="${bean.product_skino }">
	<input type="hidden" name="product_skiname" value="${bean.product_skiname }">
	<input type="hidden" name="product_skiprice" value="${s_total }">
	
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