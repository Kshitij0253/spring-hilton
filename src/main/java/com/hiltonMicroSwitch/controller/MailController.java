package com.hiltonMicroSwitch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.hiltonMicroSwitch.dto.MailRequestDto;
import com.hiltonMicroSwitch.service.MailService;

@RestController
@RequestMapping("/api/mail")
@CrossOrigin("*")
public class MailController {

     private final ExecutorService executor = Executors.newFixedThreadPool(2);
    
    @Autowired
    private MailService mailService;

    @PostMapping("/send")
    public String sendMail(@RequestBody MailRequestDto dto) {

        executor.submit(() -> {
	        // try {
	             mailService.sendMail(dto);
	            // } catch (InterruptedException e) {
	                // Thread.currentThread().interrupt();
	            // }

	        });
        
        
        return "Mail sent successfully";
    }
}
