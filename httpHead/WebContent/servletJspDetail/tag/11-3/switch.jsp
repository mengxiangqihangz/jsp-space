<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/tld/mytaglib" prefix="my" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>switch 测试</title>
</head>
<body>
<!-- http://localhost:8080/httpHead/servletJspDetail/tag/11-3/switch.jsp? pname=zhangsan -->
	<%
		String name = request.getParameter("pname");
		out.println("输入的name为："+name);
		//name = "aa";
	%>
	<br><br>
	<my:switch>
 		<my:case cond="<%=\"zhangsan\".equalsIgnoreCase(name) %>">
			<%out.println(name+" is manager!"); %>
		</my:case>
		<my:case cond="<%=\"lisi\".equalsIgnoreCase(name) %>">
			<%out.println(name+" is saleman!"); %>
		</my:case>
		<my:dafault>
			<%out.println(name+" is emploee!"); %>
		</my:dafault>
	</my:switch>
	
</body>
</html>