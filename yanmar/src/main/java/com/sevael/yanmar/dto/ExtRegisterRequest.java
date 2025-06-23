package com.sevael.yanmar.dto;

public class ExtRegisterRequest {
	private String username;
	private String vendorid;
	private String password;
	private String vendor_name;
	private int isactive;
//	Constructors
	public ExtRegisterRequest() {}
	
	public ExtRegisterRequest(String username,String vendorid,String password, String vendor_name , int isactive) {
		this.username = username;
		this.vendorid = vendorid;
		this.password = password;
		this.vendor_name = vendor_name;
		this.isactive = isactive;
	}
//	Getters & Setters

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getVendorid() {
		return vendorid;
	}

	public void setVendorid(String vendorid) {
		this.vendorid = vendorid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVendor_name() {
		return vendor_name;
	}

	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}

	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}
	
}
