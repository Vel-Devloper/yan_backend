package com.sevael.yanmar.controller;

import com.sevael.yanmar.dto.IntLoginRequest;
import com.sevael.yanmar.dto.IntLoginResponse;

import com.sevael.yanmar.service.IntLoginService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/yanmar/internal")
public class IntLoginController {
	
	@Autowired
	private IntLoginService loginService;

	@PostMapping("/int_login")
	public ResponseEntity<IntLoginResponse> login(@RequestBody IntLoginRequest request){
		IntLoginResponse response = loginService.login(request);
		return ResponseEntity.ok(response);
	}
}