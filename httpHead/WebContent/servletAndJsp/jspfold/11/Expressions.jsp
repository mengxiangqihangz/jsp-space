<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 表达式</title>
</head>
<body>
	<h2>JSP Expressions</h2>
	<ul>
		<li>Current time: <%= new Date() %></li>
		<li>Server: <%= application.getServerInfo() %></li>
		<li>Session ID: <%= session.getId() %></li>
		<li>The <code> testParam </code> from Parameter: <%= request.getParameter("testParam") %></li>
	</ul>
	
</body>
</html>