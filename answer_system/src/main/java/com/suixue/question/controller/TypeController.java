package com.suixue.question.controller;

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
import com.suixue.question.domain.Type;
import com.suixue.question.service.TypeService;

@Controller
@RequestMapping("/type")
public class TypeController extends BaseController  {
	
	@Autowired
	private TypeService typeService;
	
	/**
	 * 查询所有的问题类型列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/query/all/type", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse queryAllQuestionType() throws Exception{
		List<Type> allQuestionTypeList = typeService.getList();
        return success(allQuestionTypeList);
	}
	
	/**
	 * 根据问题类型IDs查询问题类型列表
	 * @param typeIds
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/query/param", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse queryQuestionTypesByParam(String typeIds, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		List<Type> questionTypesList = typeService.queryQuestionTypeIdsByParam(typeIds);
        return success(questionTypesList);
	}
	
	/**
	 * 插入一条新的问题类型
	 * @param type
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse insert(Type type, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		typeService.insert(type);		
		return success(type);
	}
	
	/**
	 * 更新问题类型
	 * @param type
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse update(Type type, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		typeService.update(type);		
		return success(type);
	}
	
	/**
	 * 删除一个问题类型
	 * @param type
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse delete(Type type, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		typeService.delete(type);	
		return success(type);
	}
}
