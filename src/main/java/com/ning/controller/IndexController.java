package com.ning.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ning.service.LoginService;
import com.ning.service.UserService;

@Controller
@RequestMapping("/index1")
public class IndexController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginService loginService;
	
	
	public IndexController() {
		
		System.out.println("init index controller");
	}
	@RequestMapping("/home")
	public String home(Model model, HttpServletRequest request, String name, String password){
		
		System.out.println("welcome to -java !!订单订单");
		
		this.userService.addUser(name, password);
		
		this.loginService.login();
		
		return "/index";
	}
}
