package com.zzl.tag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloWorldTag extends SimpleTagSupport{
	
	@Override
	public void doTag() throws IOException{
		getJspContext().getOut().write("Hello World " + new Date());
	}
	
}
