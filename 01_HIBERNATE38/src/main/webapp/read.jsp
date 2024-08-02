<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.util.*" %>
	<%@ page import="model.Student" %>
	
	<% @SuppressWarnings("unchecked") List<Student> slist = (List<Student>)request.getAttribute("students"); %>
	<table border="1">
		<tr>
			<th>Student ID</th>
			<th>Student Name</th>
			<th>Department</th>
		</tr>
		
		<% for(Student s : slist){ %>
		<tr>
			<td><%= s.getSid() %></td>
			<td><%= s.getSname() %></td>
			<td><%= s.getSdept() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>