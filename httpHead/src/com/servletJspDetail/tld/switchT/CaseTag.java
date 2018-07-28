package com.servletJspDetail.tld.switchT;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class CaseTag extends TagSupport {
	private boolean cond;
	
	public CaseTag(){
		cond = false;
	}
	
	public void release(){
		cond = false;
	}

	public boolean isCond() {
		return cond;
	}

	public void setCond(boolean cond) {
		this.cond = cond;
	}

	@Override
	public int doStartTag() throws JspException {
		Tag parent = getParent();
		if(!((SwitchTag)parent).getPermission()){
			return SKIP_BODY;
		}
		if(cond){
			((SwitchTag)parent).subTagSucceeded();
			return EVAL_BODY_INCLUDE;
		}
		return SKIP_BODY;
	}
	
	
	
}
