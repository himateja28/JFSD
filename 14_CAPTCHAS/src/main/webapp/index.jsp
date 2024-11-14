<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="loadCaptcha()">
	<h1>Generate captcha</h1>
	<img id="cpatcha" alt="error" src="data:image/png;base64," />
</body>
<script>
//CallApi
function callApi(method, url, data, responseHandler) {
  var options;
  if(method == "GET" || method == "DELETE")
    options = {method: method, headers:{'Content-Type':'application/json'}};
  else
    options = {method: method, headers:{'Content-Type':'application/json'}, body: data};
  fetch(url, options)
    .then(response => {
      if(!response.ok)
        throw new Error(response.status + ":" + response.statusText);
      return response.text();
    })
    .then(data => responseHandler(data))
    .catch(error => alert(error));
}
function loadCaptcha(){
var url="http://localhost:8080/captcha/getcaptcha/4";
callApi("GET",url,"",getCaptcha);
}
function getCaptcha(res){
	cpatcha.src+=res;
}
</script>
</html>