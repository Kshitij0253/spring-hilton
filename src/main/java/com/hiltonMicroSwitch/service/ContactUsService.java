package com.hiltonMicroSwitch.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hiltonMicroSwitch.dto.ContactUsRequest;
import com.hiltonMicroSwitch.entity.ContactEnquiry;
import com.hiltonMicroSwitch.exception.ContactEnquiryException;
import com.hiltonMicroSwitch.repository.ContactUsRepository;


@Service
public class ContactUsService {

	private static final Logger log =
	        LoggerFactory.getLogger(ContactUsService.class);
	
    @Autowired
    private ContactUsRepository repository;

    @Autowired
    private JavaMailSender mailSender;

    public void saveAndSend(ContactUsRequest request) {
    	
    	 log.info("Received contact enquiry from name={}, mobile={}",
                 request.getName(), request.getMobileNumber());

        try {
            
            ContactEnquiry contact = new ContactEnquiry();
            contact.setName(request.getName());
            contact.setMobileNumber(request.getMobileNumber());
            contact.setMessage(request.getMessage());
            contact.setCreatedAt(LocalDateTime.now());

            repository.save(contact);

            log.info("Contact enquiry saved successfully for mobile={}",
                    request.getMobileNumber());
            
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo("kshitij.hiltonx007@gmail.com");
            mail.setSubject("Enquiry through website");

            String body = """
                    New Contact Us Enquiry
                    
                    Name: %s
                    Mobile Number: %s
                    
                    Message:
                    %s
                    """.formatted(
                    request.getName(),
                    request.getMobileNumber(),
                    request.getMessage()
            );

            mail.setText(body);

            mailSender.send(mail);
            
            log.info("Enquiry email sent successfully for mobile={}",
                    request.getMobileNumber());

        } catch (MailException ex) {
            
            log.error("Mail sending failed for mobile={}. Reason={}",
                    request.getMobileNumber(), ex.getMessage());
            
            throw new ContactEnquiryException(
                    "Your enquiry was saved, but we couldn't send email right now."
            );

        } catch (Exception ex) {
        	
        	  log.error("Contact enquiry processing failed for mobile={}",
                      request.getMobileNumber(), ex);
        	  
            throw new ContactEnquiryException(
                    "Unable to submit enquiry. Please try again later."
            );
        }
    }

}
