package com.justin.controller.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.justin.model.SysUser;
import com.justin.utils.Dom4JUtils;
import com.justin.utils.ReflactUtils;

public class BaseController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 解析出来的xml
	 */
	private List<BeanForm> beanList = new ArrayList<BeanForm>();

	public List<BeanForm> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<BeanForm> beanList) {
		this.beanList = beanList;
	}

	/**
	 * 初始化解析dom文档
	 * @param filePath
	 */
	private void initDom(String filePath) {
		
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(filePath);
			Element element = document.getRootElement();// 根元素
			if (Dom4JUtils.hasElement(element)) {
				Iterator<Element> eleIte = element.elementIterator();// 子元素（第一级）
				while (eleIte.hasNext()) {
					int count = 0;
					BeanForm bf = new BeanForm();
					Element e = eleIte.next();
					Dom4JUtils.parseXml(bf,e,count);
					beanList.add(bf);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init(ServletConfig config) {
		String filePath = config.getInitParameter("config1");
		initDom(filePath);
	}

	public void service(HttpServletRequest request, HttpServletResponse response) {
		// 获取请求的路径
		String path = request.getServletPath();
		// 通过路径，获取解析出来的配置对象
		BeanForm bean =null;
		for (BeanForm bf : beanList) {
			if (bf.getPath().equals(path)) {
				bean = bf;
				break;
			}
		}
		
		try {
			// 通过反射获取处理类的class对象
			Class<?> classz = Class.forName(bean.getClassName());
			Object newObj = classz.newInstance();
			Object paramObj = null;
			//classz 是LoginController的Class的对象。
			// 根据方法名得到方法名称
			Method m = ReflactUtils.getMethod(classz, bean.getMethodName());
			//bean:servlet-config的第一个。是BeanForm的对象
			//m:login（）
			//classz:是LoginController的Class对象。
			// 获取方法的参数个数
			Class<?> params[] = m.getParameterTypes();
			Object paramsValue [] = new Object [params.length];
			
			for (int i = 0; i < params.length; i++) {
				if (params[i].getName().equals(HttpServletRequest.class.getName()) ) {
					paramsValue[i] = request;
				}else if (params[i].getName().equals(HttpServletResponse.class.getName())){
					paramsValue[i] = response;
				}else if (params[i].getName().equals(String.class.getName())){
					paramsValue[i] = request.getParameter(params[i].toString());
				}else{
					paramObj = paramsToObject(params[i],request);
					paramsValue[i] = paramObj;
				}
			}
			
			Object result = m.invoke(newObj, paramsValue);
			if (result == null){
				return;
			}
			
			String url = bean.getMapDual().get(result.toString());
			
			//requ   est.getRequestDispatcher(url).forward(request, response);
			response.sendRedirect(url);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 传送的参数列表封装到指定的对象中去
	 * @param param
	 * @param request
	 * @return
	 * @throws Exception
	 */
	private Object paramsToObject (Class<?> param,HttpServletRequest request) throws Exception {
		// 获取请求的参数列表
		Enumeration<String> enumStr = request.getParameterNames();
		Object paramObj = param.newInstance();
		while (enumStr.hasMoreElements()) {
			String paramName = enumStr.nextElement();
			String paramValue = request.getParameter(paramName);

			Field[] fields = param.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				if (fields[i].getName().equals(paramName)) {
					String methodName = ReflactUtils.getMethodName(paramName);
					// 这个地方需要改造，目前只支持ben属性为String的参数类型
					Method m = param.getDeclaredMethod(methodName,String.class);
					m.invoke(paramObj, paramValue);
					break;
				}
			}
		}
		return paramObj;
	}

}
