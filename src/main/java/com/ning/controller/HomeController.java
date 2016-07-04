package com.ning.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ning.service.LoginService;
import com.ning.service.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginService loginService;
	
	
	public HomeController() {
		
		System.out.println("init index controller");
	}
	@RequestMapping("/index0")
	public String index0(Model model, HttpServletRequest request, String name, String password){
		
		System.out.println("welcome to -java !!订单订单");
		
		this.userService.addUser(name, password);
		
		this.loginService.login();
		
		
		//查看session
		HttpSession session = request.getSession();
		
		Enumeration<String> sessions = session.getAttributeNames();
		
		while(sessions.hasMoreElements()){
			
			String sessionName = sessions.nextElement();
			
			System.out.println("sessionName : " + sessionName + "  value: " + session.getAttribute(sessionName));
		}
		
		//----------------添加session
		session.setAttribute("demo", "demo1");
		
		//再次查看session
		
		while(sessions.hasMoreElements()){
			
			String sessionName = sessions.nextElement();
			
			System.out.println("sessionName : " + sessionName + "  value: " + session.getAttribute(sessionName));
		}
		
		return "/index";
	}
}
