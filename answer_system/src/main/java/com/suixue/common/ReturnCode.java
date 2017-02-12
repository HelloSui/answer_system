package com.suixue.common;

public enum ReturnCode {

	SUCCESS("0", "success"),
	
	FAILURE("-1", "oper failure"),
	
	LOGIN_FAILURE("2017001", "username or password is not correct!"),
	
	REGISTER_FAILURE("2017002", "register failure!");

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
