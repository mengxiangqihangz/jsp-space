package com.justin.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Administrator 
 * 通用的属性文件操作类（单例模式）
 * 
 */
public class PropertiesUtils {

	private static Properties prop = null;

	private PropertiesUtils() {
		if (prop == null) {
			prop = new Properties();
		}
	}

	/**
	 * @return 返回当前类的同一个实例
	 */
	private Properties getInstance(String path) {
		try {
			prop.load(new FileInputStream(new File(path)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static String getValue(String path,String key) {
		PropertiesUtils p = new PropertiesUtils ();
		prop = p.getInstance (path);
		return (String)prop.get(key);
	}
}
