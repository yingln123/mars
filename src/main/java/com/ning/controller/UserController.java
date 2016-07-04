package com.ning.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model){
		
		HttpSession session = request.getSession();

		session.setAttribute("USER_TOKEN", "USER_TONKEN");
		
		return "/index";
	}
}
