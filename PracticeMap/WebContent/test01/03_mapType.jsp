<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> <!-- 애플리케이션 선언시 HTML5로 사용해야 한다 -->
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Google Maps API - map type </title>
		<style>
			.mapType {
				width: 400px;
				height: 400px;
				float: left;
			}
		</style>
	</head>
	<body>
		<div id="map" class="mapType"></div>
		<div>
			<h1>Google Maps API에서 지도 유형</h1>
			<button onclick="changeMapType('ROADMAP')">ROADMAP</button>
			MapTypeId.ROADMAP는 기본 도로 지도 뷰를 표시합니다. 기본 지도 유형입니다.<br>
			<button onclick="changeMapType('SATELLITE')">SATELLITE</button>
			MapTypeId.SATELLITE은 Google Earth 위성 이미지를 표시합니다.<br>
			<button onclick="changeMapType('HYBRID')">HYBRID</button>
			MapTypeId.HYBRID는 일반 및 위성 뷰를 섞어서 표시합니다.<br>
			<button onclick="changeMapType('TERRAIN')">TERRAIN</button>
			MapTypeId.TERRAIN은 지형 정보를 기반으로 실제 지도를 표시합니다.<br>
			<br>			
			<br>
			SATELLITE, HYBRID 유형은 높은 확대/축소 수준에서 45° 이미지가 존재할 때 이를 지원한다.
			45° 활성화, 45° 비활성화, 45° 이미지 회전 - 홈페이지 참조	
			<br>
		</div>
		
	    <script>
	    	var map;
			function initMap() {
			    map = new google.maps.Map(document.getElementById('map'), {
			      center: {lat: -34.397, lng: 150.644},			// 지도의 중앙 좌표
			      zoom: 8,										// 줌 단계
			      mapTypeId: google.maps.MapTypeId.ROADMAP
			    });
			}
			
			function changeMapType(mapType) {
				map.setMapTypeId(eval("google.maps.MapTypeId. " + mapType));	
			}
	
	    </script>
	    
	    <!-- Google Map API -->
	    <script src="https://maps.googleapis.com/maps/api/js?key=api키값&callback=initMap"
	    async defer></script>
	</body>
</html>