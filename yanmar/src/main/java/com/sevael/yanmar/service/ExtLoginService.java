package com.sevael.yanmar.service;

import com.sevael.yanmar.dto.ExtLoginRequest;
import com.sevael.yanmar.dto.ExtLoginResponse;

public interface ExtLoginService {
	ExtLoginResponse login(ExtLoginRequest extloginReuest);
}
