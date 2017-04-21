package com.suixue.discuss.domain;

import java.util.ArrayList;
import java.util.List;

import com.suixue.common.DataEntity;

public class AnswerList extends DataEntity{
	private String answerUserId;
	private String answerUserName;
	private String answerContent;
	private String agreeTimes;
	private String opposeTimes;
	private String lastLevel;
	private int answerNum;
	private List<Discuss> discussList = new ArrayList<>();
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getAnswerUserId() {
		return answerUserId;
	}

	public void setAnswerUserId(String answerUserId) {
		this.answerUserId = answerUserId;
	}

	public String getAnswerUserName() {
		return answerUserName;
	}

	public void setAnswerUserName(String answerUserName) {
		this.answerUserName = answerUserName;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	
	public int getAnswerNum() {
		return answerNum;
	}

	public void setAnswerNum(int answerNum) {
		this.answerNum = answerNum;
	}

	public List<Discuss> getDiscussList() {
		return discussList;
	}

	public void setDiscussList(List<Discuss> discussList) {
		this.discussList = discussList;
	}

	public String getAgreeTimes() {
		return agreeTimes;
	}
	public void setAgreeTimes(String agreeTimes) {
		this.agreeTimes = agreeTimes;
	}
	public String getOpposeTimes() {
		return opposeTimes;
	}
	public void setOpposeTimes(String opposeTimes) {
		this.opposeTimes = opposeTimes;
	}
	
	public String getLastLevel() {
		return lastLevel;
	}

	public void setLastLevel(String lastLevel) {
		this.lastLevel = lastLevel;
	}

	@Override
	public String toString() {
		return "Discuss [id=" + id + ", answerUserId=" + answerUserId + ", answerUserName=" + answerUserName + ", answerContent=" + answerContent + ",agreeTimes=" + agreeTimes + ",opposeTimes=" + opposeTimes + ",lastLevel=" + lastLevel + ",answerNum=" + answerNum + ", discussList=" + discussList + "]";
	}
	
}
