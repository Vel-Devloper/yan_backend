package com.sevael.yanmar.serviceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevael.yanmar.dto.MaterialAppointRequest;
import com.sevael.yanmar.dto.MaterialAppointResponse;
import com.sevael.yanmar.entity.MaterialAppoint;
import com.sevael.yanmar.repository.MaterialAppointRepo;
import com.sevael.yanmar.service.MaterialAppointService;
import com.sevael.yanmar.util.MaterialEmail;

@Service
public class MaterialAppointServiceImpl implements MaterialAppointService{
	
	@Autowired
	MaterialAppointRepo materialappointrepo;
	
	@Autowired
	private MaterialEmail materialemail;
	
//	private static final String BASE_URL = "http://yanmar.sevael.com/visitor/form";
	private static final String BASE_URL = "http://135.13.39.201:5173/material/form";
	
	@Override
	public MaterialAppointResponse saveEntry(MaterialAppointRequest dto) {
		MaterialAppoint materialpass = new MaterialAppoint();
		materialpass.setSupplier_name(dto.getSupplier_name());
		materialpass.setSupplier_email(dto.getSupplier_email());
		materialpass.setEntry_type(dto.getEntry_type());
		materialpass.setExpec_delivery_date(dto.getExpec_delivery_date());
		materialpass.setPriority_level(dto.getPriority_level());
		materialpass.setPurpose(dto.getPurpose());
		
		// Automatically decide request type
	    if (dto.getSupplier_email() == null || dto.getSupplier_email().isBlank()) {
	    	materialpass.setRequest_type(2); // Manual
	    } else {
	    	materialpass.setRequest_type(1); // Online
	    }
		
	    String uuidToken = UUID.randomUUID().toString();
	    materialpass.setUuidtoken(uuidToken);
	    
		MaterialAppoint saved = materialappointrepo.save(materialpass);
		
		String formLink = null;
		
		if(saved.getSupplier_email() != null && !saved.getSupplier_email().isBlank()) {
			formLink = BASE_URL + "?token=" + saved.getUuidtoken();
			materialemail.sendAppointmentLink(saved.getSupplier_email(), formLink);
		}
		return new MaterialAppointResponse(
				"Appointment created successfully",
				saved.getId(),
				saved.getSupplier_name(),
				saved.getEntry_type(),
				saved.getExpec_delivery_date(),
				formLink
				);
	}
}
