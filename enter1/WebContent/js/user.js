
function validLogin ()
{
	var userName = document.getElementById("userName").value;
	var userPwd = document.getElementById("userPwd").value;
	
	var regUser = /^[a-zA-Z]{1}\w{3,9}$/;
	var regPwd = /^\w+$/;
	
	var isPass = regUser.test(userName);
	if (!isPass) {
		document.getElementById("userNameErr").innerHTML = '用户名不符合规范';
		return;
	}else{
		document.getElementById("userNameErr").innerHTML = '';
	}
	
	
	isPass = regPwd.test(userPwd);

	if (!isPass) {
		document.getElementById("userPwdErr").innerHTML = '密码不符合规范';
		return;
	}else{
		document.getElementById("userPwdErr").innerHTML = '';
	}
	
	if (isPass) {
		document.location.href = "login.do?userName="+userName+"&userPwd="+userPwd;
	}

}