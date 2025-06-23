package com.sevael.yanmar.dto;

public class IntLoginResponse {
	private String token; // instead of sending userId/name/role openly
    private String message;
	
//	Constructors
	public IntLoginResponse() {}
	
	public IntLoginResponse(String token,String message) {
		this.token = token;
		this.message = message;
	}
	
//	Getters & Setters
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
