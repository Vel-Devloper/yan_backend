package com.sevael.yanmar.dto;

public class ExtLoginResponse {
	private String token;
	private boolean success;
	
	// constructors
	public ExtLoginResponse() {}
	
	public ExtLoginResponse(String token,boolean success) {
		this.token = token;
		this.success = success;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
