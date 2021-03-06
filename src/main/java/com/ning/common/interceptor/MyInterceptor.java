package com.ning.common.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器是在面向切面编程中应用的，就是在你的service或者一个方法前调用一个方法，或者在方法后调用一个方法。
 * 是基于JAVA的反射机制。拦截器不是在web.xml
 * 说一下拦截器和过滤器的区别
 * 	①拦截器是基于java的反射机制的，而过滤器是基于函数回调。
 *	②拦截器不依赖与servlet容器，过滤器依赖与servlet容器。
 *	③拦截器只能对action请求起作用，而过滤器则可以对几乎所有的请求起作用。
 *	④拦截器可以访问action上下文、值栈里的对象，而过滤器不能访问。
 *　	⑤在action的生命周期中，拦截器可以多次被调用，而过滤器只能在容器初始化时被调用一次。
 * 	
 *   下面用spring的拦截器写例子
 */
public class MyInterceptor implements HandlerInterceptor {

	/** 
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行， 
     * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。 
     */ 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception)
			throws Exception {

		System.out.println("MyInterceptor ==> afterCompletion");
	}
	/** 
     * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之 
     * 后，也就是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行，也就是说在这个方法中你可以对ModelAndView进行操 
     * 作。这个方法的链式结构跟正常访问的方向是相反的，也就是说先声明的Interceptor拦截器该方法反而会后调用，这跟Struts2里面的拦截器的执行过程有点像， 
     * 只是Struts2里面的intercept方法中要手动的调用ActionInvocation的invoke方法，Struts2中调用ActionInvocation的invoke方法就是调用下一个Interceptor 
     * 或者是调用action，然后要在Interceptor之前调用的内容都写在调用invoke之前，要在Interceptor之后调用的内容都写在调用invoke方法之后。 
     */ 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView arg3) throws Exception {
			
		System.out.println("MyInterceptor ==> postHandle");
		
	}

	/** 
     * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，SpringMVC中的Interceptor拦截器是链式的，可以同时存在 
     * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在 
     * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返 
     * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。 
     */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
	
		System.out.println("MyInterceptor ==> preHandle");		
		
		System.out.println("RequestURI ==> " + request.getRequestURI()); 	//RequestURI ==> /mars/css/style.css
		
		System.out.println("ContextPath ==> " + request.getContextPath()); 	//ContextPath ==> /mars
		
		System.out.println("PathInfo ==> " + request.getPathInfo()); 		//PathInfo ==> null
		
		System.out.println("ServletPath ==> " + request.getServletPath()); 	//ServletPath ==> /css/style.css
		
		System.out.println("RequestURL ==> " + request.getRequestURL());	//RequestURL ==> http://localhost:8080/mars/css/style.css
		
		//不拦截根路径
		if(request.getRequestURI().replaceAll("/", "").equals(request.getContextPath().replaceAll("/", ""))){
			return true;
		}
		
		//不拦截静态资源路径 可以实现配置化
		if(request.getServletPath().toUpperCase().startsWith("/CSS")){
			return true;
		}
		
		//不拦截登陆路径
		if(request.getServletPath().toUpperCase().startsWith("/USER/LOGIN")){
			return true;
		}
		
		System.out.println("MyInterceptor ==> preHandle == > 查看session列表");
		//查看session个中的键值列表
		HttpSession session = request.getSession();
		
		Enumeration<String> sessions = session.getAttributeNames();
		
		while(sessions.hasMoreElements()){
			
			String sessionName = sessions.nextElement();
			
			System.out.println("sessionName : " + sessionName + "  value: " + session.getAttribute(sessionName));
		}
		
		System.out.println(session.getAttribute("USER_TOKEN"));
		//判断登陆情况  
		if(session != null && session.getAttribute("USER_TOKEN") != null){
			
			return true;
		}else{
			//跳转到首页
			response.sendRedirect(request.getContextPath());
		}
		
		
		return false;
	}

}
