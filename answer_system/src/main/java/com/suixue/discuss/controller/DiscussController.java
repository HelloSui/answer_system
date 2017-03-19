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
	
	/**
	 * 查询所有讨论列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/query/all", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse queryAllDiscuss() throws Exception{
		List<Discuss> allDiscussList = discussService.getList();
        return success(allDiscussList);
	}
	
	/**
	 * 根据相应参数查询相应的讨论列表
	 * @param discuss
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/query/param", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse queryDiscusssByParam(Discuss discuss, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		List<Discuss> discussList = discussService.queryDiscussesByParam(discuss);
        return success(discussList);
	}
	
	/**
	 * 插入一条新的讨论记录
	 * @param discuss
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse insert(Discuss discuss, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		discussService.insert(discuss);		
		return success(discuss);
	}
	
	/**
	 * 更新一条讨论记录
	 * @param discuss
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse update(Discuss discuss, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		discussService.update(discuss);		
		return success(discuss);
	}
	
	/**
	 * 根据讨论id删除一条讨论记录
	 * @param discuss
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse delete(Discuss discuss, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		discussService.delete(discuss);		
		return success(discuss);
	}
	
	/**
	 * 删除某一个问题的所有讨论，请求参数为问题ID
	 * @param questionId
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/deleteByQuestionId", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse deleteByQuestionId(String questionId, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		discussService.deleteByQuestionId(questionId);		
		return success("删除成功");
	}
	
	
}
