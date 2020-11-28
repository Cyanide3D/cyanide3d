package com.defiant.cyanide3d.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailSenderConfig {
    @Autowired
    Config config;

    @Bean
    public JavaMailSender getMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(config.getHost());
        javaMailSender.setUsername(config.getUsername());
        javaMailSender.setPassword(config.getPassword());
        javaMailSender.setPort(Integer.parseInt(config.getPort()));
        javaMailSender.setProtocol(config.getProtocol());
        return javaMailSender;
    }
}
