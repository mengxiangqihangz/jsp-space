<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="mytag"  uri="/tld/mytaglib" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自定义标签示范</title>
</head>
<body bgcolor="#ffffc0" >
	<h2>下面显示的是自定义标签中的内容</h2>
	<mytag:helloWorld/><br>
</body>
</html>
<!-- http://localhost:8080/httpHead/codes/02/2.11/helloWorldTag.jsp -->