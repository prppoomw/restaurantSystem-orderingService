package com.OrderingService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.OrderingService.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{

	@Autowired
	JavaMailSender javaMailSender;
	
	@Override
	public void sendMail(String email, String topic) {
		SimpleMailMessage message=new SimpleMailMessage();
		
        message.setFrom("devadigasankalp8@gmail.com");
        message.setTo(email);
        message.setText(topic);
        message.setSubject(topic);
        
        javaMailSender.send(message);
        
        System.out.println("Simple message is sent to mail id : "+ email);
	}

}
