<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	var http_request = false;
	function getXmlHttpRequest() {
		if (window.XMLHttpRequest) {//非IE浏览器
			http_request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {//IE浏览器
			try {
				http_request = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					http_request = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
				}
			}
		}
		if (!http_request) {
			alert("无法创建XMLHttpRequest对象！");
			return false;
		} 
	}
	
	function login() {
		getXmlHttpRequest();
		var user = document.getElementById("userName").value;
		
		var url = "/enter/ppp?userame=" + user;
		http_request.open("post", url);
		http_request.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
		http_request.send(null);
		http_request.onreadystatechange = getResult;
	}
	function getResult() {
		if (http_request.readyState == 4) {
			if (http_request.status == 200) {
				
				alert(http_request.responseText);
			} else {
				alert(http_request.status);
				alert("请求服务器发生错误");
			}
	
		}
	} 

</script>
</head>
<body>
	
	<form action="" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" id="userName" name="userNam" onblur="login()"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" id="pwd" name="pawd"></td>
			</tr>
			<tr>
				<td><input type="button" value="提交" ></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
	<a href="regist.jsp">注册</a>
</body>
</html>