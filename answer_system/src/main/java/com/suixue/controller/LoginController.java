package com.suixue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	@RequestMapping("/login")
	public String getLogin()
	{
		return "login";
	}
}


