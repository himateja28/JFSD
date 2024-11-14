<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JFSD</title>
</head>
<body>
	<h2>Employee details</h2>
	<table style="width:100px">
		<tr>
			<td style="width:100px">Employee ID</td>
			<td><input type="text" id="eid"></td>
		</tr>
		<tr>
			<td style="width:100px">Employee Name</td>
			<td><input type="text" id="ename"></td>
		</tr>
		
		<tr>
			<td></td>
			<td>
				<button onclick="save()">Save</button>
				<button onclick="update()">Update</button>
				<button onclick="del()">Delete</button>
				<button onclick="read()">Read</button>
			</td>
		</tr>
		
	</table>
	
	<div style="width:100px" id="elist"></div>
</body>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript">
	function save() {
		var data = JSON.stringify({
			id:eid.value,
			name:ename.value
			});
		
		var url = "http://localhost:8080/10_SPRING/employee/save";
		callApi("POST",url,data,getResponse);
	}
	
	function update() {
		var data = JSON.stringify({
			id:eid.value,
			name:ename.value
			});
		
		var url = "http://localhost:8080/10_SPRING/employee/update";
		callApi("PUT",url,data,getResponse);
	}
	
	function del(){
		var url = "http://localhost:8080/10_SPRING/employee/delete?id="+eid.value;
		callApi("DELETE",url,"",getResponse);
	}
	
	
	function getResponse(response){
		alert(response);
	}
	function read() {
		var url = "http://localhost:8080/10_SPRING/employee/read";
		callApi("GET", url, "", getData);
	}
	function getData(response){
		var data = JSON.parse(response);
		var table = `<table border="1">
						<tr>
							<th>Employee ID</th>
							<th>Employee Name</th>
						</tr>`;
		for(var x in data){
			table += `<tr>
							<td>`+ data[x].id +`</td>
							<td>`+ data[x].name +`</td>
					  </tr>`;
		}
		table += `</table>`;
		elist.innerHTML = table;
	}
</script>
</html>