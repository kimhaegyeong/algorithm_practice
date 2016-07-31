<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Google Maps API 시작</title>
	</head>
	<body>
		<!-- width, height 미지정지 지도가 표시되지 않는다 -->
		<div id="map" style="width: 500px; height: 500px"></div>
		
	    <script>
			function initMap() {
				// map 객체를 생성한후 특정한 DOM객체에 표시하도록 한다.
			    var map = new google.maps.Map(document.getElementById('map'), {
			      center: {lat: -34.397, lng: 150.644},			// 지도의 중앙 좌표
			      scrollwheel: false,							
			      zoom: 8										// 줌 단계
			    });
			}
	
	    </script>
	    <script src="https://maps.googleapis.com/maps/api/js?key=api키값&callback=initMap"
	    async defer></script>
	</body>
</html>