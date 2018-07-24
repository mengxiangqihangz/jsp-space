package com.zdy.cn.util;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Element;

import com.zdy.cn.controller.base.BeanForm;



public class Dom4jUtils {
	public static boolean hasElement(Element el){
		List<Element> listel= el.elements();
		return listel.size()>0? true:false;
	}
	public static boolean hasAttribute(Element e) {
		List<Attribute> attrList = e.attributes();
		return attrList.size() > 0 ? true : false;
	}
	
	public static void parseXml (BeanForm bf,Element e,int count) {
		if(!hasAttribute(e)){
			return ;
		}
		List<Attribute> attr=e.attributes();
		for(Attribute att:attr){
			if(count==0){
				String methodName=ReflactUtils.getMethodName(att.getName());
				try {
					Method meth=bf.getClass().getDeclaredMethod(methodName, String.class);
					meth.invoke(bf, att.getValue());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else{
				bf.getMapDual().put(att.getValue(), att.getText());
			}
		}
		if(hasElement(e)){
			Iterator<Element> iterator=e.elementIterator();
			while(iterator.hasNext()){
				Element e1=iterator.next();
				count++;
				parseXml(bf,e1,count);
			}
		
		}
			
	}

}
