package com.hiltonMicroSwitch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiltonMicroSwitch.dto.MailRequestDto;
import com.hiltonMicroSwitch.service.MailService;

@RestController
@RequestMapping("/api/mail")
@CrossOrigin("*")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/send")
    public String sendMail(@RequestBody MailRequestDto dto) {
        mailService.sendMail(dto);
        return "Mail sent successfully";
    }
}
