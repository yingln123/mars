package com.ning.common.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet中的过滤器Filter是实现了javax.servlet.Filter接口的服务器端程序，主要的用途是过滤字符编码、做一些业务逻辑判断等。
 * 其工作原理是:只要你在web.xml文件配置好要拦截的客户端请求，它都会帮你拦截到请求，此时你就可以对请求或响应(Request、Response)统一设置编码，
 * 简化操作；同时还可进行逻辑判断，如用户是否已经登陆、有没有权限访问该页面等等工作。它是随你的web应用启动而启动的，只初始化一次，以后就可以拦截相关请求，
 * 只有当你的web应用停止或重新部署的时候才销毁
 * 
 */
public class MyFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("劳资要挂了");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("来活了");

		//HttpSession session = request.getServletContext().getses
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Enumeration<String> sessions = session.getAttributeNames();
		
		while(sessions.hasMoreElements()){
			
			String sessionName = sessions.nextElement();
			
			System.out.println("sessionName : " + sessionName + "  value: " + session.getAttribute(sessionName));
		}
		
		session.setAttribute("demo", "demo");
		
		 chain.doFilter(request,response);  
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("劳资要活了");

	}

}
