<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Google Maps API - map type</title>
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
		<h1>스타일 지정</h1>
		<ul>
			<li>지도의 MapOptions 객체에서 .styles 속성을 설정</li>
			<li>StyledMapType을 생성, 정의하고 지도에 적용<br><br></li>
			<li>
				<button onclick='changePosition("Brooklyn")'>브루클린</button> 된다
			</li>
			<li>
				<button onclick='changePosition("Seoul")'>서울</button> 안된다!!!
			</li>
			
		</ul>
	</div>

	<script>
		var map;
		function initMap() {
			var customMapType = new google.maps.StyledMapType([ {
				stylers : [ {
					hue : '#890000'
				}, {
					visibility : 'simplified'
				}, {
					gamma : 0.5
				}, {
					weight : 0.5
				} ]
			}, {
				elementType : 'labels',
				stylers : [ {
					visibility : 'off'
				} ]
			}, {
				featureType : 'water',
				stylers : [ {
					color : '#890000'
				} ]
			} ], {
				name : 'Custom Style'
			});
			var customMapTypeId = 'custom_style';

			map = new google.maps.Map(document.getElementById('map'), {
				zoom : 12,
				center : {
					lat : 40.674,
					lng : -73.946
				}, // Brooklyn.
				mapTypeControlOptions : {
					mapTypeIds : [ google.maps.MapTypeId.ROADMAP,
							customMapTypeId ]
				}
			});

			map.mapTypes.set(customMapTypeId, customMapType);
			map.setMapTypeId(customMapTypeId);
		}
		
		function changePosition(location) {
			if (location == "Brooklyn") {
				map.setCenter({lat : 40.674, lng : -73.946});
			} else if (location == "Seoul") {
				map.setCenter({lat : 37.541, lng : 126.986});
			}
		}
	</script>

	<!-- Google Map API -->
	<script src="https://maps.googleapis.com/maps/api/js?key=api키값&callback=initMap&signed_in=true"
		async defer></script>
</body>
</html>