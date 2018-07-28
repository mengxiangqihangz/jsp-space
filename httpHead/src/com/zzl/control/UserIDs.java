package com.zzl.control;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.zzl.util.HtmlHelp;
//
public class UserIDs extends HttpServlet {
	private int nextID = 0;
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		ServletInputStream sis=req.getInputStream();
////		byte[] by=new byte[102400];
////		int num=sis.read(by);
////		System.out.println(by);
//		try {  
//            String imsi = req.getParameter("imsi");  
//            String fileName = req.getParameter("filename");  
//            String dataFlag = req.getParameter("data_flag");  
//  
//            String localPath = req.getSession().getServletContext().getRealPath("/");  
//            String sysUrl = Constants.SYSTEM_URL+request.getContextPath();  
//            int fileSize = request.getContentLength();  
//              
//             //接收文件  
//            ServletInputStream in = request.getInputStream();  
//            url = iRemoteUploadFileServerService.uploadFileServer(imsi, fileName, dataFlag, in, localPath, sysUrl, fileSize);  
//            System.out.println(url);  
//        } catch (Exception e) {  
//            // TODO Auto-generated catch block  
//            e.printStackTrace();  
//        }  
//		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
//		String title="Your ID";
//		out.println(HtmlHelp.getHeadWithTitle(title)+
//				"<CENTER>\n"
//				+ "<BODY BGCOLOR=\"#FDF5E6\">\n"
//				+ "<H1>"+title+"</H1>\n");
//		synchronized (this) {
//			String id="User-ID-"+nextID;
//			out.println("<H2>"+id+"</H2>");
//			nextID=nextID+1;
//		}
//		out.println("</BODY></HTML>");
//		
//	}
//	
//	
}
