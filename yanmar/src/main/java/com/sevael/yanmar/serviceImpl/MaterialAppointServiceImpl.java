package com.sevael.yanmar.serviceImpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevael.yanmar.dto.MatAppointDisplayDTO;
import com.sevael.yanmar.dto.MaterialAppointRequest;
import com.sevael.yanmar.dto.MaterialAppointResponse;
import com.sevael.yanmar.entity.MaterialAppoint;
import com.sevael.yanmar.projection.MatAppointProjection;
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

	    // Set request type based on email
	    if (dto.getSupplier_email() == null || dto.getSupplier_email().isBlank()) {
	        materialpass.setRequest_type(2); // Manual
	    } else {
	        materialpass.setRequest_type(1); // Online
	    }

	    // Generate UUID token
	    String uuidToken = UUID.randomUUID().toString();
	    materialpass.setUuidtoken(uuidToken);

	    // Save entity without formLink
	    MaterialAppoint saved = materialappointrepo.save(materialpass);

	    String formLink = null;

	    // Only generate and send formLink if email is present
	    if (saved.getSupplier_email() != null && !saved.getSupplier_email().isBlank()) {
	        formLink = BASE_URL + "?token=" + uuidToken;

	        materialappointrepo.save(saved);

	        materialemail.sendAppointmentLink(saved.getSupplier_email(), formLink);
	    }

	    // Return response
	    return new MaterialAppointResponse(
	        "Appointment created successfully",
	        saved.getId(),
	        saved.getSupplier_name(),
	        saved.getEntry_type(),
	        saved.getExpec_delivery_date(),
	        formLink,    // will be null if no email
	        uuidToken
	    );
	}
	
//	@Override
//    public List<MatAppointDisplayDTO> getAllAppointments() {
//        return materialappointrepo.fetchAllMaterialAppointments();
//    }
	
	@Override
    public List<MatAppointDisplayDTO> getAllAppointments() {
        List<MatAppointProjection> projections = materialappointrepo.fetchAllMaterialAppointments();
        
        return projections.stream()
                .map(p -> new MatAppointDisplayDTO(
                        p.getRequest_id(),
                        p.getSupplier_name(),
                        p.getPurpose(),
                        p.getExpec_delivery_date(),
                        p.getDriver_name(),
                        p.getItem_name(),
                        p.getApproval_status()
                ))
                .collect(Collectors.toList());
    }
}