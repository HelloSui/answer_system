package com.suixue.discuss.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suixue.common.BaseController;
import com.suixue.common.BaseResponse;
import com.suixue.discuss.domain.Discuss;
import com.suixue.discuss.service.DiscussService;

@Controller
@RequestMapping("/discuss")
public class DiscussController extends BaseController  {
	
	@Autowired
	private DiscussService discussService;
	
	@RequestMapping(value = "/query/all", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse queryAllDiscuss() throws Exception{
		List<Discuss> allDiscussList = discussService.getList();
        return success(allDiscussList);
	}
	
	@RequestMapping(value = "/query/param", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse queryDiscusssByParam(Discuss discuss, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		List<Discuss> discussList = discussService.queryDiscussesByParam(discuss);
        return success(discussList);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse insert(Discuss discuss, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		discussService.insert(discuss);		
		return success(discuss);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse update(Discuss discuss, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		discussService.update(discuss);		
		return success(discuss);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse delete(Discuss discuss, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		discussService.delete(discuss);		
		return success(discuss);
	}
}
