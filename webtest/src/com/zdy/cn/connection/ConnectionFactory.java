package com.zdy.cn.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import com.zdy.cn.util.PropertyUtil;

public class ConnectionFactory {
	
	private static String path;

	public static Connection getConnection(String type) throws Exception{
		if(type.equalsIgnoreCase("mysql")){
			path="D:/workspace/webtest/src/com/zdy/cn/connection/mysql.properties";
		}else if(type.equalsIgnoreCase("oracle")){
			path="D:/workspace/webtest/src/com/zdy/cn/connection/oracle.properties";
		}else{
			return null;
		}
		String driver=PropertyUtil.getValue("driver", path);
		String url=PropertyUtil.getValue("url", path);
		String name=PropertyUtil.getValue("name", path);
		String password=PropertyUtil.getValue("password", path);
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, name, password);
		
		return con;
	}
}
