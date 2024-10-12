package com.dam.Notifications.controller;

import com.dam.Notifications.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send-email")
    public String sendEmail() {
        emailService.sendSimpleEmail("recipient@example.com", "Test Email", "This is a test email from Spring Boot.");
        return "Email sent successfully!";
    }
}