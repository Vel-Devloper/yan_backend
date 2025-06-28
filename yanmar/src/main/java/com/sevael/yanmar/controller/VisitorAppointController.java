package com.sevael.yanmar.controller;

import com.sevael.yanmar.dto.AppointRequest;
import com.sevael.yanmar.dto.AppointResponse;
import com.sevael.yanmar.entity.VisitorAppoint;
import com.sevael.yanmar.service.VisitAppointService;
import com.sevael.yanmar.repository.AppointRepo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/yanmar/internal/admin")
public class VisitorAppointController {
	
	@Autowired
	private VisitAppointService visitappointService;
	
	@Autowired
	private AppointRepo appointrepo;
	
	@PostMapping("/visitorpass")
	public ResponseEntity<AppointResponse> createAppointment(@RequestBody AppointRequest request){
		AppointResponse response = visitappointService.createAppointment(request);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/appointment")
	public ResponseEntity<VisitorAppoint> getAppointmentByToken(@RequestParam String token) {
	    Optional<VisitorAppoint> appointment = appointrepo.findBytoken(token);
	    if (appointment.isPresent()) {
	        return ResponseEntity.ok(appointment.get());
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
//		try {
//	        Optional<VisitorAppoint> appointment = appointrepo.findByUuidtoken(token);
//	        return appointment.map(ResponseEntity::ok)
//	                          .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
//	    } catch (Exception e) {
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//	    }
	}
}
