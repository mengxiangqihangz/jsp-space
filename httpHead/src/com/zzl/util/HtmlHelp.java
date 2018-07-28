package com.zzl.util;

public class HtmlHelp {
	public static String getHeadWithTitle(String title){
		return "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n"
				+ "<HTML>\n"
				+ "<HEAD><TITLE>"+title+"</TITLE></HEAD>\n";
	}
}
