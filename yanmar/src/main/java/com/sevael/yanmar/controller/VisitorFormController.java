package com.sevael.yanmar.controller;

import com.sevael.yanmar.service.VisitorFormService;
import com.sevael.yanmar.dto.VisitorSubmissionDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/yanmar/visitor")
public class VisitorFormController {
	
	@Autowired
	private VisitorFormService visitorformService;
	
	@PostMapping(value = "/submit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> submitEntry(@RequestBody VisitorSubmissionDTO Submission,
    		@RequestPart("photoFiles") List<MultipartFile> photoFiles) {
		
		visitorformService.saveEntry(Submission,photoFiles);
	    return ResponseEntity.ok("Data saved successfully");
    }
}