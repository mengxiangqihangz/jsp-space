<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	欢迎学习Java Web,现在的时间是：<%out.print(new Date()); %>
	<br><br><br><br>
	
	<%
	for(int i=0; i<7;i++){
		out.print("<font size='"+i+"'>");
	%>
	疯狂Java训练营(Wild Java Camp)</font>
	<br/>
	<%
	}
	%>
	
	<!-- 增加JSP注释 -->
	<%--JSP注释部分 --%>
	<!-- 增加HTML注释 -->
	<!-- HTML注释部分 -->
</body>
</html>