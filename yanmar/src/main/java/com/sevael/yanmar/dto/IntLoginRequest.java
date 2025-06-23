package com.sevael.yanmar.dto;

public class IntLoginRequest {
	private String uniqueid;
	private String password;
	
//	Constructors
	public IntLoginRequest() {}
	
	public IntLoginRequest(String uniqueid, String password) {
		this.uniqueid = uniqueid;
		this.password = password;
	}

	
//	Getters & Setters
	public String getUniqueid() {
		return uniqueid;
	}

	public void setUniqueid(String uniqueid) {
		this.uniqueid = uniqueid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
