package com.zdy.cn.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class Listener implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("监听到回话增加新的属性:"+event.getName()+"，值："+event.getValue());
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("监听到回话删除属性:"+event.getName()+"，值："+event.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("监听到回话修改属性："+event.getName()+"，值："+event.getValue());
	}

}
