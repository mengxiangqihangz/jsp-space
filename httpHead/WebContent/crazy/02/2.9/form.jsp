<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>收集参数的表单页</title>
</head>
<body>
<!-- http://localhost:8080/httpHead/crazy/02/2.9/form.jsp -->
	
	<form action="request1.jsp" >  <!-- 默认为get提交 改成post提交便要乱码 -->
		用户名：<br>
		<input type="text" name="name"><hr>
		性&nbsp;别：<br>
		男：<input type="radio" name="gender" value="男">
		女：<input type="radio" name="gender" value="女"><hr>
		喜欢的颜色：<br>
		红：<input type="checkbox" name="color" value="红">
		绿：<input type="checkbox" name="color" value="绿">
		蓝：<input type="checkbox" name="color" value="蓝"><hr>
		来自的国家：<br>
		<select name="country">
			<option value="美国">美国</option>
			<option value="中国">中国</option>
			<option value="俄罗斯">俄罗斯</option>
		</select><hr>
		<input type="submit" value="提交">
		<input type="reset" value="重置">
	</form>
</body>
</html>