package com.zdy.cn.service.imp;

import com.zdy.cn.dao.ILoginValidateDao;
import com.zdy.cn.dao.imp.LoginValidateDaoImp;
import com.zdy.cn.model.UserInfo;
import com.zdy.cn.service.ILoginValidateService;

public class LoginValidateServiceImp implements ILoginValidateService{
	
	ILoginValidateDao ild;
	
	public LoginValidateServiceImp(){
		if(ild==null){
			ild=new LoginValidateDaoImp();
		}	
	}
	public boolean validateServiceLogin(UserInfo user) throws Exception {
		String sql="select sname from student where sname='"+user.getName()+"' and spassword='"+user.getPwd()+"'";
//		String sql="select sname from student where sname='"+user.getName()+"'";
		return (ild.validateDaoLogin(sql));
		
	}
	
}
