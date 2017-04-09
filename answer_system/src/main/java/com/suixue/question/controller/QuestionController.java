package com.suixue.question.controller;

import java.util.List;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suixue.common.BaseController;
import com.suixue.common.BaseController;
import com.suixue.common.BaseResponse;
import com.suixue.common.BaseResponse;
import com.suixue.discuss.service.DiscussService;
import com.suixue.discuss.service.DiscussService;
import com.suixue.question.domain.Question;
import com.suixue.question.domain.Question;
import com.suixue.question.domain.Type;
import com.suixue.question.service.QuestionService;
import com.suixue.question.service.QuestionService;
import com.suixue.question.service.TypeService;
import com.suixue.user.domain.User;

@Controller
@RequestMapping("/question")
public class QuestionController extends BaseController  {
	
	@Autowired
	private QuestionService questionService;
	@Autowired
	private DiscussService discussService;
	@Autowired
	private TypeService typeService;
	
	/**
	 * 查询所有的问题列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/query/all", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse queryAllQuestion() throws Exception{
		List<Question> allQuestionList = questionService.getList();
        return success(allQuestionList);
	}
	
	/**
	 * 根据参数查询问题列表
	 * @param question
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/query/param", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse queryQuestionsByParam(Question question, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		List<Question> questionList = questionService.queryQuestionsByParam(question);
        return success(questionList);
	}
	
	/**
	 * 插入一条新问题
	 * @param question
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse insert(Question question, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		questionService.insert(question);		
		return success(question);
	}
	
	/**
	 * 更新一个问题记录
	 * @param question
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse update(Question question, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		questionService.update(question);		
		return success(question);
	}
	
	/**
	 * 删除一个问题记录，同时删除该问题的所有讨论列表
	 * @param question
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse delete(Question question, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		questionService.delete(question);
		discussService.deleteByQuestionId(question.getId());
		return success(question);
	}
	
	@RequestMapping(value = "/ask", method = RequestMethod.GET)
	public String askQuestion(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		if(currentUser == null) {
			currentUser = new User();
			currentUser.setId("123");
			currentUser.setName("suixue");
		}
		model.addAttribute("currentUser",currentUser);
		
		//将问题标签写入到jsp
		List<Type> allQuestionTypeList = typeService.getList();
		model.addAttribute("allQuestionType",allQuestionTypeList);
		
		return "ask";
	}
	
//	@RequestMapping(value = "/getQuestionListData", method = RequestMethod.GET)
//	@ResponseBody
//	public BaseResponse getQuestionList() {
//		
//	}
}

