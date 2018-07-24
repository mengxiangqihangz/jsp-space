package com.zdy.cn.controler;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zdy.cn.model.UserInfo;
import com.zdy.cn.service.ILoginValidateService;
import com.zdy.cn.service.imp.LoginValidateServiceImp;

public class ServletTest extends HttpServlet{
	
	ILoginValidateService loginValidate;

//	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		System.out.println("doGet����");
//		super.doGet(req, resp);
//	}
//
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		System.out.println("doPost����");
//		super.doPost(req, resp);
//	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		String path = this.getServletConfig().getInitParameter("database");
		String name = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		UserInfo user = new UserInfo();
		user.setName(name);
		user.setPwd(pwd);
		try {
			if(loginValidate.validateLogin(user)){
				response.sendRedirect("success.html");
			}else{
				response.sendRedirect("index.html");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void init(ServletConfig config) throws ServletException {
		if(loginValidate==null){
			loginValidate=new LoginValidateServiceImp();
		}
		super.init(config);
	}
	
}
