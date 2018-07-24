package com.justin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.justin.common.DbConnection;
import com.justin.dao.ILoginDao;
import com.justin.model.SysUser;

public class LoginDaoImpl implements ILoginDao {

	private Connection conn = null;
	public LoginDaoImpl () {
		DbConnection comm = new DbConnection();
		try {
			conn = comm.getConnection("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean validLogin(SysUser user) throws Exception {
		PreparedStatement pstmt = conn.prepareStatement("select * from sys_user t where t.user_name = ? and t.user_pwd = ?");
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getUserPwd());
		
		ResultSet rs =  pstmt.executeQuery();
		
		boolean tag = rs.next();
		rs.close();
		pstmt.close();
		conn.close();
		if (tag) {
			return true;
		}
		return false;
	}

}
