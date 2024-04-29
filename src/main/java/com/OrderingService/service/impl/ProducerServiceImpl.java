package com.OrderingService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.OrderingService.entity.Ordering;
import com.OrderingService.service.ProducerService;


@Service
public class ProducerServiceImpl implements ProducerService{
	@Autowired
	private KafkaTemplate<String, Ordering> kafkaTemplate;

	@Override
	public void sendMessage(String topic, Ordering order) {
		kafkaTemplate.send(topic, order);
	}
	

}
