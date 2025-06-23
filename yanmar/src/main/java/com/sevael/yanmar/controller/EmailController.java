package com.sevael.yanmar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sevael.yanmar.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private EmailService emailservice;
	
	@PostMapping("/send")
	public String sendEmail(
			@RequestParam String to,
			@RequestParam String subject,
			@RequestParam String body) {
		emailservice.sendSimpleMessage(to, subject, body);
		return "Email Sent Successfully";
	}
}
