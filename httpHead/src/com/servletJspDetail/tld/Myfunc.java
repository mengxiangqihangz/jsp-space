package com.servletJspDetail.tld;

import java.io.UnsupportedEncodingException;

public class Myfunc {
	
	public static String toGBK(String str,String charset) throws UnsupportedEncodingException{
		return new String(str.getBytes(charset),"GBK");
	}
	
}
