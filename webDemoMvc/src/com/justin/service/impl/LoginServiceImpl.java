package com.justin.service.impl;

import com.justin.dao.ILoginDao;
import com.justin.dao.impl.LoginDaoImpl;
import com.justin.model.SysUser;
import com.justin.service.ILoginService;

public class LoginServiceImpl implements ILoginService {
	private ILoginDao loginDao = null;
	
	public LoginServiceImpl () {
		loginDao = new LoginDaoImpl();
	}
	
	public boolean validLogin(SysUser user) {
		try {
			return loginDao.validLogin(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
