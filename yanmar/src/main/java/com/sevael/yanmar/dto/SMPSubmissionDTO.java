package com.sevael.yanmar.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class SMPSubmissionDTO {
	 private SMPWrapperDTO materialform;
	 private List<MultipartFile> vendorAttachments;
	 

	public SMPWrapperDTO getMaterialform() {
		return materialform;
	}

	public void setMaterialform(SMPWrapperDTO materialform) {
		this.materialform = materialform;
	}

	public List<MultipartFile> getVendorAttachments() {
		return vendorAttachments;
	}

	public void setVendorAttachments(List<MultipartFile> vendorAttachments) {
		this.vendorAttachments = vendorAttachments;
		if (this.materialform != null) {
            this.materialform.setVendorAttachments(vendorAttachments);
        }
	}
	
	
	  
}
