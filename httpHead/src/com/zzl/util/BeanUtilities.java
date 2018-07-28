package com.zzl.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtilities {
	public static void populateBean(Object formBean,HttpServletRequest req){
		try {
			BeanUtils.populate(formBean,req.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
}
