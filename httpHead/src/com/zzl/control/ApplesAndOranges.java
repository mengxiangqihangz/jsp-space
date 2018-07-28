package com.zzl.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApplesAndOranges extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/vnd.ms-excel");
		PrintWriter out = resp.getWriter();
		out.println("\ttype\tQ1\tQ2\tQ3\tTotal");
		out.println("\tApples\t78\t87\t92\t29\t=sum(B2:E2)");
		out.println("\tOranges\t78\t86\t93\t30\t=sum(B3:E3)");
//		http://localhost:8080/httpHead/appleAndOranges
//		super.doGet(req, resp);
	}
	
}
