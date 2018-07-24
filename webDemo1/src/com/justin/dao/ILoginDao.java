package com.justin.dao;

import com.justin.model.SysUser;

public interface ILoginDao {
	public boolean validLogin (SysUser user) throws Exception;
}
