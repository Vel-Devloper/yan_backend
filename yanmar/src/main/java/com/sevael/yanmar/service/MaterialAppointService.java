package com.sevael.yanmar.service;

import com.sevael.yanmar.dto.MaterialAppointRequest;
import com.sevael.yanmar.dto.MaterialAppointResponse;

public interface MaterialAppointService {
	MaterialAppointResponse saveEntry(MaterialAppointRequest dto);
}
