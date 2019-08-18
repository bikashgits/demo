package com.test.poc.exception.handler;

public class ResponseError {
	
	private String errMessage;
	private String errCode;
	public String getErrMessage() {
		return errMessage;
	}
	public ResponseError(String errMessage, String errCode) {
		super();
		this.errMessage = errMessage;
		this.errCode = errCode;
	}
	
	

}
