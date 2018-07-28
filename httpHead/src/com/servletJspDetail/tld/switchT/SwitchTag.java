package com.servletJspDetail.tld.switchT;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class SwitchTag extends TagSupport{
	private boolean subTagExecuted;
	
	public SwitchTag(){
		subTagExecuted = false;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		subTagExecuted = false;
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		subTagExecuted = false;
	}
	
	public synchronized boolean getPermission(){
		return (!subTagExecuted);
	}
	
	public synchronized void subTagSucceeded(){
		subTagExecuted = true;
	}
}
