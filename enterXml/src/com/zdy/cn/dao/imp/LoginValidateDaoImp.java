package com.zdy.cn.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zdy.cn.connection.ConnectionFactory;
import com.zdy.cn.dao.ILoginValidateDao;

public class LoginValidateDaoImp implements ILoginValidateDao{
	Connection conn;
	public LoginValidateDaoImp(){
		if(conn==null){
			try {
				conn=ConnectionFactory.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public boolean validateDaoLogin(String sql) throws Exception{
		Statement sta=conn.createStatement();
		ResultSet res=sta.executeQuery(sql);
		return res.next();
	
		
		
	}

}
