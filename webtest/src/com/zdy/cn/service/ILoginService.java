package com.zdy.cn.service;

import com.zdy.cn.model.UserInfo;

public interface ILoginService {
	public boolean validateLogin(UserInfo user) throws Exception;
}
