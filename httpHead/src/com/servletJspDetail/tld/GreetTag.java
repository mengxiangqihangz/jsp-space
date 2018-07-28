package com.servletJspDetail.tld;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class GreetTag extends BodyTagSupport{
	private int count;

	@Override
	public int doAfterBody() throws JspException {
		if(count<5){
			count++;
			return EVAL_BODY_AGAIN;
		}else{
			return super.doAfterBody();
		}
		
	}

	@Override
	public int doEndTag() throws JspException {
		JspWriter out = bodyContent.getEnclosingWriter();
		try {
			out.println(bodyContent.getString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.doEndTag();
	}

	@Override
	public int doStartTag() throws JspException {
		count = 0;
		return super.doStartTag();
	}
	
}
