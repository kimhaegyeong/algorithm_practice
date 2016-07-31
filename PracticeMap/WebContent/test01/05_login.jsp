<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
			<h1>로그인 했을때, 사용자의 위치에 따라 </h1>
			<p>로그인하면 지도가 쿠키를 설정함</p>
		</div>
		
	    <script>
	    	var map;
			function initMap() {
			    map = new google.maps.Map(document.getElementById('map'), {
			      center: {lat: -34.397, lng: 150.644},			// 지도의 중앙 좌표
			      zoom: 8,										// 줌 단계
			    });
			}
			
	    </script>
	    
	    <!-- Google Map API -->
	    <script src="https://maps.googleapis.com/maps/api/js?key=api키값&callback=initMap&signed_in=true"
	    async defer></script>
	    <!-- 
	    	&signed_in=true
	    	생성된 지도에서 로그인을 활성화
	     -->
	</body>
</html>