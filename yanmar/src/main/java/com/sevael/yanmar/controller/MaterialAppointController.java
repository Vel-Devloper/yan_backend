package com.sevael.yanmar.controller;

import com.sevael.yanmar.dto.MatAppointDisplayDTO;
import com.sevael.yanmar.dto.MaterialAppointRequest;
import com.sevael.yanmar.dto.MaterialAppointResponse;

import com.sevael.yanmar.service.MaterialAppointService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/yanmar/internal/admin")
public class MaterialAppointController {
	
	@Autowired
	private MaterialAppointService materialappointservice;
	
	@PostMapping("/materialpass")
	public ResponseEntity<MaterialAppointResponse> createAppointment(@RequestBody MaterialAppointRequest request){
		MaterialAppointResponse response = materialappointservice.saveEntry(request);
		return ResponseEntity.ok(response);
	}
	
	 @GetMapping("/material-appointment-list")
	    public List<MatAppointDisplayDTO> getAllAppointments() {
	        return materialappointservice.getAllAppointments();
	}
}
