package com.zdy.cn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.zdy.cn.model.UserInfo;
import com.zdy.cn.service.ILoginService;

@Service
public class LoginServlet extends HttpServlet{
	
	ApplicationContext context;

	@Override
	public void init() throws ServletException {
		context = new ClassPathXmlApplicationContext("resource/spring.xml");
		super.init();
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("name");
		String userpwd = req.getParameter("pwd");
		UserInfo user = new UserInfo();
		user.setUserName(username);
		user.setUserPwd(userpwd);
		boolean flag = false;
		ILoginService loginService = (ILoginService)context.getBean("loginServiceImp");
		try {
			flag=loginService.validateLogin(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag){
			resp.sendRedirect("success.jsp");
		}else{
			resp.sendRedirect("login.jsp");
		}
	}


	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		
		context.getBean(arg0.getServletPath());
		super.service(arg0, arg1);
	}

}
