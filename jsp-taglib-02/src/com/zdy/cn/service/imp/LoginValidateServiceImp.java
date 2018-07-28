package com.zdy.cn.service.imp;

import com.zdy.cn.dao.ILoginValidateDao;
import com.zdy.cn.dao.imp.LoginValidateDaoImp;
import com.zdy.cn.model.UserInfo;
import com.zdy.cn.service.ILoginValidateService;

public class LoginValidateServiceImp implements ILoginValidateService{
	
	ILoginValidateDao loginValidateDao;
	
	public LoginValidateServiceImp(){
		if(loginValidateDao==null){
			loginValidateDao= new LoginValidateDaoImp();
		}
	}

	@Override
	public boolean validateLogin(UserInfo user) throws Exception {
		
		String sql="select name from userinfo where name='"+user.getName()+"' and pwd = '"+user.getPwd()+"'";
		
		return loginValidateDao.validateLogin(sql);
	}


}
