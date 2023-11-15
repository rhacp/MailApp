package com.team.mailapp.controllers;

import com.team.mailapp.models.entities.Mail;
import com.team.mailapp.services.MailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/send/{targetEmail}")
    public ResponseEntity<String> sendMail(@PathVariable String targetEmail, @RequestBody Mail mail) {
        mailService.sendMail(targetEmail, mail);
        return ResponseEntity.ok("Success");
    }
}
