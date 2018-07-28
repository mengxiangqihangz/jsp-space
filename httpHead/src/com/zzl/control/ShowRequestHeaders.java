package com.zzl.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.http11.Http11Processor;

import com.zzl.bean.ShowRequest;
import com.zzl.util.BeanUtilities;

public class ShowRequestHeaders extends HttpServlet{
//implements SingleThreadModel {
//	https://www.ibm.com/developerworks/cn/websphere/library/bestpractices/do_not_implement_single_thread_model_in_servlets.html
//	private int numberOfRows = 0;
//	private javax.sql.DataSource ds = null;
//
//	PrintWriter output;
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response)
//	        throws ServletException, IOException {
//	    String  username;
//	    response.setContentType("text/html;charset=gb2312");
//	    username=request.getParameter("username");
//	    output=response.getWriter();
//	    try {
//	        //为了突出并发问题，在这设置一个延时
////	        Thread.sleep(5000);
//	        output.println("用户名:"+username+"<BR>"); 
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	}
	//
	public static int i;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		String url = "http://localhost:8080/httpHead/UserIDs?username=zhag&userAge=13";
		i++;
//		Http11Processor
		ShowRequest sr = new ShowRequest(); 
		BeanUtilities.populateBean(sr, req);
		resp.setContentType("text/html");
		// resp.setStatus(HttpServletResponse.SC_ACCEPTED);
		PrintWriter out = resp.getWriter();
		String title = "Servlet Example:Showing Request Headers";
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional/EN\">\n";
		out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title
				+ "</HEAD></TITLE>" + "<BODY BGCOLOR=\"#FDF5E6\">\n"
				+ "<H1 ALIGN=\"CENTER\">" + title + "----" + i + "</H1>\n"
				+ "<B>Request Method:</B>" + req.getMethod() + "<BR>\n"
				+ "<B>Request URI:</B>" + req.getRequestURI() + "<BR>\n"
				+ "<B>Request Protocol:</B>" + req.getProtocol() + "<BR><BR>\n"
				+ "<B>name:</B>" + sr.getUsername() + "<BR><BR>\n"
				+ "<B>age:</B>" + sr.getUserAge() + "<BR><BR>\n"
				+ "<TABLE BORDER=1 ALIGN=\"CENTER\">\n"
				+ "<TR BGCOLOR=\"#FFAD00\">\n"
				+ "<TH>Header Name<TH>Header Vale");
		Enumeration headerNames = req.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			out.println("<TR><TD>" + headerName);
			out.println("    <TD>" + req.getHeader(headerName));
		}
		out.println("</TABLE>\n</BODY></HTML>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
