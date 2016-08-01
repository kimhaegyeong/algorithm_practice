<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Google Maps API - 인포윈도우</title>
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
		<h1>인포윈도우</h1>
		<button onclick="closeINfoWindow()">정보창 닫기</button>	
		<button onclick="moveInfoWindow()">정보창 이동</button>
	</div>

	<!-- Google Map API -->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=api키값&callback=initMap"
		async defer></script>
		
	<script>
		var map;
		var marker;
		var infowindow;
		var seoul_latlng = {lat : 37.541, lng : 126.986};
		function initMap() {
			map = new google.maps.Map(document.getElementById('map'), {
				zoom : 12,
				center : seoul_latlng
			});
			
			marker = new google.maps.Marker({
			    position: seoul_latlng,
			    map: map, 
			});
		
			// 인포윈도우 내용
			 var contentString = '<div id="content">'
		      	+	'<h1>제목</h1>'
		      	+	'<p><b>컨텐츠 내용</b></p>'
		      	+	'<p><b>현재 - maxWidth: 200</b><br>'
		      	+	'maxWidth는 정보 창의 최대 너비를 픽셀 단위로 지정합니다.'
		      	+	' 기본적으로, 정보 창은 콘텐츠에 맞게 확장되고 정보 창이 지도를 채울 경우 '
		      	+	'텍스트를 자동 줄바꿈합니다. maxWidth를 추가하면 정보 창이 지정된 너비로 '
		      	+	'강제로 자동 래핑합니다. 정보 창이 최대 너비에 도달하고 화면에서 세로 방향에 여유가 있으면, '
		      	+	'정보 창이 세로로 확장될 수 있습니다.</p>'
		      	+	'</div>';
	
				infowindow = new google.maps.InfoWindow({
				content: contentString,					// 정보창에 표시될 텍스트, DOM노드 포함
				maxWidth: 200							// 정보 창의 최대 너비를 픽셀 단위로 지정
			});
			
			marker.addListener('click', function() {	// 마커 클릭시
			  	infowindow.open(map, marker);			// 인포윈도우 열림
			});
		}
		
		function closeINfoWindow() {
			infowindow.close();
		}
		
		function moveInfoWindow() {
			infowindow.setPosition({lat : 37.530, lng : 126.970});
		}
		
	</script>
</body>
</html>