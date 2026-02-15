package com.hiltonMicroSwitch.dto;

import lombok.Data;

@Data
public class MailRequestDto {

    private String to;
    private String subject;
    private String number;
    private String message;

}
