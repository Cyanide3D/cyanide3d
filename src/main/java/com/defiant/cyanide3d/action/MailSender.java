package com.defiant.cyanide3d.action;

import com.defiant.cyanide3d.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailSender {
    @Autowired
    Config config;
    @Autowired
    JavaMailSender javaMailSender;

    public void send(String emailTo, String subject, String message){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(config.getUsername());
        simpleMailMessage.setTo(emailTo);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        javaMailSender.send(simpleMailMessage);

    }
}
