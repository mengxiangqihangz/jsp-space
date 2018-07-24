package com.justin.utils;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Element;

import com.justin.controller.base.BeanForm;

public class Dom4JUtils {
	/**
	 * 是否有子元素
	 * 
	 * @param e
	 * @return
	 */
	public static boolean hasElement(Element e) {
		List<Element> eleList = e.elements();
		return eleList.size() > 0 ? true : false;
	}

	/**
	 * 是否有属性
	 * 
	 * @param e
	 * @return
	 */
	public static boolean hasAttribute(Element e) {
		List<Attribute> attrList = e.attributes();
		return attrList.size() > 0 ? true : false;
	}
	
	/**
	 * 递归解析xml文档
	 * @return
	 */
	public static void parseXml (BeanForm bf,Element e,int count) {
		if (!hasAttribute(e)){
			return;
		}
		List<Attribute> attrList = e.attributes();
		for (Attribute attribute : attrList) {
			if (count == 0) {
				String methodName = ReflactUtils.getMethodName (attribute.getName());
				try {
					Method m = bf.getClass().getDeclaredMethod(methodName, String.class);
					m.invoke(bf, attribute.getValue());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}else{// 第二级，解析跳转的路径
				bf.getMapDual().put(attribute.getValue(), e.getText());
			}
		}
		// 元素下是否还有子节点
		if (hasElement(e)) {
			Iterator<Element> eleIte = e.elementIterator();// 子元素（第二级）
			while (eleIte.hasNext()) {
				Element e1 = eleIte.next();
				count = count + 1;
				parseXml(bf,e1,count);
			}
		}
	}
	
}
