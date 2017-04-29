package com.suixue.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suixue.common.BaseController;

@Controller
public class HomeController extends BaseController{ 

	
	@RequestMapping(value={"/", "/home"},method=RequestMethod.GET)
	public String getHomePage() {
		
		return "home";
	}
	
}
