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

	
}
