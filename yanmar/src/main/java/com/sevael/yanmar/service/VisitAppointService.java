package com.sevael.yanmar.service;

import com.sevael.yanmar.dto.AppointRequest;
import com.sevael.yanmar.dto.AppointResponse;

public interface VisitAppointService {
	AppointResponse createAppointment(AppointRequest dto);
}
