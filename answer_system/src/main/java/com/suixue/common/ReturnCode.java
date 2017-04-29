package com.suixue.common;

public enum ReturnCode {

	SUCCESS("0", "success"),
	
	FAILURE("-1", "oper failure"),
	
	LOGIN_FAILURE("2017001", "username or password is not correct!"),
	
	REGISTER_FAILURE("2017002", "register failure!"),
	UPDATE_QUESTION_FAILURE("2017003","该问题已被回答，不能更改"),
	DELETE_QUESTION_FAILURE("2017004","该问题已被回答，不能删除"),
	DELETE_ANSWER_FAILURE("2017005","该回答已被回复，不能删除");

	private String retCode;
	private String retDesc;

	private ReturnCode(String retCode, String retDesc) {
		this.retCode = retCode;
		this.retDesc = retDesc;
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetDesc() {
		return retDesc;
	}

	public void setRetDesc(String retDesc) {
		this.retDesc = retDesc;
	}
}
