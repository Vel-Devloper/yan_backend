package com.sevael.yanmar.dto;

public class VDeviceDetailsDTO {
	private String device_name;
	private String device_model;
	private String device_type;
	
//	Constructors
	public VDeviceDetailsDTO() {}
	
	public VDeviceDetailsDTO(String device_name,String device_model,String device_type) {
		this.device_name = device_name;
		this.device_model = device_model;
		this.device_type = device_type;
	}

//	Getters & Setters
	public String getDevice_name() {
		return device_name;
	}

	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}

	public String getDevice_model() {
		return device_model;
	}

	public void setDevice_model(String device_model) {
		this.device_model = device_model;
	}

	public String getDevice_type() {
		return device_type;
	}

	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}
	
	
}
