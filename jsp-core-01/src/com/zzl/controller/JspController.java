package com.zzl.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JspController extends HttpServlet{
	
	
	
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/index.jsp");
		List<String> list = new ArrayList<String>();
		list.add("zhangsan");
		list.add("lisi");
		list.add("wangwu");
		list.add("zhaoliu");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "zhangsan");
		map.put("age", "19");
		map.put("sex", "男");
		map.put("love", "羽毛球");
		
		
		
		req.setAttribute("list", list);
		req.setAttribute("map", map);
		dispatcher.forward(req, resp);
		
	}
	
	
	
}
