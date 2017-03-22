package com.suixue.common;

public class BaseResponse {
	//返回码
	private String retCode;
	//返回描述
	private String retDesc;
	
	//返回值
	private Object value;
	
	public BaseResponse(ReturnCode retCode) {
		this.retCode = retCode.getRetCode();
		this.retDesc = retCode.getRetDesc();
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

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
