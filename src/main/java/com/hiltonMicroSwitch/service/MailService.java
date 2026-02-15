package com.hiltonMicroSwitch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hiltonMicroSwitch.dto.MailRequestDto;

@Service
public class MailService {
	
	 @Autowired
	    private JavaMailSender mailSender;

	    public void sendMail(MailRequestDto dto) {

	        SimpleMailMessage mail = new SimpleMailMessage();
	        mail.setTo(dto.getTo());
	        mail.setSubject(dto.getSubject());

	        String body = """
	                Hilton Micro Switch Co
	                
	                Contact Number: %s
	                
	                Message:
	                %s
	                """.formatted(dto.getNumber(), dto.getMessage());

	        mail.setText(body);

	        mailSender.send(mail);
	    }

}
