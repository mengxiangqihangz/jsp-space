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
//	第一次把根节点<benas>作为参数传递过来获取根节点下的节点<bean>集合
//	第二次把节点<bean>作为参数传递过来获取节点下的子节点<property>集合
//	如果集合里有元素，即根节点下有子节点，返回true，否则返回false
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
	public static boolean hasAttribute(Element e) {//节点<bean>作为参数
		List<Attribute> attrList = e.attributes();//调用attributes()方法，获得节点<bean>里的属性集合attrList
		return attrList.size() > 0 ? true : false;//判断节点<bean>里是否有属性，有返回true，无返回false
	}
	
	/**
	 * 递归解析xml文档
	 * @return
	 */
	public static void parseXml (BeanForm bf,Element e,int count) {
		if (!hasAttribute(e)){//调用本类里的hasAttribute()方法，把节点<bean>作为参数传递过去，节点里面没有属性直接返回，有属性就遍历属性
			return;
		}
		//获得节点<bean>里的属性集合attrList，包含 path="/login.do" 和className="com.justin.controller.sys.LoginController"
		List<Attribute> attrList = e.attributes();
		for (Attribute attribute : attrList) {//通过两次循环，把节点里的path和className两个属性遍历出来
			if (count == 0) {//判断是否是第一个子节点
				//通过属性的名字调用ReflactUtils.getMethodName()方法，获得方法名
				String methodName = ReflactUtils.getMethodName (attribute.getName());//得到方法名methodName：setPath 和  setClassname
				try {
					//获取class对象的三种方法：类对象.getClass();类名.class;Class.forname("路径");
					//通过getClass()获得BeanForm类的class对象，调用Class类了的getDeclaredMethod(方法名，参数数组)方法,获取指定的方法
					Method m = bf.getClass().getDeclaredMethod(methodName, String.class);//获得BeanForm类中指定的方法
					//通过调用Method中invoke()的方法，动态运行该方法！
					//bf是表示调用的方法所在类的实例化对象，
					//attribute.getValue()表示给调用方法的形参传递的实参/login.do或com.justin.controller.sys.LoginController
					m.invoke(bf, attribute.getValue());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}else{// 第二级，解析跳转的路径
				//把子节点<property>里的属性name值和子节点里的内容以键值对的形式存到相应bf的属性mapDual里
				bf.getMapDual().put(attribute.getValue(), e.getText());
			}
		}
		
		if (hasElement(e)) {// 第二次调用hasElement()传递参数节点<bean>，判断其节点下是否还有子节点
			Iterator<Element> eleIte = e.elementIterator();// 创建节点迭代器，遍历迭代器
			while (eleIte.hasNext()) {
				Element e1 = eleIte.next();//获取子节点<property>
				count = count + 1;//count=1，2
				parseXml(bf,e1,count);//再一次调用parseXml()方法，传递三个参数(bf,子节点<property>,1，2)
			}
		}
	}
}
		

	
  
