<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>application 测试</title>
</head>
<body>
	<%!int i; 
		// page
		// pageContext
		// session
		// applicatio 不能使用
	
	%>
	
	<%
		// request
		// response
		// config
		// out
		// page
		// pageContext
		// session
		application.setAttribute("counter", String.valueOf(++i)); 
	%>
	<%=application.getAttribute("counter") %>	
</body>
</html>