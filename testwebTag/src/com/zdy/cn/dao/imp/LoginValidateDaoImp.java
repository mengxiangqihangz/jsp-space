package com.zdy.cn.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.zdy.cn.connection.ConnectionFactory;
import com.zdy.cn.dao.ILoginValidateDao;
import com.zdy.cn.service.ILoginValidateService;

public class LoginValidateDaoImp implements ILoginValidateDao{
	Connection con;
	public LoginValidateDaoImp(){
		if(con==null){
			try {
				con=ConnectionFactory.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean validateLogin(String sql) throws Exception {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs.next();
	}

}
