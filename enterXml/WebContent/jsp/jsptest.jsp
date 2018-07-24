<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>jsp实现验证</title>
</head>
<body>
	<%
	String name=request.getParameter("user");
	String pwd=request.getParameter("userpass");
	%>
	<td><%=name %></td>
	<td><%=pwd %></td>

</body>
</html>