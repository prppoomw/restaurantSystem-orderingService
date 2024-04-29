package com.OrderingService.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
	void sendMail(String email, String topic);
}
