package com.sevael.yanmar.dto;

public class SMPVendorAttachmentDTO {
	
	private String filepath;
	
//	Constructors
	public SMPVendorAttachmentDTO() {}
	
	public SMPVendorAttachmentDTO(String filepath) {
		this.filepath=filepath;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	
}
