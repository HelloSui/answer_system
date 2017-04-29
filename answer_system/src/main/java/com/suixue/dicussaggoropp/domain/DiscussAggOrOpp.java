package com.suixue.dicussaggoropp.domain;

import com.suixue.common.DataEntity;

public class DiscussAggOrOpp extends DataEntity{
	private String discussId;
	private String userId;
	private int agreeOrOppose;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

	public String getDiscussId() {
		return discussId;
	}

	public void setDiscussId(String discussId) {
		this.discussId = discussId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getAgreeOrOppose() {
		return agreeOrOppose;
	}

	public void setAgreeOrOppose(int agreeOrOppose) {
		this.agreeOrOppose = agreeOrOppose;
	}

	@Override
	public String toString() {
		return "Discuss [id=" + id + ", discussId=" + discussId + ", userId=" + userId +  ", agreeOrOppose=" + agreeOrOppose + "]";
	}
	
}
