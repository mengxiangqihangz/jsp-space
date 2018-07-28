<%@page import="java.util.Random"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%="JSP表达式(输出表达式)" %><br>
	Current Time:<%=new Date() %><br>
	0到10之间的随机数：<%=Math.random()*10 %>
	<br><br><br><br>
	
	<%="JSP的Scriptlet" %><br>
	<%
	for(int i=0; i<7;i++){
		out.print("<font size='"+i+"'>");
	%>
	疯狂Java训练营(Wild Java Camp)</font>
	<br/>
	<%
	}
	%>
	
	<br><br><br><br>
	<%="JSP的声明" %>
	<%!
	public int count;
	public String info(){
		return "Hello"+count++;
	}
	%>
	<%="JSP表达式输出： "%>  <%=count %><br>
	<%="JSP的Scriptlet输出： "%> <%out.println(count); %><br>
	<%="JSP表达式输出info()： "%>  <%=info() %><br>
</body>
</html>