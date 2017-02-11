package com.suixue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

	@RequestMapping("/ask")
	public String askQuestion() {
		return "ask";
	}

	@RequestMapping("/answer")
	public String answerQuestion() {
		return "answer";
	}
}
