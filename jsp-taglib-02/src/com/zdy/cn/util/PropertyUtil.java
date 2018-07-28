package com.zdy.cn.util;

import java.io.FileReader;
import java.util.Properties;

public class PropertyUtil {

	public static String getValue(String key,String path) throws Exception{
		Properties pro = new Properties();
		pro.load(new FileReader(path));
		return pro.getProperty(key);
	}
}
