package com.servletJspDetail.tld;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class IterateTag extends TagSupport{
	private Iterator items;
	private String itemId;
	private Object item;
	
	public IterateTag(){
		items = null;
	}
	
	public void release(){
		items = null;
	}
	
	public void setItems(Collection cl){
		if(cl.size()>0){
			items = cl.iterator();
		}
	}
	
	public void setVar(String var){
		itemId = var;
	}

	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		return super.doAfterBody();
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doStartTag();
	}
	
	
	
}
