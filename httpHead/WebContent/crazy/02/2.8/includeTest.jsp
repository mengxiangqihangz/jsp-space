<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>include page</title>
</head>
<body>
	
	<%-- <%!
		String pname = "zhangsan";
	%>
	<%
		request.setAttribute("pname", "lisi");
	%> --%>
	<%=request.getAttribute("pname") %>
	
	<jsp:include page="forward-result.jsp">
		<jsp:param value="32" name="age"/>
	</jsp:include>

</body>
</html>