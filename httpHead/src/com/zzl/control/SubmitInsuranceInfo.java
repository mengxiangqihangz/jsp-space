package com.zzl.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzl.bean.InsuranceInfo;
import com.zzl.util.BeanUtilities;
import com.zzl.util.HtmlHelp;

public class SubmitInsuranceInfo extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse rsp) throws IOException{
		
		InsuranceInfo info = new InsuranceInfo();
		BeanUtilities.populateBean(info, req);
		PrintWriter out = rsp.getWriter();
		String title = "Insurance Info for " + info.getName();
		out.println(HtmlHelp.getHeadWithTitle(title)+
				"<BODY> BGCOLOR=\"#FDF5E6\">\n"
				+ "<CENTER>\n"
				+ "<H1>"+title+"</H1>\n"
				+ "<UL>\n"
				+ "  <li>Employee ID:"
				+ info.getEmployeeID()+"\n"
				+ "  <li>Number of childern:"
				+ info.getNumChildren()+"\n"
				+ "  <li> Married?:"
				+ info.isMarried()+"\n"
				+ "</UL></CENTER></BODY></HTML>");
	}
}
