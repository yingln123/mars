package com.ning.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ning.common.annotation.ActionControllerLog;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/login")
	@ActionControllerLog(action="登录系统", isSaveRequestData=true)
	public String login(HttpServletRequest request, Model model){
		
		HttpSession session = request.getSession();

		session.setAttribute("USER_TOKEN", "USER_TONKEN");
		
		return "/index";
	}
}
