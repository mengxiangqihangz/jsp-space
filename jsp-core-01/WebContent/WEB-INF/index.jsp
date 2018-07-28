<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Map"
    %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<%="success" %>

<!-- 注意int类型的也要加引号，web交由web容器去转。 -->
<!-- jsp动作指令设置的变量并不能直接在jsp页面使用，它并不像声明语句和jsp scriptlet是不一样的
	jsp动作指令增加的变量是 设置到 request对象上的，所以有 scope，可以直接设置到session范围上去。
	而jsp 声明语句或 jsp scriptlet 中新增的变量，只是在生成的 java代码中有效。是成员变量或局部变量。
 -->
<jsp:useBean id="user" class="com.zzl.bean.UserBean" scope="page"></jsp:useBean>
<jsp:setProperty property="name" name="user" value="张三"/>
<jsp:setProperty property="age" name="user" value="27"/>

	<!-- 
	其实就是再jsp页面中将java代码通过jsp脚本包裹起来，标记起来交由web容器去解析 
	-->
	
	<table border="1">
	<!-- if语句 -->
	<%
		Map map = (Map)request.getAttribute("map");
		if(null != map && map.size()>0){
	%>
		<tr>
			<td>项目</td>
			<td>值</td>
		</tr>
		<tr>
			<td><jsp:getProperty property="name" name="user"/></td>
			<td><jsp:getProperty property="age" name="user"/></td>
		</tr>
		
		<!-- for语句 -->
		<%for(Object ob:map.keySet()){%>
			<tr>
				<td><%=ob.toString()%></td>
				<td><%=map.get(ob)%></td>
			</tr>
		<%}%>
	<%}%>
	</table>
		
	<br/><br/><br/><br/><br/><br/>
	<p>下拉列表</p>
	<%
		List list = (List)request.getAttribute("list");
		if(null != list && list.size()>0){
	%>
		<select size="2">
			<%for(int i = 0;i<list.size();i++){ %>
				<option><%=list.get(i) %></option>
			<%} %>
		</select>
	<%} %>	
		
	


</body>
</html>