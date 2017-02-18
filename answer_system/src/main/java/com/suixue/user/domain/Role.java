package com.suixue.user.domain;

import com.suixue.common.DataEntity;

public class Role extends DataEntity {
	
	private String desc;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", desc=" + desc + "]";
	}
	
}
