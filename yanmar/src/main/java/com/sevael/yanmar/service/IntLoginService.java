package com.sevael.yanmar.service;

import com.sevael.yanmar.dto.IntLoginRequest;
import com.sevael.yanmar.dto.IntLoginResponse;

public interface IntLoginService {
	IntLoginResponse login(IntLoginRequest loginRequest);
}
