package com.zdy.cn.util;

import java.lang.reflect.Method;

public class ReflactUtils {
	
	public static String getMethodName(String name){
		String methodName="set"+name.substring(0, 1).toUpperCase()+name.substring(1);
		return methodName;
	}
	
	
	public static Method getMethod(Class<?> clazz,String methodname){
		Method[] m=clazz.getMethods();
		for(Method mm:m){
			if(mm.getName().equals(methodname)){
				return mm;
			}
		}
		return null;
	}

}
	

