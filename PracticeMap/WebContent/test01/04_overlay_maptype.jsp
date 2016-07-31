<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Google Maps API - overlay map type </title>
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
			<h1>오버레이 지도 유형</h1>
			<p>사용예: 교통상황, 뭐 등등...</p>
		</div>
		
	    <script>
	    	// 생성자
	    	function CoordMapType(tileSize) {
	    		this.tileSize = tileSize;
	    	}
	    	
	    	
	    	CoordMapType.prototype.getTile = function(coord, zoom, ownerDocument) {
	    		  var div = ownerDocument.createElement('div');
	    		  div.innerHTML = coord;
	    		  div.style.width = this.tileSize.width + 'px';
	    		  div.style.height = this.tileSize.height + 'px';
	    		  div.style.fontSize = '10';
	    		  div.style.borderStyle = 'solid';
	    		  div.style.borderWidth = '1px';
	    		  div.style.borderColor = '#AAAAAA';
	    		  return div;
	    	};
	    
	    	var map;
			function initMap() {
			    map = new google.maps.Map(document.getElementById('map'), {
			      center: {lat: -34.397, lng: 150.644},			// 지도의 중앙 좌표
			      zoom: 8,										// 줌 단계
			    });
			}
			
			// 오버레이할 맵 추가
			// 보이는 지도화면에서 높이, 너비가 256px인 타일들을 오버레이할 대상으로 추가
		   	map.overlayMapTypes.insertAt(
		      	0, new CoordMapType(new google.maps.Size(256, 256)));
	    </script>
	    
	    <!-- Google Map API -->
	    <script src="https://maps.googleapis.com/maps/api/js?key=api값&callback=initMap"
	    async defer></script>
	</body>
</html>