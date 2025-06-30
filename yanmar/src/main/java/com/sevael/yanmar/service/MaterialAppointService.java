package com.sevael.yanmar.service;

import java.util.List;

import com.sevael.yanmar.dto.MatAppointDisplayDTO;
import com.sevael.yanmar.dto.MaterialAppointRequest;
import com.sevael.yanmar.dto.MaterialAppointResponse;

public interface MaterialAppointService {
	MaterialAppointResponse saveEntry(MaterialAppointRequest dto);
	
	List<MatAppointDisplayDTO> getAllAppointments();
}
