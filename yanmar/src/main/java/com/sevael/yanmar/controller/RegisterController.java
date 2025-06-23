package com.sevael.yanmar.controller;

import com.sevael.yanmar.service.ExtRegisService;
import com.sevael.yanmar.service.IntRegisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sevael.yanmar.dto.ExtRegisterRequest;
import com.sevael.yanmar.dto.IntRegisterRequest;


@RestController
@RequestMapping("/yanmar")
public class RegisterController {
	
	@Autowired
	private IntRegisService intregisService;
	
	@Autowired
	private ExtRegisService extRegisService;

	@PostMapping("external/register")
	public ResponseEntity<String> register(@RequestBody ExtRegisterRequest request){
		String result = extRegisService.register(request);

        if ("User already exists".equals(result)) {
            return ResponseEntity.badRequest().body(result);
        }

        return ResponseEntity.ok(result);
	}
	
	@PostMapping("internal/register")
	public ResponseEntity<String> register(@RequestBody IntRegisterRequest request){
		String result = intregisService.register(request);

        if ("User already exists".equals(result)) {
            return ResponseEntity.badRequest().body(result);
        }

        return ResponseEntity.ok(result);
	}
}
