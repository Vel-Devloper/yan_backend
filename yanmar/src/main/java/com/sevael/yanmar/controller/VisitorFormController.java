package com.sevael.yanmar.controller;

import com.sevael.yanmar.service.VisitorFormService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevael.yanmar.dto.VisitorFullDetailsDTO;
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
    public ResponseEntity<String> submitEntry(
    		@RequestPart("visitorData") String visitorDataJson,
    		@RequestPart("photoFiles") List<MultipartFile> photoFiles) {
		
//		visitorformService.saveEntry(Submission,photoFiles);
//	    return ResponseEntity.ok("Data saved successfully");
	    
		try {
            // Convert JSON string to DTO
            ObjectMapper objectMapper = new ObjectMapper();
            VisitorSubmissionDTO submission = objectMapper.readValue(visitorDataJson, VisitorSubmissionDTO.class);

            // Pass to service
            visitorformService.saveEntry(submission, photoFiles);
            return ResponseEntity.ok("Data saved successfully with photos");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error processing visitor data: " + e.getMessage());
        }
    }
		
	@GetMapping("/details/{appointmentId}")
	public ResponseEntity<List<VisitorFullDetailsDTO>> getDetails(@PathVariable Long appointmentId) {
	    List<VisitorFullDetailsDTO> data = visitorformService.getAllVisitorDetailsByAppointment(appointmentId);
	    return ResponseEntity.ok(data);
	}
	
}