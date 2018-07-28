<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     
<%@ page  errorPage="error.jsp" %> 

--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int a = 6;
	int b = 0;
	/* int c = a/b; */
	int c=0;
	%>
	<%=c %>
	<%!
	private int count = 0;
	public int Say(){
		for(int i=0;i<10;i++){
			count++;
		}
		return count;
	}
	%>
	<%
	out.println(Say());
	out.println(count);
	%>
</body>
</html>