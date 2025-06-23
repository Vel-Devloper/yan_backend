package com.sevael.yanmar.dto;

public class SMPRequestorDetailsDTO {
	private String requestor_name;
	private String department;
	
	public SMPRequestorDetailsDTO() {}
	
	public SMPRequestorDetailsDTO(String requestor_name,String department) {
		this.requestor_name = requestor_name;
		this.department = department;
	}

	public String getRequestor_name() {
		return requestor_name;
	}

	public void setRequestor_name(String requestor_name) {
		this.requestor_name = requestor_name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
