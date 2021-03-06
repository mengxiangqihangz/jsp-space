package com.zdy.cn.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import com.zdy.cn.util.PropertyUtil;

public class ConnectionFactory {
	
	final static String path="D:/webspace/enter/src/com/zdy/cn/resource/oracle.properties";
	
	public static Connection getConnection() throws Exception{
		String driver=PropertyUtil.getValue("driver", path);
		String name=PropertyUtil.getValue("name", path);
		String url=PropertyUtil.getValue("url", path);
		String pwd=PropertyUtil.getValue("pwd", path);
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url,name,pwd);
		return conn;
		
	}

}
