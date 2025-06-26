package com.sevael.yanmar.dto;

import java.util.List;


public class VisitorSubmissionDTO {
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
}