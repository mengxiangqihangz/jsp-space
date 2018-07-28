<%@page import="com.zdy.cn.model.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,java.text.*"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="u" uri="/showUser" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function show(){
		alert("${empty name?'还未登录':name}");
	}
</script>
</head>
<body>
	<%
		Date nowTime = new Date();
		pageContext.setAttribute("nowTime", nowTime);
		UserInfo user = new UserInfo();
		user.setName("张三");
		user.setAge(22);
		user.setSex("男");
		pageContext.setAttribute("user", user);
	%>
	<f:formatNumber value="123456789.2356" pattern="##,###.00"></f:formatNumber>
	<f:formatDate value="${nowTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	<u:showUserInfo user="${user}"/>
	<%-- <%
		List list = new ArrayList();
		list.add("张三");
		list.add("李四");
		list.add("王五");
		list.add("赵六");
		pageContext.setAttribute("array", list);
		pageContext.setAttribute("str", "a,b,c,d,e,f,g");
	%>
	<c:forEach items="${array}" var="name">
		<c:out value="${name}"></c:out>
	</c:forEach>
	<c:forTokens items="${str}" delims="," var="ch">
		<c:out value="${ch}"></c:out>
	</c:forTokens> --%>
	
	<%-- <c:set var="name2" value="张三"></c:set>
	
	<c:if test="${name2=='张三' }">
		<c:out value="李四"></c:out>
	</c:if> --%>
	<form method="post" action="/testweb/login">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="userName" onblur="show();"/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="pwd"/></td>
			</tr>
			<tr>
				<td><input type="reset" value="重置"/></td>
				<td><input type="submit" value="登录"/></td>
			</tr>
		</table>
	</form>
	
</body>
</html>