package com.sevael.yanmar.dto;

public class ExtLoginResponse {
	private String message;
	
	// constructors
	public ExtLoginResponse() {}
	
	public ExtLoginResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
