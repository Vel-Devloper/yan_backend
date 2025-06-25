package com.sevael.yanmar.controller;

//import com.sevael.yanmar.config.ApiServerProperties;
import com.sevael.yanmar.dto.IntLoginRequest;
import com.sevael.yanmar.dto.IntLoginResponse;

import com.sevael.yanmar.service.IntLoginService;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/yanmar/internal")
public class IntLoginController {
	
//	private static final Logger logger = LoggerFactory.getLogger(IntLoginController.class);
	 
	@Autowired
	private IntLoginService loginService;

//	@Autowired
//	private ApiServerProperties apiServerProperties;

	@PostMapping("/int_login")
	public ResponseEntity<IntLoginResponse> login(@RequestBody IntLoginRequest request){
		IntLoginResponse response = loginService.login(request);
		return ResponseEntity.ok(response);
	}

}