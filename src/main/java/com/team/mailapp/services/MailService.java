package com.team.mailapp.services;

import com.team.mailapp.models.entities.Mail;

public  interface MailService {

    void sendMail(String mailTarget, Mail mail);
}
