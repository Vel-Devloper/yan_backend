package com.sevael.yanmar.controller;

import com.sevael.yanmar.service.VisitorFormService;
import com.sevael.yanmar.dto.VisitorSubmissionDTO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/yanmar/visitor")
public class VisitorFormController {
	
	@Autowired
	private VisitorFormService visitorformService;
	
	@PostMapping("/submit")
    public ResponseEntity<String> submitEntry(@RequestBody VisitorSubmissionDTO Submission) {
		visitorformService.saveEntry(Submission);
	    return ResponseEntity.ok("Data saved successfully");
    }
}