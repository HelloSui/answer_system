package com.suixue.common;

public class BaseController {
	
	/**
	 * 返回成功
	 * @return
	 */
	public BaseResponse success(){
		BaseResponse rsp = new BaseResponse(ReturnCode.SUCCESS);
		return rsp;
	} 
	
	public BaseResponse failure(){
		BaseResponse rsp = new BaseResponse(ReturnCode.FAILURE);
		return rsp;
	} 
}
