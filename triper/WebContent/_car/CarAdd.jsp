<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>
.button2 {
    background-color: blue; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
.button2 {border-radius: 4px;}
</style>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>
<jsp:include page="../_main_login/header.jsp"></jsp:include>
	<div class="w3-container w3-blue">
		<h2>차량 등록 하기<button class="button button2" style="float: right;" onclick="location.href='CarMain.jsp'">되돌아가기</button></h2>
	
	</div>

	<form class="w3-container" action="../_car/CarAddController.do" method="post" encType="multipart/form-data" style="text-align: left;">
	
		<p>
			<label>차량 번호</label> <input class="w3-input" type="text" name="product_carno" placeholder="숫자만 입력하세요">
		</p>
		<p>
			<label>차량 이름</label> <input class="w3-input" type="text" name= "product_carname">
		</p>
		<p>
			<label>차량 회사</label> <input class="w3-input" type="text" name= "product_carcompany">
		</p>
		<p>
			<label>차량 가격</label> <input class="w3-input" type="text" name= "product_carprice" placeholder="숫자만 입력하세요">
		</p>
		<p>
			<label>차량 인원 수</label> <input class="w3-input" type="text" name= "product_carusepeople" placeholder="숫자만 입력하세요">
		</p>
		<p>
			<label>차량 정보</label> <input class="w3-input" type="text" name= "product_carinfo">
		</p>
		<p>
			<label>차량 이미지</label> <input class="w3-input" type="file" name= "product_carimg">
		</p>
		<p>
			<label>차량 분류</label><br><br>
		
		<input class="w3-radio" type="radio" name="product_carcategory" value="Small"
			checked> <label>소 형</label> <input class="w3-radio"
			type="radio" name="product_carcategory" value="Mid"> <label>중 형</label>

		<input class="w3-radio" type="radio" name="product_carcategory" value="Big">
		<label>대 형</label>
		</p>
		
	<div class="w3-panel">
	
  			<button class="w3-btn w3-block" ><font color="#003399" size="5" onclick="submit()">등 록 하 기</font> </button>
	</div>
	</form>

</body>
</html>
