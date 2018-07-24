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
	private void initDom(String filePath) {//参数filePath传递的值为：D:\workspace\webDemo\resource\servlet-config.xml
		
		SAXReader saxReader = new SAXReader(); //创建输入对象
		try {
			Document document = saxReader.read(filePath);//读取路径里文件servlet-config.xml内容
			Element element = document.getRootElement();// 获得文件内容的根节点<beans>
			if (Dom4JUtils.hasElement(element)) {//调用Dom4JUtils类里的hasElement方法判断根节点下是否存在子节点
				Iterator<Element> eleIte = element.elementIterator();// 创建子节点迭代器，
				while (eleIte.hasNext()) {   //遍历子节点迭代器，
					int count = 0;
					BeanForm bf = new BeanForm();//实例化BeanForm对象bf;
					Element e = eleIte.next();//取出子节点<bean>元素
					//调用Dom4JUtils的parseXml()方法，
					//传递三个参数：BeanForm对象bf,子节点<bean>元素,次数count,得到实例化的bf(path,classname,methodname)
					Dom4JUtils.parseXml(bf,e,count);
					beanList.add(bf);//把实例化的bf(path,classname,methodname)对象放到beanlist集合
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init(ServletConfig config) {//第一步初始化，获得初始化参数config
		//把名为config1的参数值("D:\workspace\webDemo\resource\servlet-config.xml")赋值给filePath
		String filePath = config.getInitParameter("config1");
		//把值("D:\workspace\webDemo\resource\servlet-config.xml")作为参数调用本类的initDom()方法
		//把servlet-config.xml里的路径，类名，方法名解析出来
		initDom(filePath);
	}

	public void service(HttpServletRequest request, HttpServletResponse response) {
		// 获取浏览器请求的路径login.do
		String path = request.getServletPath();
		//通过path,beanList两个条件就可以找到浏览器请求的具体方法
		BeanForm bean =null;
		for (BeanForm bf : beanList) {
			if (bf.getPath().equals(path)) {
				//bean对象里的path=/login.do,methodname=login,classname=com.justin.controller.sys.LoginController
				bean = bf;
				break;
			}
		}
		
		try {
			// 通过反射获取处理类的class对象
			//通过getClassName()方法获得类的路径名com.justin.controller.sys.LoginController
			//通过forName()方法，创建指定路径下的LoginController类对象
			Class<?> classz = Class.forName(bean.getClassName());
			// 创建此LoginController类 对象所表示的类的一个新实例。
			Object newObj = classz.newInstance();
			Object paramObj = null;
			
			// 根据方法名得到方法(LoginController类对象,methodname(login))
			// 获得LoginController类login()方法
			Method m = ReflactUtils.getMethod(classz, bean.getMethodName());
			 
			// 获取方法的参数个数
			// 按照声明顺序返回LoginController类login()方法
			//中形参(HttpServletRequest request,HttpServletResponse response, SysUser user)类型的数组
			Class<?> params[] = m.getParameterTypes();
			//创建paramsValue数组，并定义其长度为LoginController类login()方法里的参数个数
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
			//返回指定键所映射的值；
			String url = bean.getMapDual().get(result.toString());
			
			//request.getRequestDispatcher(url).forward(request, response);
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
		//返回一个包含了请求中的参数名字的字符串对象的枚举变量。 userName;userPwd
		Enumeration<String> enumStr = request.getParameterNames();
		//创建SysUser user类 对象所表示的类的一个实例。
		Object paramObj = param.newInstance();
		while (enumStr.hasMoreElements()) {//测试此枚举是否包含更多的元素。
			String paramName = enumStr.nextElement();
			String paramValue = request.getParameter(paramName);
			//返回 Field 对象的一个数组，这些对象反映 SysUser user类对象所表示的类或接口SysUser所声明的所有字段。
			//SysUser所声明的所有字段:id;userId;userName;sex;cardId;email;mobile;phone;status;userAccount;userPwd;
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
