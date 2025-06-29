package com.sevael.yanmar.service;

import com.sevael.yanmar.dto.AppointRequest;
import com.sevael.yanmar.dto.AppointResponse;
import com.sevael.yanmar.dto.AppointmentDisplayDTO;
import java.util.List;

public interface VisitAppointService {
	AppointResponse createAppointment(AppointRequest dto);
	
	List<AppointmentDisplayDTO> getDisplayAppointments();

}
