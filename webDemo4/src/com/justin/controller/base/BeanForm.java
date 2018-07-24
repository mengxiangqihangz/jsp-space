package com.justin.controller.base;

import java.util.HashMap;
import java.util.Map;

public class BeanForm {
	private String path;// 请求路径
	private String className;// 处理的类名
	private String methodName;//处理方法名
	
	private Map<String,String> mapDual = new HashMap<String, String>(); //存放相应信息对应的页面
	
	public BeanForm () {
		
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {//传递的参数为"/login.do"
		this.path = path;//path=/login.do
		this.methodName = path.substring(1, path.length()-3);//methodName=login
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {//传递的参数为"com.justin.controller.sys.LoginController"
		this.className = className;//classname=com.justin.controller.sys.LoginController
	}

	public Map<String, String> getMapDual() {
		return mapDual;
	}

	public void setMapDual(Map<String, String> mapDual) {
		this.mapDual = mapDual;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	
}
