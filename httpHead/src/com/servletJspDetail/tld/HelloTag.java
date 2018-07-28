package com.servletJspDetail.tld;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class HelloTag implements Tag{
	private PageContext pageContext;
	private Tag  parent;
	
	
	
	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.print("»¶Ó­À´µ½ÕÙ»½Ê¦Ï¿¹È");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			
		}
		
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return SKIP_BODY;
	}

	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return parent;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPageContext(PageContext pc) {
		this.pageContext = pc ;
	}

	@Override
	public void setParent(Tag t) {
		this.parent = t;
	}
	
	
	
}
