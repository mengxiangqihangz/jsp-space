package com.justin.utils;

import java.lang.reflect.Method;

public class ReflactUtils {
	/**
	 * 通过属性名称获取对应得set方法
	 * @param name
	 * @return
	 */
	public static String getMethodName (String name) {//把属性的名字传递过来(path,classname)
		String methodName = "set" + name.substring(0,1).toUpperCase() + name.substring(1);//得到方法名：setPath 和  setClassname
		return methodName;
	}
	
	/**
	 * 通过方法名称获取方法类
	 * @param classz
	 * @param methodName
	 * @return
	 */
	public static Method getMethod (Class<?> classz,String methodName) {//传递的两个参数为：LoginController类对象,methodname(login)
		//返回 Method 对象的一个数组，这些对象反映此 Class 对象表示的类或接口(LoginController类)声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法
		Method []m = classz.getDeclaredMethods();
		for (Method method : m) {
			if (method.getName().equals(methodName)) {
				return method;//获得LoginController类login()方法并返回
			}
		}
		return null;
	}   
}
