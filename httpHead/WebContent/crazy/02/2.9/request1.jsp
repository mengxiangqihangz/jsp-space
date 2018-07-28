<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>获取请求头、请求参数</title>
</head>
<body>
	<%
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()){
			String headerName = headerNames.nextElement();
			out.println(headerName+"--->"+request.getHeader(headerName)+"<br>");
			
		}
		out.println("<br>");
		// request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String[] colors = request.getParameterValues("color");
		String national = request.getParameter("country");
	%>
	您的姓名：<%=name %><hr/>
	你的性别：<%=gender %><hr/>
	您喜欢的颜色：
	<%
		for(String co:colors){
			out.print(co+",  ");
		}
	%><hr/>
	您来自的国家：<%=national %><hr/>
</body>
</html>