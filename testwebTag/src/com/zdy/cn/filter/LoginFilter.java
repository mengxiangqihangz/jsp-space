package com.zdy.cn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter{

	static String ip ="";
	
	@Override
	public void destroy() {
		System.out.println("过滤器销毁方法");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("有人登录，开始过滤");
		String addr = request.getLocalAddr();
		boolean flag = false;
		String[] ips = ip.split(",");
		for (String ip : ips) {
			if(ip.equals(addr)){
				flag=true;
			}
		}
		boolean flag1 = false;
		Object obj = ((HttpServletRequest)request).getSession().getAttribute("name");
		if(obj!=null){
			flag1=true;
		}
		if(flag&&!flag1){
			chain.doFilter(request, response);
		}else if(flag&&flag1){
			request.getRequestDispatcher("success.html").forward(request, response);
		}else{
			request.getRequestDispatcher("error.html").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		ip = config.getInitParameter("ip");
		System.out.println("过滤器初始化方法");
	}

}
