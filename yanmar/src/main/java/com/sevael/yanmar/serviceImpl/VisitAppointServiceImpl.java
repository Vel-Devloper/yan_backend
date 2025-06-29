package com.sevael.yanmar.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevael.yanmar.dto.AppointRequest;
import com.sevael.yanmar.dto.AppointResponse;
import com.sevael.yanmar.dto.AppointmentDisplayDTO;
import com.sevael.yanmar.dto.VCheckInOutUpdateDTO;
import com.sevael.yanmar.entity.AppointmentType;
import com.sevael.yanmar.entity.VisitorAppoint;
import com.sevael.yanmar.entity.VisitorUserDetailsForm;
import com.sevael.yanmar.repository.AppointRepo;
import com.sevael.yanmar.repository.AppointmentTypeRepo;
import com.sevael.yanmar.repository.VisitorDetailsRepository;
import com.sevael.yanmar.service.VisitAppointService;
import com.sevael.yanmar.util.EmailUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VisitAppointServiceImpl implements VisitAppointService {
	
	@Autowired
	private AppointRepo appointrepo;
	
	@Autowired
	private AppointmentTypeRepo appointtyperepo;
	
	@Autowired
	private VisitorDetailsRepository visitordetailsrepo;
	
	@Autowired
	private EmailUtil emailUtil;
	
//	private static final String BASE_URL = "http://yanmar.sevael.com/visitor/form";
	private static final String BASE_URL = "http://135.13.39.201:5173/#/visitor/form";
	
	@Override
	public AppointResponse createAppointment(AppointRequest dto) {
		VisitorAppoint visitorpass = new VisitorAppoint();
		
		AppointmentType appointmentType = appointtyperepo
		        .findById(dto.getAppointment_type())
		        .orElseThrow(() -> new RuntimeException("Invalid appointment type ID"));
		visitorpass.setAppointmentType(appointmentType);
		visitorpass.setDuration(dto.getDuration());
		visitorpass.setAppointment_date(dto.getAppointment_date());
		visitorpass.setVisitor_email(dto.getVisitor_email());
		visitorpass.setPurpose(dto.getPurpose());
		// Automatically decide request type
	    if (dto.getVisitor_email() == null || dto.getVisitor_email().isBlank()) {
	    	visitorpass.setRequest_type(2); // Manual
	    } else {
	    	visitorpass.setRequest_type(1); // Online
	    }
	    
	    if (dto.getAppointment_type() == 5) { // only for vendors
	    	visitorpass.setLocation(dto.getLocation());
	    } else {
	    	visitorpass.setLocation(0); // or skip if not needed
	    }
	    
	    String uuidToken = UUID.randomUUID().toString();
	    visitorpass.setToken(uuidToken);
	    
	    VisitorAppoint saved = appointrepo.save(visitorpass);
	    
//	    String requestTypeLabel = (saved.getRequest_type() == 1) ? "automatic" : "manual";
	    
//	    Generate Form Link
	    String formLink = null;
	    
	    if (saved.getVisitor_email() != null && !saved.getVisitor_email().isBlank()) {
	    	formLink = BASE_URL + "?token=" + saved.getToken();
	    	emailUtil.sendAppointmentLink(saved.getVisitor_email(), formLink);
	    }
	    
	    return new AppointResponse(
	    		saved.getId(),
	    		"Appointment created successfully",
	    		saved.getRequest_type(),
	            saved.getVisitor_email(),
	            saved.getAppointmentType().getAppointment_type(),
	            formLink,
	            saved.getAppointment_date(),
	            saved.getToken()
	    		);
	}
	@Override
	public List<AppointmentDisplayDTO> getDisplayAppointments() {
	    return appointrepo.fetchAppointmentsWithMainVisitors();
	}
	
	 @Override
	 public void updateCheckInForAll(Long appointmentId, LocalDateTime checkInTime) {
	     List<VisitorUserDetailsForm> visitors = visitordetailsrepo.findByVisitorAppoint_Id(appointmentId);
	
	     for (VisitorUserDetailsForm visitor : visitors) {
	    	    visitor.setCheckin(checkInTime);  //  checkInTime is LocalDateTime
	    	}
	
	    	// Save updated entity list
	     	visitordetailsrepo.saveAll(visitors);  //  now it's a list of entities
		 }
	 
	 @Override
	 public void updateCheckoutForAll(Long appointmentId, LocalDateTime checkoutTime) {
	     List<VisitorUserDetailsForm> visitors = visitordetailsrepo.findByVisitorAppoint_Id(appointmentId);

	     for (VisitorUserDetailsForm visitor : visitors) {
	         visitor.setCheckout(checkoutTime);
	     }

	     visitordetailsrepo.saveAll(visitors);
	 }
	 
	 @Override
	 public void updateApprovalStatusForAppointment(Long appointmentId, int approvalStatus) {
	     Optional<VisitorAppoint> optional = appointrepo.findById(appointmentId);
	     if (optional.isPresent()) {
	         VisitorAppoint appointment = optional.get();
	         appointment.setApproval_status(approvalStatus);
	         appointrepo.save(appointment);
	     } else {
	         throw new RuntimeException("Appointment not found with id: " + appointmentId);
	     }
	 }

}
