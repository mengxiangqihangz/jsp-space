package com.zdy.cn.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class LoginListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("�����Ự��ӵ����Ժ�ֵ��"+event.getName()+":"+event.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("�����Ựɾ�������Ժ�ֵ��"+event.getName()+":"+event.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("�����Ự�޸ĵ����Ժ�ֵ��"+event.getName()+":"+event.getValue());
	}

}
