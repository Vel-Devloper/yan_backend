package com.sevael.yanmar.dto;

public class IntRegisterRequest {
	private String username;
	private String uniqueid;
	private String password;
	private int isactive;
	private int usertype;
	
//	Constructors
	public IntRegisterRequest() {}
	
	public IntRegisterRequest(String username, String uniqueid, String password, int isactive, int usertype) 
	{
		this.username = username;
		this.uniqueid = uniqueid;
		this.password = password;
		this.isactive = isactive;
		this.usertype = usertype;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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

	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
}
