<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comparing Apples and Oranges</title>
</head>
<body>
	<center>
	<h2>Comparing Apples and Oranges</h2>
	<%
	response.setContentType("application/vnd.ms-excel");
	%>
	<table border=1>
		<tr><th></th>					<th>Apples</th><th>Oranges</th>
		<tr><th>First Quarter</th>		<td>2307<td>4706
		<tr><th>Second Quarter</th>		<td>2982<td>5104
		<tr><th>Third Quarter</th>		<td>3011<td>5520
		<tr><th>Fourth Quarter</th>		<td>3055<td>5287
	</table>
	
	</center>
</body>
</html>