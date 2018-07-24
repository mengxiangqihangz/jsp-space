<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		String username=(String)session.getAttribute("name");
    	Date userbirthday=(Date)session.getAttribute("birthday");
		
	%>
	<h2>姓名： <%=username%> </h2>
	<h1>生日： <%=userbirthday %></h1>
</body>
</html>