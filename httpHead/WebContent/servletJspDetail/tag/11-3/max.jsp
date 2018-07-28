<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/tld/mytaglib"  prefix="my" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>带属性 自定义标签的测试</title>
</head>
<body>
<!-- http://localhost:8080/httpHead/servletJspDetail/tag/11-3/max.jsp?num1=10&num2=13 -->

	<%
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
	%>
	最大值是：<my:max num2="<%=num1 %>" num1="<%=num2 %>"/><br/>
	<%=num1 %>
</body>
</html>