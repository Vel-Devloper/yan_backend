package com.sevael.yanmar.dto;

import java.util.List;


public class VisitorSubmissionDTO {
	private String token;              // ✅ For Scenario 1 (email link)
    private Long appointmentId;        // ✅ For Scenario 2 (manual form)
    
	private List<WrapperVisitorFormDTO> visitorList;
	private List<VVehicleDetailsDTO> vehicleList;

	public List<WrapperVisitorFormDTO> getVisitorList() {
		return visitorList;
	}

	public void setVisitorList(List<WrapperVisitorFormDTO> visitorList) {
		this.visitorList = visitorList;
	}

	public List<VVehicleDetailsDTO> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<VVehicleDetailsDTO> vehicleList) {
		this.vehicleList = vehicleList;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}
	
}