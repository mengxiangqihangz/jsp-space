<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/tld/mytaglib" prefix="my" %>
  	<%-- <%@ taglib uri="/tltag" prefix="my" %> --%>
   	<%! int size = 3; %> 
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>jsp输出body测试 </title>
	</head>
	<body>
		<my:greet>
			
			<font size=<%=size++ %> color=blue >
				欢迎来到德莱联盟
			</font><br>
			<%
				if(size>5) size = 3;
			%>
		</my:greet>
	</body>
	</html>
	