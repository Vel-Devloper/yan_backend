package com.sevael.yanmar.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendAppointmentLink(String toEmail, String appointmentLink) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmail);
		message.setSubject("Fill and Submit your visitor appointment form");
		message.setText("Dear Visitor, \n\nPlease fill out your form using this link:\n" + appointmentLink +"\n\nThank you.");
		mailSender.send(message);
	}
}
