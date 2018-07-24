package com.zdy.cn.controller.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.zdy.cn.util.Dom4jUtils;
import com.zdy.cn.util.ReflactUtils;

public class BaseController extends HttpServlet{
	private List<BeanForm> beanlist;
	public List<BeanForm> getBeanlist() {
		return beanlist;
	}
	public void setBeanlist(List<BeanForm> beanlist) {
		this.beanlist = beanlist;
	}
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String path=config.getInitParameter("config1");
		initDom(path);
	}
	private void initDom(String filePath) {
		SAXReader saxReader = new SAXReader();
		try {
			Document document=saxReader.read("filePath");
			Element element = document.getRootElement();
			if(Dom4jUtils.hasElement(element)){
				Iterator<Element> iterator=element.elementIterator();
				while(iterator.hasNext()){
					int count=0;
					BeanForm bf=new BeanForm();
					Element e=iterator.next();
					Dom4jUtils.parseXml(bf, e, count);
					beanlist.add(bf);
				}
				
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path=request.getServletPath();
		BeanForm fb=null;
		for(BeanForm beanf:beanlist){
			if(beanf.getPath().equals(path)){
				fb=beanf;
				break;
			}
		}
		try {
			Class<?> clazz=Class.forName(fb.getClassName());
			Object obj=clazz.newInstance();
			Object paraObj = null;
			
			Method m=ReflactUtils.getMethod(clazz,fb.getMethodName());
			Class<?> para[]=m.getParameterTypes();
			Object ob[]=new Object[para.length];
			
			for(int j=0;j<para.length;j++){
				if(para[j].equals(HttpServletRequest.class.getName())){
					ob[j]=request;
				}else if(para[j].equals(HttpServletResponse.class.getName())){
					ob[j]=response;
				}else if(para[j].equals(String.class.getName())){
					ob[j]=request.getParameter(para[j].toString());
				}else{
					paraObj = paraToObject(para[j],request);
					ob[j] = paraObj;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Object paraToObject(Class<?> clazz,HttpServletRequest reques){
		Enumeration<String> enu=reques.getParameterNames();
		while(enu.hasMoreElements()){
			String paraName=enu.nextElement();
			String paraValue=reques.getParameter(paraName);
		}
		return null;
	}
	
}
