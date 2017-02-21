package com.suixue.user.domain;

import com.suixue.common.DataEntity;

public class Role extends DataEntity {
	
	private String description;
	
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

	@Override
	public String toString() {
		return "Role [id=" + id + ", description=" + description + "]";
	}
	
}
