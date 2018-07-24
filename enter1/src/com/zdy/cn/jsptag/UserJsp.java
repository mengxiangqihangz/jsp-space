package com.zdy.cn.jsptag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.zdy.cn.model.UserInfo;

public class UserJsp  extends TagSupport {
	private UserInfo user;

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		JspWriter out=this.pageContext.getOut();
		if(user==null){
			 try {
				out.println("No UserInfo Found...");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             return SKIP_BODY;
		}
		try {
			out.println("<table width='500px' border='1' align='center'> " );
			out.println("<tr>");
			out.println("<td width='20%'>Username:</td>");
			out.println("<td>"+user.getName()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Age:</td>");
			out.println("<td>"+user.getAge()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Sex:</td>");
			out.println("<td>" + user.getSex() + "</td>");
	        out.println("</tr>");
	        out.println("</table>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		this.user=null;
		super.release();
	}
	
	
	
}
