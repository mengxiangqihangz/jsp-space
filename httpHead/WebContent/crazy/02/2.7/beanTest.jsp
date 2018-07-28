<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     <%@ page import="lee.Person.class" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java Bean测试</title>
</head>
<body>
	<jsp:useBean id="p1" class="lee.Person" scope="application" />
	<jsp:setProperty property="name" name="p1" value="wawa"/>
	<jsp:setProperty property="age" name="p1" value="22"/>
	
	<jsp:getProperty property="name" name="p1"/>
	<jsp:getProperty property="age" name="p1"/>
</body>
</html>