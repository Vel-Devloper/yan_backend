package com.sevael.yanmar.controller;

import com.sevael.yanmar.dto.ExtLoginRequest;
import com.sevael.yanmar.dto.ExtLoginResponse;
import com.sevael.yanmar.service.ExtLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/yanmar/external")
public class ExtLoginController {
	
	@Autowired
	private ExtLoginService extloginService;
	
	@PostMapping("/ext_login")
	public ResponseEntity<ExtLoginResponse> login(@RequestBody ExtLoginRequest request){
		ExtLoginResponse response = extloginService.login(request);
		return ResponseEntity.ok(response);
	}
}
