// url 에 따른 페이지 구분

// 모듈을 추출한다.
var http = require('http');
var fs = require('fs');
var url = require('url');

// 서버를 생성 및 실행한다.
http.createServer(function(request, response) {

	// 변수를 선언한다.
	var pathname = url.parse(request.url).pathname;

	// 페이지를 구분한다.
	if (pathname == '/') {

		// index.html 파일을 읽는다.
		fs.readFile('index.html', function(error, data) {

			// 응답
			response.writeHead(200, {
				'Content-Type' : 'text/html'
			});
			response.end(data);
		})
	} else if (pathname == '/other_page') {
		// index.html 파일을 읽는다.
		fs.readFile('other_page.html', function(error, data) {

			// 응답
			response.writeHead(200, {
				'Content-Type' : 'text/html'
			});
			response.end(data);
		})
	}
}).listen(5522, function() {
	console.log('Server Running at http://127.0.0.1:5522');
})