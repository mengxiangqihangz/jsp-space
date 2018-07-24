package com.zdy.cn.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdy.cn.dao.ILoginDao;
import com.zdy.cn.model.UserInfo;
import com.zdy.cn.service.ILoginService;

@Service
public class LoginServiceImp implements ILoginService {
	
	@Autowired
	private ILoginDao loginDaoImp;
	
	public void setLoginDaoImp(ILoginDao loginDaoImp) {
		this.loginDaoImp = loginDaoImp;
	}
	
	public void LoginServiceImp(){
		
	}

	@Override
	public boolean validateLogin(UserInfo user) throws Exception {
		String sql = "select username from userinfo where username='"+user.getUserName()+"' and userpwd='"+user.getUserPwd()+"'";
		return loginDaoImp.validateLogin(sql);
	}

}
