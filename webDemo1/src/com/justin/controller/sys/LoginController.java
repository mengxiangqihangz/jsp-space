package com.justin.controller.sys;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.justin.model.SysUser;
import com.justin.service.ILoginService;
import com.justin.service.impl.LoginServiceImpl;

public class LoginController {

	private ILoginService loginService;

	public LoginController() {
//		loginService = new LoginServiceImpl();
	}

	public String login(HttpServletRequest request,
			HttpServletResponse response, SysUser user) {

		if (user == null) {
			return "fail";
		}

		// boolean tag = loginService.validLogin(user);
		boolean tag = true;
		if (tag) {
			return "success";
		} else {
			return "fail";
		}
	}

	public String list(HttpServletRequest request,
			HttpServletResponse response, SysUser user) {
		List<SysUser> userList = new ArrayList<>();
		
		for (int i = 0; i < 20; i++) {
			SysUser u = new SysUser();
			u.setId(i);
			u.setCardId("1235252124521252" + i);
			u.setEmail("abc"+i+"@qq.com");
			u.setMobile("1234567852"+i);
			u.setPhone("1234452" + i);
			if ((i+1) %3 == 0){
				u.setSex("1");
			}else{
				u.setSex("0");
			}
			u.setStatus("1");
			u.setUserAccount(user.getUserName());
			u.setUserPwd(user.getUserPwd());
			u.setUserId("1000" + i);
			u.setUserName(user.getUserName() + i);
			userList.add(u);
		}
		
		request.getSession().setAttribute("userList", userList);
		return "success";
	}
}
