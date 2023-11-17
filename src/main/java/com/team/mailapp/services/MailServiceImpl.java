package com.team.mailapp.services;

import com.team.mailapp.models.entities.Mail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService{

    private final JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String senderAddress;

    public MailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMail(String mailTarget, Mail mail) {
        //Preparing mail
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(senderAddress);
        simpleMailMessage.setSubject(mail.getSubject());
        simpleMailMessage.setText(mail.getMessage());
        simpleMailMessage.setTo(mailTarget);

        javaMailSender.send(simpleMailMessage);
    }
}
