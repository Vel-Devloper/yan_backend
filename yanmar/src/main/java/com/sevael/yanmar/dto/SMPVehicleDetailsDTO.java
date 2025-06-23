package com.sevael.yanmar.dto;

public class SMPVehicleDetailsDTO {
	private String vehilce_no;
	private String vehicle_type;
	
	private SMPVehicleDetailsDTO() {}
	
	private SMPVehicleDetailsDTO(String vehilce_no,String vehicle_type) {
		this.vehicle_type = vehicle_type;
		this.vehilce_no = vehilce_no;
	}

	public String getVehilce_no() {
		return vehilce_no;
	}

	public void setVehilce_no(String vehilce_no) {
		this.vehilce_no = vehilce_no;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
}
