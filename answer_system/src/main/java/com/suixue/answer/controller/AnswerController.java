package com.suixue.answer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suixue.common.BaseController;

@Controller
@RequestMapping("/answer")
public class AnswerController extends BaseController{
	
	@RequestMapping(value="/answerList",method=RequestMethod.GET)
	public String getAnswerList() {
		return "answerList";
	}
	
	@RequestMapping(value="/answerList",method=RequestMethod.POST)
	@ResponseBody
	public String getAnswerListData() {
		
		
		return "asnwerList";
	}
}
