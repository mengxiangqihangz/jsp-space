package com.zzl.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class includeTest extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(req.getParameter("pname"));
//		req.getRequestDispatcher("/crazy/02/2.8/includeTest.jsp").forward(req, resp);
		req.getRequestDispatcher("/crazy/02/2.8/includeTest.jsp").include(req, resp);
//		super.doGet(req, resp);
	}
	
}
