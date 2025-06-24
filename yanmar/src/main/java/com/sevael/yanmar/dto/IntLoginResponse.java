package com.sevael.yanmar.dto;

public class IntLoginResponse {
	private String token; // instead of sending userId/name/role openly
    private boolean success;
	
//	Constructors
	public IntLoginResponse() {}
	
	public IntLoginResponse(String token,boolean success) {
		this.token = token;
		this.success = success;
	}
	
//	Getters & Setters
	
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
