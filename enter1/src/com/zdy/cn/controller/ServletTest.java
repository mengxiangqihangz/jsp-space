package com.zdy.cn.controller;

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
	ILoginValidateService ils;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserInfo ui=new UserInfo();
		String nam=req.getParameter("user");
		String pass=req.getParameter("userpass");
		ui.setName(nam);
		ui.setPwd(pass);
		boolean flag=false;
		
		try {
			flag=ils.validateServiceLogin(ui);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if(flag){
//			resp.sendRedirect("html/welcome.html");
//		}else{
//			resp.sendRedirect("log.html");
//		}
		if(flag){
			req.getSession().setAttribute("islogin", true);
			resp.getWriter().write("µÇÂ¼³É¹¦£º"+nam);
		}else{
			resp.sendRedirect("login.jsp");
		}
		
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		if(ils==null){
			ils=new LoginValidateServiceImp();						
		super.init(config);
		}
	}

}
