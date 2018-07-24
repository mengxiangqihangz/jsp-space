package com.justin.common;

import java.sql.Connection;
import java.sql.DriverManager;

import com.justin.utils.PropertiesUtils;

public class DbConnection {

	private static String path;

	public DbConnection() {
	}

	/**
	 * @param tag
	 * @return
	 * @throws Exception
	 *             得到数据库连接
	 */
	public static Connection getConnection(String tag) throws Exception {
		path = DbConnection.class.getResource("").getPath();
		if (tag == null || tag.equals("")) {
			path = path + "mysql_jdbc.properties";
		} else {
			path = path + "oracle_jdbc.properties";
		}

		Class.forName(PropertiesUtils.getValue(path, "driver_class"));

		Connection conn = DriverManager.getConnection(
				PropertiesUtils.getValue(path, "url"),
				PropertiesUtils.getValue(path, "userName"),
				PropertiesUtils.getValue(path, "passwd"));
		return conn;
	}
}
