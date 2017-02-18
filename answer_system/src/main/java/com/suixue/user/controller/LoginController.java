package com.suixue.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suixue.common.BaseController;
import com.suixue.user.domain.User;
import com.suixue.user.service.UserService;

@Controller
@RequestMapping("/user")
public class LoginController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLogin() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String validateLogin(User user, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		User userResult = userService.get(user);

		//验证失败
		if (userResult == null) {
			return "redirect:login";
		}
		
		//存放session
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute(userResult.getId());
		if(loginUser == null) {
			session.setAttribute(userResult.getId(), userResult);
		}
		//登录成功，跳转至主页面
		
		return "answer";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User user, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		
		User userTmp = new User();
		userTmp.setName(user.getName());
		User userResult = userService.get(userTmp);

		//验证失败
		if (userResult != null) {
			return "redirect:login";
		}
		
		userService.insert(user);
		
		return "redirect:login";
	}
}
