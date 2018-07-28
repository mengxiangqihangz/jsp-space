package com.zzl.control.jsp;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Server;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.connector.CoyoteAdapter;
import org.apache.catalina.core.ContainerBase;
import org.apache.catalina.startup.Bootstrap;
import org.apache.coyote.http11.Http11Processor;
import org.apache.jasper.runtime.HttpJspBase;


public class BaseControl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		Http11Processor
//		ContainerBase
//		Service
//		Server
//		Connector
//		Bootstrap
		
//		HttpJspBase
//		JspSourceDependent
//		HttpSession 
//		ServletContext
		getServletConfig().getServletContext();getServletContext();  //这两个方法相等
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
}
