package com.hiltonMicroSwitch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiltonMicroSwitch.dto.ContactUsRequest;
import com.hiltonMicroSwitch.service.ContactUsService;

@RestController
@RequestMapping("/api/contact")
public class ContactUsController {
	
	 private static final Logger log =
	            LoggerFactory.getLogger(ContactUsController.class);
	
	@Autowired
    private ContactUsService contactUsService;

	@GetMapping("/test")
public String test() {
    return "Backend working";
}

    @PostMapping("/submit")
    public ResponseEntity<String> submitContact(@RequestBody ContactUsRequest request) {
    	
    	log.debug("Contact submit API called");


        contactUsService.saveAndSend(request);

        return ResponseEntity.ok(
                "Thank you for contacting Hilton Micro Switch Co. We will get back to you shortly."
        );
    }

}
