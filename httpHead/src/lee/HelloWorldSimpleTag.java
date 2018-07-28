package lee;

import java.io.IOException;

import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloWorldSimpleTag extends SimpleTagSupport{
	
	public void doTag() throws IOException{
		getJspContext().getOut().write("Hello World"
				+new java.util.Date());
	}
}
