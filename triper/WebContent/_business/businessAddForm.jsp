<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html>
<html>
<head>

<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title> Triper </title>
</head>
<script type="text/javascript">
	
</script>
<body>
	<jsp:include page="../_command/loginChecker.jsp?page=businessAdd"></jsp:include>
	<jsp:include page="../_main_login/header.jsp"></jsp:include>
	<form action="../_business/add.business" method="post">
		<div align="center" style="margin: 50px">
			<div id="map" style="width: 100%; height: 350px;"></div>
			<table>
				<div id="map" style="width: 100%; margin-top: 10px"></div>
				<tr>
					<th>상호명</th>
					<td>${param.business_name}</td>
				</tr>
				<tr>
					<th>사업장 소재지</th>
					<c:if test="${param.business_road_address!=''}">
						<td>${param.business_road_address}</td>
					</c:if>
					<c:if test="${param.business_road_address==''}">
						<td>${param.business_address}</td>
					</c:if>
				</tr>
				<tr>
					<th>사업장 전화번호</th>
					<td>${param.business_tel}</td>
				</tr>
				<tr>
					<th>사업자명</th>
					<td>${sessionScope.dto.member_name}</td>
				</tr>
				<tr>
					<th>사업자 번호</th>
					<td><input name="business_id" placeholder=" ex) 123-45-67890"></td>
				</tr>
				<tr>
					<th>카테고리</th>
					<td><input type="radio" name="business_category" value="ski">ski
						<input type="radio" name="business_category" value="car">car
					</td>
				</tr>
			</table>
		</div>
		<input name="business_name" type="hidden" value="${param.business_name}">
		<input name="business_road_address" type="hidden" value="${param.business_road_address}">
		<input name="business_address" type="hidden" value="${param.business_address}">
		<input name="business_tel" type="hidden" value="${param.business_tel}">
		<input name="member_id" type="hidden" value="${sessionScope.dto.member_id}">
		<input name="business_x" type="hidden" value="${param.business_x}">
		<input name="business_y" type="hidden" value="${param.business_y}">

		<input type="submit" value="등록">
		<!-- action="Add.Business" method="post" -->
		<input type="button" onclick="window.history.back();" value="취소">
	</form>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=12ba5c4ca6e1aac52bb842339c2596da"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new daum.maps.LatLng(parseFloat("${param.business_y}"),
					parseFloat("${param.business_x}")), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};
		var map = new daum.maps.Map(mapContainer, mapOption);

		// 마커가 표시될 위치입니다 
		var markerPosition = new daum.maps.LatLng(
				parseFloat("${param.business_y}"),
				parseFloat("${param.business_x}"));

		// 마커를 생성합니다
		var marker = new daum.maps.Marker({
			position : markerPosition
		});

		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);

		var iwContent = // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		'<div style="margin-top: 15px" class="info">'
				+ '<h5>${param.business_name}</h5>'
				+ '<span>${param.business_address}</span><br>'
				+ '<span class="tel">${param.business_tel}</span>'
				+ '<br><br><br></div>',

		iwPosition = new daum.maps.LatLng(parseFloat("${param.business_y}"),
				parseFloat("${param.business_x}")); //인포윈도우 표시 위치입니다

		// 인포윈도우를 생성합니다
		var infowindow = new daum.maps.InfoWindow({
			position : iwPosition,
			content : iwContent
		});

		// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
		infowindow.open(map, marker);
		map.setZoomable(false);
		map.setDraggable(false);
	</script>
</body>
</html>