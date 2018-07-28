<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 声明语句</title>
</head>
<body>
	<%!
	private String randomHeading(){
		return (Math.random()+"");
	}
	%>
	<br><br><br><br>
	<center>
	<h2>生成的随机数为：<%=randomHeading() %></h2>
	</center>
</body>
</html>