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
		<button onclick="removeMarker()">마커 제거</button>
		마커를 삭제하지 않는다. 단지 지도(화면)에서 마커를 제거할 뿐이다. <br>
		<button onclick="showMarker()">마커 다시 보기</button><br>
		<button onclick="deleteMarker()">마커 삭제</button>
		마커를 삭제하고 나서는, 마커 제거하기, 마커 다시 보기를 할 수 없다<br><br>
		<button onclick="stopBounceMarker()">바운스하는 마커 멈추기</button><br>
			
	</div>

	<script>
		var map;
		var marker = [];
		function initMap() {
			map = new google.maps.Map(document.getElementById('map'), {
				zoom : 12,
				center : {lat : 37.541, lng : 126.986}
			});
			
			// 1. map 객체를 지정하여 마커 추가
			marker[0] = new google.maps.Marker({
			    position: {lat : 37.541, lng : 126.986},
			    map: map,
			    draggable: true,							// 드래그 가능
			    animation: google.maps.Animation.DROP,		// 애니메이션 : 위에서 아래로 떨어지는 모션
			    title: 'Hello World1111!'
			});
			
			// 2. 마커 객체 생성후, map 객체에 추가
			marker[1] = new google.maps.Marker({
			    position: {lat : 37.560, lng : 126.986},
			    title:"Hello World2222!",
			    animation: google.maps.Animation.BOUNCE,	// 마커가 통통 튀오름, null값이 될 때까지 반복
			    icon: // 마커 이미지 사용
			    	{
			    	  url: "http://icons.iconarchive.com/icons/designbolts/free-multimedia/256/iMac-icon.png", 
			    	  size: new google.maps.Size(71, 71),
			    	  origin: new google.maps.Point(0, 0),
			    	  anchor: new google.maps.Point(17, 34),
			    	  scaledSize: new google.maps.Size(25, 25)
			    	}
			});

			marker[1].setMap(map);
		}
		
		function removeMarker() {
			marker[1].setMap(null);
		}
		
		function showMarker() {
			marker[1].setMap(map);
		}
		
		function deleteMarker() {
			marker[1] = null;
		}
		
		function stopBounceMarker() {
			marker[1].setAnimation(null);
		}
	</script>

	<!-- Google Map API -->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=api키값&callback=initMap"
		async defer></script>
</body>
</html>