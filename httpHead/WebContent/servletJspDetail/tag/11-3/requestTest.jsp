<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发送请求表单页面</title>
</head>
<body>

	<!-- http://localhost:8080/httpHead/servletJspDetail/tag/11-3/requestTest.jsp -->
	<form action="switch.jsp" method="post" >
		<input type="text" id="pname" name="pname">
		<input type="submit" value="提交"> 
	</form>
<%-- 	<%
		request.setAttribute("pname", "zhangsan");
		request.getRequestDispatcher("switch.jsp").forward(request,response);
	%> --%>
<%-- 	<jsp:forward page="switch.jsp">
		<jsp:param value="zhangsan" name="pname"/>
	</jsp:forward> --%>
</body>
</html>