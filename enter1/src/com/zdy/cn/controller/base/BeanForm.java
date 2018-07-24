package com.zdy.cn.controller.base;

import java.util.HashMap;
import java.util.Map;

public class BeanForm {
	private String path;
	private String className;
	private String methodName;
	private Map<String,String> mapDual=new HashMap<String,String>();
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
		this.methodName=path.substring(1, path.length()-3);
		
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Map<String, String> getMapDual() {
		return mapDual;
	}
	public void setMapDual(Map<String, String> mapDual) {
		this.mapDual = mapDual;
	}
	
	
	
}
