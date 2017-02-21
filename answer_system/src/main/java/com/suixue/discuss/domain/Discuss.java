package com.suixue.discuss.domain;

import com.suixue.common.DataEntity;

public class Discuss extends DataEntity{
	private String questionId;
	private String speakerId;
	private String listnerId;
	private String content;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getSpeakerId() {
		return speakerId;
	}
	public void setSpeakerId(String speakerId) {
		this.speakerId = speakerId;
	}
	public String getListnerId() {
		return listnerId;
	}
	public void setListnerId(String listnerId) {
		this.listnerId = listnerId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Discuss [id=" + id + ", questionId=" + questionId + ", speakerId=" + speakerId + ", listnerId=" + listnerId + ", content=" + content + "]";
	}
	
}
