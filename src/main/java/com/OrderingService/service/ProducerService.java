package com.OrderingService.service;

import org.springframework.stereotype.Service;

import com.OrderingService.entity.Ordering;

@Service
public interface ProducerService {
	void sendMessage(String topic, Ordering order);
}
