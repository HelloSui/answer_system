package com.suixue.question.domain;

import com.suixue.common.DataEntity;

public class Type extends DataEntity {
	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", description=" + description +"]";
	}
}
