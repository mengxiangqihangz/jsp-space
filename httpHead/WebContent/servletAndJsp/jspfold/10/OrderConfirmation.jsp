<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Confirmation</title>

</head>
<body>

<jsp:useBean id="p1" class="lee.Person" scope="application" />
<jsp:setProperty property="title" name="p1" value="Core Servlets and JavaServer Pages"/>

	<h2>Order Confirmation</h2>
	Thanks for ordering<i><%=request.getParameter("title") %></i>
	
</body>
</html>