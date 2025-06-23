package com.sevael.yanmar.dto;

public class ExtLoginRequest {
	private String vendorid;
	private String username;
	private String password;
	
//	Constructors
	public ExtLoginRequest() {}
	
	public ExtLoginRequest(String vendorid,String username,String password) {
		this.vendorid = vendorid;
		this.username = username;
		this.password = password;
	}

//	Getters & Setters
	public String getVendorid() {
		return vendorid;
	}

	public void setVendorid(String vendorid) {
		this.vendorid = vendorid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
