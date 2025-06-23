package com.sevael.yanmar.controller;

import com.sevael.yanmar.service.SMPMaterialFormService;
import com.sevael.yanmar.dto.SMPSubmissionDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/yanmar/material")
public class SMPMaterialFormController {
	
	@Autowired
	private SMPMaterialFormService materialformservice;
	
	@PostMapping("/submit")
	public ResponseEntity<String> submitEntry(@RequestBody SMPSubmissionDTO Submission){
		materialformservice.saveEntry(Submission.getMaterialform());
		return ResponseEntity.ok("Data saved successfully");
	}
}
