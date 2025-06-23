package com.sevael.yanmar.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevael.yanmar.dto.MaterialAppointRequest;
import com.sevael.yanmar.dto.MaterialAppointResponse;
import com.sevael.yanmar.entity.MaterialAppoint;
import com.sevael.yanmar.repository.MaterialAppointRepo;
import com.sevael.yanmar.service.MaterialAppointService;

@Service
public class MaterialAppointServiceImpl implements MaterialAppointService{
	
	@Autowired
	MaterialAppointRepo materialappointrepo;
	
	@Override
	public MaterialAppointResponse saveEntry(MaterialAppointRequest dto) {
		MaterialAppoint materialpass = new MaterialAppoint();
		materialpass.setSupplier_name(dto.getSupplier_name());
		materialpass.setSupplier_email(dto.getSupplier_email());
		materialpass.setEntry_type(dto.getEntry_type());
		materialpass.setExpec_delivery_date(dto.getExpec_delivery_date());
		materialpass.setPriority_level(dto.getPriority_level());
		materialpass.setPurpose(dto.getPurpose());
		
		MaterialAppoint saved = materialappointrepo.save(materialpass);
		
		return new MaterialAppointResponse(
				"Appointment created successfully",
				saved.getId(),
				saved.getSupplier_name(),
				saved.getEntry_type(),
				saved.getExpec_delivery_date());
	}
}
