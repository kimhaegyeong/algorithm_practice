<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Google Maps API - 마커</title>
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
		<h1>마커</h1>
	</div>

	<!-- Google Map API -->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=api키값&callback=initMap"
		async defer></script>
		
	<script>
		// 마커를 생성했을때, 출력되는 라벨 글자(한 캐릭터씩 출력)
		var labels = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
		var labelIndex = 0;
		
		var map;
		var marker = [];
		function initMap() {
			map = new google.maps.Map(document.getElementById('map'), {
				zoom : 12,
				center : {lat : 37.541, lng : 126.986}
			});
			
			// 클릭한 위치에 마커 추가
			google.maps.event.addListener(map, 'click', function(event) {
			   addMarker(event.latLng, map);
			});
			
		}
		
		function addMarker(location, map) {
			var marker = new google.maps.Marker({
				position: location,
				label: labels[labelIndex++ % labels.length],	// 한 캐릭터씩 라벨에 출력
				map: map
			});
		}
	</script>

	
</body>
</html>