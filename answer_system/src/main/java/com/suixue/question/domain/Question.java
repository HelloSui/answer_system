package com.suixue.question.domain;

import com.suixue.common.DataEntity;

public class Question extends DataEntity{
	private String description;
	private String title;
	private String typeId;
	private String createUserId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
