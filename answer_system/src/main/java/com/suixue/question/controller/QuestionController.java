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
import com.suixue.question.domain.Question;
import com.suixue.question.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionController extends BaseController  {
	
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value = "/query/all", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse queryAllQuestion() throws Exception{
		List<Question> allQuestionList = questionService.getList();
        return success(allQuestionList);
	}
	
	@RequestMapping(value = "/query/param", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse queryQuestionsByParam(Question question, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		List<Question> questionList = questionService.queryQuestionsByParam(question);
        return success(questionList);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse insert(Question question, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		questionService.insert(question);		
		return success(question);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse update(Question question, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		questionService.update(question);		
		return success(question);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse delete(Question question, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		questionService.delete(question);		
		return success(question);
	}
	
	@RequestMapping(value = "/ask", method = RequestMethod.GET)
	public String askQuestion(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		
		return "ask";
	}
}
