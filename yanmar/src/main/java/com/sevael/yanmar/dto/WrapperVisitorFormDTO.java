package com.sevael.yanmar.dto;

public class WrapperVisitorFormDTO {
	private Long appointment_id;
	
	private VVisitorDetailsDTO user;
	private VDeviceDetailsDTO device;
//	private VVehicleDetailsDTO vehicle;
	
	public VVisitorDetailsDTO getUser() {
		return user;
	}
	public void setUser(VVisitorDetailsDTO user) {
		this.user = user;
	}
	public VDeviceDetailsDTO getDevice() {
		return device;
	}
	public void setDevice(VDeviceDetailsDTO device) {
		this.device = device;
	}

	public Long getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(Long appointment_id) {
		this.appointment_id = appointment_id;
	}
	
	
	
}
