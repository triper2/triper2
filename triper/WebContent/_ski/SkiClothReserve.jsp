<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/button.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="SkiClothorder.do" method="post"> 
	<center>

		<table>
<tr>
<td><img src="img/${bean.product_skiclothimg }" width="300" height="300"></td>
</tr>
			<tr>
				<td align="center">총 비 용 : ${total } 원</td>
				
			</tr>
			<tr>
			<td align="center">대 여 일 :${bean.skiclothbeginday }</td>
			</tr>
			<tr>
			<td align="center">반 납 일 :${bean.skiclothendday }</td>
			</tr>
			<tr>
			<td align="center">사 이 즈 :${bean.skiclothsize }</td>
			</tr>
		</table>
	<input type="hidden" name="product_skiclothimg" value="${bean.product_skiclothimg }">
	<input type="hidden" name="skiclothbeginday" value="${bean.skiclothbeginday }">
	<input type="hidden" name="skiclothendday" value="${bean.skiclothendday }">
	<input type="hidden" name="skiclothsize" value="${bean.skiclothsize }">
	<input type="hidden" name="product_skiclothno" value="${bean.product_skiclothno }">
	<input type="hidden" name="product_skiclothname" value="${bean.product_skiclothname }">
	<input type="hidden" name="product_skiclothprice" value="${bean.product_skiclothprice }">
	
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