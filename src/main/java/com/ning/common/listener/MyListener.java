package com.ning.common.listener;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 现在来说说Servlet的监听器Listener，它是实现了javax.servlet.ServletContextListener
 * 接口的服务器端程序，它也是随web应用的启动而启动，只初始化一次，随web应用的停止而销毁。主要作用是：
 * 做一些初始化的内容添加工作、设置一些基本的内容、比如一些参数或者是一些固定的对象等等
 * 
 */
public class MyListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("销毁工作完成...");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("应用监听器初始化工作开始...");
		System.out.println("");
		// 在整个web应用下面启动的时候做一些初始化的内容添加工作
		ServletContext sc = event.getServletContext();
		//遍历一下初始化参数 也就是我们在web.xml 中配置的context-param
		Enumeration<String> initParameter = sc.getInitParameterNames();

		while (initParameter.hasMoreElements()) {
			String parameterName = initParameter.nextElement();
			System.out.println("web init parameter name : " + parameterName
					+ " ; value : " + sc.getInitParameter(parameterName));
		}
		
		//向上下文中添加内容
		sc.setAttribute("name", "abcd");
		
		System.out.println("应用监听器初始化工作完成...");

	}

}
