package com.justin.utils;

import java.lang.reflect.Method;

public class ReflactUtils {
	/**
	 * 通过属性名称获取对应得set方法
	 * @param name
	 * @return
	 */
	public static String getMethodName (String name) {
		String methodName = "set" + name.substring(0,1).toUpperCase() + name.substring(1);
		return methodName;
	}
	
	/**
	 * 通过方法名称获取方法类
	 * @param classz
	 * @param methodName
	 * @return
	 */
	public static Method getMethod (Class<?> classz,String methodName) {
		
		Method []m = classz.getDeclaredMethods();
		for (Method method : m) {
			if (method.getName().equals(methodName)) {
				return method;
			}
		}
		return null;
	}
}
