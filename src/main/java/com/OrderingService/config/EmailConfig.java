package com.OrderingService.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.OrderingService.constant.OrderingConstant;


@Configuration
public class EmailConfig {
	@Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(OrderingConstant.E_MAIL);
        mailSender.setPassword(OrderingConstant.PASSWORD);
        
        Properties prop = mailSender.getJavaMailProperties();
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        prop.setProperty("mail.smtp.starttls.enable", "true");
        prop.setProperty("mail.debug", "true");

        return mailSender;
    }
}
