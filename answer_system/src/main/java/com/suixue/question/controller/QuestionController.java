package com.suixue.question.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suixue.common.BaseController;
import com.suixue.question.domain.Question;
import com.suixue.question.service.QuestionService;
import com.suixue.user.domain.User;

@Controller
@RequestMapping("/question")
public class QuestionController extends BaseController  {
	
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public List<Question> queryAllQuestion() throws Exception{
		List<Question> allQuestionList = questionService.getList();
        return allQuestionList;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String register(Question question, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		
		Question questionTemp = new Question();
		questionService.insert(questionTemp);
		
		return "redirect:login";
	}
}
