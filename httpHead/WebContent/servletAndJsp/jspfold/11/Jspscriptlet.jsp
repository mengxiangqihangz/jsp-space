<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JspScriptletTest</title>
</head>
<%
String bgColor = request.getParameter("bgColor");
if(bgColor==null||bgColor.trim().equals("")){
	bgColor = "green";
}
%>
<body bgcolor="<%=bgColor %>" >
	<h2 align="center">Testing a BackGround of <%=bgColor %> </h2>
</body>
<br><br>
<br><br><br><br><br>
<!-- 了解这两者之间的区别 -->
<%-- 
<%
int i = 0;
%> 
--%>
<%!
int i = 0;
%>

<%for(; i<10 ; i++){ %>
	<%
	if(Math.random()<0.5){
	%>
	<h3>Have a <i>nice</i>day!<%="---"+i %></h3>
	<% } else { %>
	<h3>Have a <i>lousy</i>day!<%="---"+i %></h3>
	<% } 
}
%>

<%-- 
这种还不如写
out.print("<h3>Have a <i>nice</i>day!<%="---"+i %></h3>"); 
--%>

</html>