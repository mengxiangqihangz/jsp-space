package com.servletJspDetail.tld.switchT;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class DefaultTag extends TagSupport{

	@Override
	public int doStartTag() throws JspException {
		Tag parent = getParent();
		if(!((SwitchTag)parent).getPermission())
			return SKIP_BODY;
		return EVAL_BODY_INCLUDE;
	}
	
	
	
}
