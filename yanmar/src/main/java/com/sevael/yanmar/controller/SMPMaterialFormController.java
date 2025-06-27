package com.sevael.yanmar.controller;

import com.sevael.yanmar.service.SMPMaterialFormService;
import com.sevael.yanmar.dto.SMPWrapperDTO;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/yanmar/material")
public class SMPMaterialFormController {
	
	@Autowired
	private SMPMaterialFormService materialformservice;
	
	@PostMapping(value = "/submit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> submitEntry(
			@RequestPart("materialform") String materialformJson,
            @RequestPart(value = "vendorAttachments", required = false) List<MultipartFile> vendorAttachments){
		
//		materialformservice.saveEntry(Submission.getMaterialform());
		
//		materialformservice.saveEntry(materialForm);

        
//		return ResponseEntity.ok("Data saved successfully");
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);
            
            SMPWrapperDTO materialForm = mapper.readValue(materialformJson, SMPWrapperDTO.class);
            materialForm.setVendorAttachments(vendorAttachments);

            materialformservice.saveEntry(materialForm);
            return ResponseEntity.ok("Data saved successfully");
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Invalid JSON or File Error: " + e.getMessage());
        }
	}
}
