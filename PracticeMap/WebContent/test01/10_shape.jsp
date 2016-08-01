<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Google Maps API - shape</title>
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
		<h1>shape (도형 그리기)</h1>
		<button onclick="createPoliline()">폴리라인 추가</button><br>
		<button onclick="removePoliline()">폴리라인 제거</button><br><br>
		<button onclick="createPoligon()">폴리곤 추가</button><br>
		<button onclick="removePolilgon()">폴리곤 제거</button><br><br>
		<button onclick="createRect()">사각형 추가</button><br>
		<button onclick="removeRect()">사각형 제거</button><br><br>
		<button onclick="createCircle()">원 추가</button><br>
		<button onclick="removeCircle()">원 제거</button><br>
		<a href="https://developers.google.com/maps/documentation/javascript/examples/circle-simple">
			ex) 인구수 많큼 원형으로 표시
		</a>
	</div>

	<!-- Google Map API -->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=api키값&callback=initMap"
		async defer></script>
		
	<script>
		var map;
		var marker;
		var line;
		var triangle;
		var rectangle;
		var complext_polilines;
		var circle;
		var seoul_latlng = {lat : 37.541, lng : 126.986};
		function initMap() {
			map = new google.maps.Map(document.getElementById('map'), {
				zoom : 12,
				center : seoul_latlng
			});
			
			complext_polilines = new google.maps.Polyline({
			    strokeColor: '#000000',
			    strokeOpacity: 1.0,
			    strokeWeight: 3
			});
			complext_polilines.setMap(map);

			// 클릭이벤트 추가
			map.addListener('click', addLatLng);
		}
		
		// ex) 거리 길이 재기...
		function addLatLng(event) {
			var path = complext_polilines.getPath();
			
			// 클릭된 지점의 좌표를 추가
			path.push(event.latLng);

			// 새로운 마커 추가
			var marker = new google.maps.Marker({
				position: event.latLng,
				title: '#' + path.getLength(),
				map: map
			});
		}
		
		function createPoliline() {
			var lineCoordinates = [
	            {lat : 37.520, lng : 126.986},
	            {lat : 37.541, lng : 126.960}
            ];
			
			line = new google.maps.Polyline({
			    path: lineCoordinates,
			    geodesic: true,
			    strokeColor: '#FF0000',		// 선 색상
			    strokeOpacity: 1.0,			// 불투명도
			    strokeWeight: 2				// 선 두께
			});
			
			line.setMap(map);
		}
		
		function removePoliline() {
			line.setMap(null);
		}
		
		function createPoligon() {
			var triangleCoords = [
				{lat : 37.541, lng : 126.986},
				{lat : 37.520, lng : 126.986},
				{lat : 37.520, lng : 126.960}
			];
			
			triangle = new google.maps.Polygon({
			    paths: triangleCoords,
			    strokeColor: '#FF0000',
			    strokeOpacity: 0.8,
			    strokeWeight: 2,
			    fillColor: '#FF0000',
			    fillOpacity: 0.35
			});
			triangle.setMap(map);
		}
		
		function removePolilgon() {
			triangle.setMap(null);
		}
		
		function createRect() {
			 rectangle = new google.maps.Rectangle({
			strokeColor: '#FF0000',
			strokeOpacity: 0.8,
			strokeWeight: 2,
			fillColor: '#FF0000',
			fillOpacity: 0.35,
			map: map,				// 맵에 바로 추가
			bounds: {
					north: 37.500,
					south: 37.541,
					east: 127.000,
					west: 126.986
				}
			// bounds: map.getBounds()		// 지도 전체
			});
		}
		
		function removeRect() {
			rectangle.setMap(null);
		}
		
		function createCircle() {
			circle = new google.maps.Circle({
			      strokeColor: '#FF0000',
			      strokeOpacity: 0.8,
			      strokeWeight: 2,
			      fillColor: '#FF0000',
			      fillOpacity: 0.35,
			      map: map,
			      center: seoul_latlng,
			      radius: 1000
			 });
		}
		
		function removeCircle() {
			circle.setMap(null);
		}
	</script>
</body>
</html>