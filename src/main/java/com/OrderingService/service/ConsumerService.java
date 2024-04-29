package com.OrderingService.service;

import org.springframework.stereotype.Service;

import com.OrderingService.entity.Ordering;

@Service
public interface ConsumerService {
	void consumeMessage(Ordering order);
}
