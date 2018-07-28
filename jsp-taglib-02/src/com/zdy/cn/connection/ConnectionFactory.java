package com.zdy.cn.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import com.zdy.cn.util.PropertyUtil;

public class ConnectionFactory {
	
	final static String path = "D:/workspace/testweb/src/com/zdy/cn/resource/mysql.properties";

	public static Connection getConnection() throws Exception{
		String dirver = PropertyUtil.getValue("driver", path);
		String url = PropertyUtil.getValue("url", path);
		String name = PropertyUtil.getValue("name", path);
		String pwd = PropertyUtil.getValue("pwd", path);
		Class.forName(dirver);
		
		Connection con = DriverManager.getConnection(url,name,pwd);
		
		return con;
	}
}
