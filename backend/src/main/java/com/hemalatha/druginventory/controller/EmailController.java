
package com.hemalatha.druginventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hemalatha.druginventory.service.EmailService;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {

    @Autowired
    private EmailService emailService;

    // @GetMapping("/api/email/test")
    // public String sendTestEmail() {

    //     emailService.sendEmail(
    //             "bloodbank.admin@gmail.com",
    //             "Drug Inventory Test Email",
    //             "Email service is working successfully."
    //     );

    //     return "Email Sent Successfully";
    @GetMapping("/test")
    public String testEmail() {

        emailService.sendEmail(
            "yourgmail@gmail.com",
            "Drug Inventory Test",
            "Email notification is working successfully."
        );

        return "Email Sent";
    }
}