<%@ page import="com.zdy.cn.model.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,java.text.*"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="u" uri="/showUser" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function show(){
		alert("${empty name?'还未登陆':name}")
	}
</script>
</head>
<body>
	<%
		Date nowTime=new Date();
		pageContext.setAttribute("nowTime", nowTime);
		UserInfo user=new UserInfo();
		user.setName("张三");
		user.setAge(28);
		user.setSex("男");
		pageContext.setAttribute("user", user);
	%>
	<f:formatNumber value="123456789.2356" pattern="##,###.00"></f:formatNumber>
	<f:formatDate value="${nowTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	<u:showUserInfo user="${user}"/>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
		<font size="6"><b>个人用户登录</b></font><br/> 
		<br/>				
		<form  method="post" action="">
			<b>用户名：</b><input type="text" id="username" name="user" onblur="show()"><input type="button" value="姓名验证"></font><br/> 				
			<br/>				
			<b>密&nbsp;码: </b><input type="password" id="pwd" name="userpass" ><br/> 	
			<br/>
			<input type="checkbox" name="usercheck" ><b>记住我的登录状态</b><br/> 
			<br/>
			<input type="submit" value="登录"/>
			<input type="reset"  value="重置"/>
		
		</form>
</body>
</html>