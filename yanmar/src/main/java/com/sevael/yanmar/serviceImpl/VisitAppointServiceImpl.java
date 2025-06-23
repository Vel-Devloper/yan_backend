package com.sevael.yanmar.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevael.yanmar.dto.AppointRequest;
import com.sevael.yanmar.dto.AppointResponse;
import com.sevael.yanmar.entity.VisitorAppoint;
import com.sevael.yanmar.repository.AppointRepo;
import com.sevael.yanmar.service.EmailService;
import com.sevael.yanmar.service.VisitAppointService;
import com.sevael.yanmar.util.EmailUtil;

import java.util.UUID;

@Service
public class VisitAppointServiceImpl implements VisitAppointService {
	
	@Autowired
	private AppointRepo appointrepo;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private EmailUtil emailUtil;
	
	private static final String BASE_URL = "http://yanmar.sevael.com/visitor/form";
	
	@Override
	public AppointResponse createAppointment(AppointRequest dto) {
		VisitorAppoint visitorpass = new VisitorAppoint();
		visitorpass.setAppointment_type(dto.getAppointment_type());
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
	    visitorpass.setUuidtoken(uuidToken);
	    
	    VisitorAppoint saved = appointrepo.save(visitorpass);
	    
//	    String requestTypeLabel = (saved.getRequest_type() == 1) ? "automatic" : "manual";
	    
//	    Generate Form Link
	    String formLink = BASE_URL + "?token=" + saved.getUuidtoken();
	    
	    if (saved.getVisitor_email() != null && !saved.getVisitor_email().isBlank()) {
	        emailUtil.sendAppointmentLink(saved.getVisitor_email(), formLink);
	    }
	    
	    return new AppointResponse(
	    		saved.getId(),
	    		"Appointment created successfully",
	    		saved.getRequest_type(),
	            saved.getVisitor_email(),
	            saved.getAppointment_type(),
	            formLink
	    		);
	}
	
}
