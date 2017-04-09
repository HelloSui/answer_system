package com.suixue.question.domain;

import com.suixue.common.DataEntity;
import com.suixue.discuss.domain.Discuss;

public class Question extends DataEntity{
	private String description;
	private String title;
	//1,2,3
	private String typeId;
	private String createUserId;
	
	//赞同数最多的一个回答
	private Discuss bestDiscuss;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Discuss getBestDiscuss() {
		return bestDiscuss;
	}
	public void setBestDiscuss(Discuss bestDiscuss) {
		this.bestDiscuss = bestDiscuss;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", description=" + description + ", title=" + title + ", typeId=" + typeId + ", createUserId=" + createUserId + "]";
	}
	
}
