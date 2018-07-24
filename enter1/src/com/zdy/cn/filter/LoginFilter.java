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
	static String ip=" ";
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String addr=request.getRemoteAddr();
		
		String[] ips=ip.split(",");
		boolean flag=false;
		if(addr.equals("0:0:0:0:0:0:0:1")){
			flag=true;
		}else{
			for (String string : ips) {
				if(string.equals(addr)){
					flag=true;
				}
			}
		}	
		boolean flag1=false;
		Object obj=((HttpServletRequest)request).getParameter("user");
		if(obj!=null){
			flag1=true;
		}
		
		if(flag&&flag1){
			System.out.println("÷¥––¡Àπ˝¬À”Ôæ‰");
			chain.doFilter(request, response);
		}else if(flag&&!flag1){
			request.getRequestDispatcher("log.html").forward(request, response);
		}else{
			request.getRequestDispatcher("error.html").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		ip=config.getInitParameter("ip");
	}

}
