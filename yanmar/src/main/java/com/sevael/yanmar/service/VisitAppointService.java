package com.sevael.yanmar.service;

import com.sevael.yanmar.dto.AppointRequest;
import com.sevael.yanmar.dto.AppointResponse;
import com.sevael.yanmar.dto.AppointmentDisplayDTO;
//import com.sevael.yanmar.dto.VisitorFullDetailsDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface VisitAppointService {
	AppointResponse createAppointment(AppointRequest dto);
	
	List<AppointmentDisplayDTO> getDisplayAppointments();
	
	void updateCheckInForAll(Long appointmentId, LocalDateTime checkInTime);
	void updateCheckoutForAll(Long appointmentId, LocalDateTime checkoutTime);
}
