package com.sevael.yanmar.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class SMPWrapperDTO {
	
	private SMPDriverDetailsDTO driver;
	private List<SMPItemDetailsDTO> items;
	private SMPOtherDetailsDTO otherdetails;
	private SMPRequestorDetailsDTO requestordetails;
	private SMPSupplierDetailsDTO supplierdetails;
	private SMPVehicleDetailsDTO vehicle;
	private Long mat_requestid;
	private String token;   
	private SMPWrapperDTO materialform;
	
	private List<MultipartFile> vendorAttachments;

	
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
	public List<MultipartFile> getVendorAttachments() {
		return vendorAttachments;
	}
	public void setVendorAttachments(List<MultipartFile> vendorAttachments) {
		this.vendorAttachments = vendorAttachments;
	}
	public Long getMat_requestid() {
		return mat_requestid;
	}
	public void setMat_requestid(Long mat_requestid) {
		this.mat_requestid = mat_requestid;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public SMPWrapperDTO getMaterialform() {
		return materialform;
	}
	public void setMaterialform(SMPWrapperDTO materialform) {
		this.materialform = materialform;
	}
	
	
}
