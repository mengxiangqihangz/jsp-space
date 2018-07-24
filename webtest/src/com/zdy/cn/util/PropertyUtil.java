package com.zdy.cn.util;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtil {

	public static String getValue(String key,String path) throws Exception{
		Properties pro = new Properties();
		pro.load(new FileInputStream(path));
		return pro.getProperty(key);
	}
}
