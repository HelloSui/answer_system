package com.suixue.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suixue.common.BaseController;
import com.suixue.common.BaseResponse;
import com.suixue.common.ReturnCode;
import com.suixue.user.domain.User;
import com.suixue.user.domain.UserRole;
import com.suixue.user.service.UserRoleService;
import com.suixue.user.service.UserService;

@Controller
@RequestMapping("/user")
public class LoginController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;

	@RequestMapping(value="/login")
	public String getLogin() {
		return "login";
	}
	
	@ResponseBody
	@RequestMapping(value = "/loginData", method = RequestMethod.POST)
	public BaseResponse validateLogin(User user, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		User userResult = userService.get(user);

		//验证失败
		if (userResult == null) {
			return new BaseResponse(ReturnCode.LOGIN_FAILURE);
		}
		
		//存放session
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute(userResult.getId());
		if(loginUser == null) {
			session.setAttribute("user", userResult);
		}
		//登录成功，跳转至主页面
		
		return success(loginUser);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User user,String roleId, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		
		User userTmp = new User();
		userTmp.setName(user.getName());
		User userResult = userService.get(userTmp);

		//验证失败
		if (userResult != null) {
			return "redirect:login";
		}
		
		userService.insert(user);
		UserRole param = new UserRole();
		param.setRoleId(roleId);
		param.setUserId(user.getId());
		userRoleService.insert(param);
		
		return "redirect:home";
	}
	@ResponseBody
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public BaseResponse logout(String userId, HttpServletRequest request,
			HttpServletResponse response) {
		
		//存放session
		//注销
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		
		return success();
	}
}
