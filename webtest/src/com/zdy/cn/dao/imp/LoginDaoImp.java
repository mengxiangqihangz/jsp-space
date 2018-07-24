package com.zdy.cn.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import com.zdy.cn.connection.ConnectionFactory;
import com.zdy.cn.dao.ILoginDao;

@Service
public class LoginDaoImp implements ILoginDao{
	
	Connection con =null;
	
	public LoginDaoImp(){
		try {
//			con = ConnectionFactory.getConnection("mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean validateLogin(String sql) throws Exception {
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery(sql);
		return true;
	}

}
