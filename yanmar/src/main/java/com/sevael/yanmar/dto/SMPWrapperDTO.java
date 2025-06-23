package com.sevael.yanmar.dto;

import java.util.List;

public class SMPWrapperDTO {
	
	private SMPDriverDetailsDTO driver;
	private List<SMPItemDetailsDTO> items;
	private SMPOtherDetailsDTO otherdetails;
	private SMPRequestorDetailsDTO requestordetails;
	private SMPSupplierDetailsDTO supplierdetails;
	private SMPVehicleDetailsDTO vehicle;
	
	public SMPDriverDetailsDTO getDriver() {
		return driver;
	}
	public void setDriver(SMPDriverDetailsDTO driver) {
		this.driver = driver;
	}
	public List<SMPItemDetailsDTO> getItems() {
		return items;
	}
	public void setItems(List<SMPItemDetailsDTO> items) {
		this.items = items;
	}
	public SMPOtherDetailsDTO getOtherdetails() {
		return otherdetails;
	}
	public void setOtherdetails(SMPOtherDetailsDTO otherdetails) {
		this.otherdetails = otherdetails;
	}
	public SMPRequestorDetailsDTO getRequestordetails() {
		return requestordetails;
	}
	public void setRequestordetails(SMPRequestorDetailsDTO requestordetails) {
		this.requestordetails = requestordetails;
	}
	public SMPSupplierDetailsDTO getSupplierdetails() {
		return supplierdetails;
	}
	public void setSupplierdetails(SMPSupplierDetailsDTO supplierdetails) {
		this.supplierdetails = supplierdetails;
	}
	public SMPVehicleDetailsDTO getVehicle() {
		return vehicle;
	}
	public void setVehicle(SMPVehicleDetailsDTO vehicle) {
		this.vehicle = vehicle;
	}
}
