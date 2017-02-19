package com.suixue.question.controller;

import java.util.ArrayList;
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
	
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse queryAllQuestion() throws Exception{
		//List<Question> allQuestionList = questionService.getList();
		List<Question> allQuestionList = new ArrayList<>();
        return success(allQuestionList);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String register(Question question, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		
		Question questionTemp = new Question();
		questionService.insert(questionTemp);
		
		return "redirect:login";
	}
	
	@RequestMapping(value = "/ask", method = RequestMethod.GET)
	public String askQuestion(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		
		return "ask";
	}
}
