package com.sevael.yanmar.dto;

public class VVehicleDetailsDTO {
	private String vehicle_no;
	private String model;
	private String type;
	
//	Constructors
	public VVehicleDetailsDTO() {}
	
	public VVehicleDetailsDTO(String vehicle_no,String model,String type) {
		this.vehicle_no = vehicle_no;
		this.model = model;
		this.type = type;
	}

	public String getVehicle_no() {
		return vehicle_no;
	}

	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
