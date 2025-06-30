package com.sevael.yanmar.service;

import com.sevael.yanmar.dto.AppointRequest;
import com.sevael.yanmar.dto.AppointResponse;
import com.sevael.yanmar.dto.AppointmentDisplayDTO;
//import com.sevael.yanmar.dto.VisitorFullDetailsDTO;
import com.sevael.yanmar.dto.SecurityViewDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface VisitAppointService {
	AppointResponse createAppointment(AppointRequest dto);
	
	List<AppointmentDisplayDTO> getDisplayAppointments();
	List<SecurityViewDTO> getDisplayapprovedAppoint();

	
	
	
	void updateCheckInForAll(Long appointmentId, LocalDateTime checkInTime);
	void updateCheckoutForAll(Long appointmentId, LocalDateTime checkoutTime);
	
//	void updateApprovalStatus(Long visitorId, int approvalStatus);
	void updateApprovalStatusForAppointment(Long appointmentId, int status);
}
