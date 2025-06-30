package com.sevael.yanmar.controller;

import com.sevael.yanmar.dto.AppointRequest;
import com.sevael.yanmar.dto.AppointResponse;
import com.sevael.yanmar.dto.AppointmentDisplayDTO;
import com.sevael.yanmar.dto.SecurityViewDTO;
import com.sevael.yanmar.dto.VApprovalStatusDTO;
import com.sevael.yanmar.dto.VCheckInOutUpdateDTO;
import com.sevael.yanmar.entity.VisitorAppoint;
import com.sevael.yanmar.service.VisitAppointService;
import com.sevael.yanmar.repository.AppointRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/yanmar/internal")
public class VisitorAppointController {
	
	@Autowired
	private VisitAppointService visitappointService;
	
	@Autowired
	private AppointRepo appointrepo;
	
	@PostMapping("/admin/visitorpass")
	public ResponseEntity<AppointResponse> createAppointment(@RequestBody AppointRequest request){
		AppointResponse response = visitappointService.createAppointment(request);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/admin/appointment")
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
	
//	@GetMapping("/admin/all-appointments")
//    public ResponseEntity<List<AppointmentDisplayDTO>> getTableData(@RequestParam int approval_status) {
//		
//        return ResponseEntity.ok(visitappointService.getDisplayAppointments());
//    }
	
	@GetMapping("/admin/all-appointments")
	public ResponseEntity<List<AppointmentDisplayDTO>> getTableData() {
	    return ResponseEntity.ok(visitappointService.getDisplayAppointments());
	}
	
	@PutMapping("/security/appointments/{appointmentId}/checkin")
	public ResponseEntity<String> updateCheckInForGroup(
	        @PathVariable Long appointmentId,
	        @RequestBody VCheckInOutUpdateDTO dto) {

		visitappointService.updateCheckInForAll(appointmentId, dto.getCheckin());
	    return ResponseEntity.ok("Check-in time updated for all visitors under appointment " + appointmentId);
	}
	
	@PutMapping("/security/appointments/{appointmentId}/checkout")
	public ResponseEntity<String> updateCheckoutForGroup(
	        @PathVariable Long appointmentId,
	        @RequestBody VCheckInOutUpdateDTO dto) {

		visitappointService.updateCheckoutForAll(appointmentId, dto.getCheckout());
	    return ResponseEntity.ok("Checkout time updated successfully.");
	}
	
//	@PutMapping("/appointments/{appointmentId}/accept")
//	public ResponseEntity<String> acceptAppointment(@PathVariable Long appointmentId) {
//		visitappointService.updateApprovalStatusForAppointment(appointmentId, 1);
//	    return ResponseEntity.ok("Appointment accepted.");
//	}
//
//	@PutMapping("/appointments/{appointmentId}/reject")
//	public ResponseEntity<String> rejectAppointment(@PathVariable Long appointmentId) {
//		visitappointService.updateApprovalStatusForAppointment(appointmentId, 2);
//	    return ResponseEntity.ok("Appointment rejected.");
//	}
	
	@PutMapping("/admin/appointments/approval")
	public ResponseEntity<String> updateAppointmentApprovalStatus(
	        @RequestParam Long appointmentId,
	        @RequestParam int status) {

	    visitappointService.updateApprovalStatusForAppointment(appointmentId, status);
	    return ResponseEntity.ok("Appointment status updated.");
	}
	
	@GetMapping("security/approved")
    public List<SecurityViewDTO> getApprovedAppointments() {
        return visitappointService.getDisplayapprovedAppoint();
    }
}
