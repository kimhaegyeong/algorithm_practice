/**
 * method 속성
 * get/post 속성에 따른 페이지 구
 */

var http = require('http');

httep.createServer(function (request, response) {
	if (request.method == 'GET') {
		console.log("GET 요청.");
	} else if (request.method == 'POST') {
		console.log("POST 요청.");
	}
}).listen(5522, function() {
	console.log('Server Running at http://127.0.0.1:5522');
})