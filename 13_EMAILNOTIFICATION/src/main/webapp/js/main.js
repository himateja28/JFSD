//CallApi
function  callApi(method, url, data, responseHandler) {
	var options;
	if(method == "GET" || method == "DELETE")
		options = {method: method, headers:{'Content-Type':'application/json'}};
	else
		options = {method: method, headers:{'Content-Type':'application/json'}, body: data};
	fetch(url, options)
		.then(data =>{ responseHandler(data); console.log(data)})
		.catch(error => alert(error));
}