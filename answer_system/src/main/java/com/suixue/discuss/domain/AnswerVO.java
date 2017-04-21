package com.suixue.discuss.domain;

import java.util.List;

import com.suixue.common.DataEntity;
import com.suixue.question.domain.Question;

public class AnswerVO{
	private Question question;
	private int answerNum;
	private List<AnswerList> answerList;
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public int getAnswerNum() {
		return answerNum;
	}

	public void setAnswerNum(int answerNum) {
		this.answerNum = answerNum;
	}

	public List<AnswerList> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<AnswerList> answerList) {
		this.answerList = answerList;
	}

	@Override
	public String toString() {
		return "Discuss [question=" + question +",answerNum=" + answerNum + ", answerList=" + answerList + "]";
	}
	
}
