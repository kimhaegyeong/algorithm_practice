<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> <!-- 애플리케이션 선언시 HTML5로 사용해야 한다 -->
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Google Maps API - create Map</title>
		<style>
			/* 지도가 전체화면에 표시되도록함 */
			html, body {
				height: 100%;
				margin: 0;
				padding: 0;
			}
			#map {
				height: 100%;
			}
		</style>
	</head>
	<body>
		<div id="map"></div>
		
	    <script>
			function initMap() {
				// map 객체를 생성한후 특정한 DOM객체에 표시하도록 한다.
				// center와 zoom은 필수 옵션
			    var map = new google.maps.Map(document.getElementById('map'), {
			      center: {lat: -34.397, lng: 150.644},			// 지도의 중앙 좌표
			      scrollwheel: false,							
			      zoom: 8										// 줌 단계
			    });
			}
	
	    </script>
	    
	    <!-- Google Map API -->
	    <script src="https://maps.googleapis.com/maps/api/js?key=api키값&callback=initMap"
	    async defer></script>c
	    <!-- 
	    	async : Maps API가 로드되는 동안 브라우저의 나머지 웹사이트를 렌더링 할 수 있다
	    	※ async script vs defer script
	    	
	    	동기적으로 API를 로드할 때는,
	    		async 생략, callback 매개변수를 생략한다
	    	(but, 로드 속도가 느려질 수 있다)
	     -->
	     <!-- 
	     	보안상 https를 더 권장함
	      -->
	</body>
</html>