package com.sevael.yanmar.dto;

public class SMPDriverDetailsDTO {
	private String driver_name;
	private Long phone_no;
	private String license_no;
	
	private SMPDriverDetailsDTO() {}
	
	private SMPDriverDetailsDTO(String driver_name,Long phone_no,String license_no) {
		this.driver_name = driver_name;
		this.phone_no = phone_no;
		this.license_no = license_no;
	}

	public String getDriver_name() {
		return driver_name;
	}

	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}

	public Long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(Long phone_no) {
		this.phone_no = phone_no;
	}

	public String getLicense_no() {
		return license_no;
	}

	public void setLicense_no(String license_no) {
		this.license_no = license_no;
	}
}
