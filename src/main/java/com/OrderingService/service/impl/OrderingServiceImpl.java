package com.OrderingService.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OrderingService.constant.OrderingConstant;
import com.OrderingService.entity.Ordering;
import com.OrderingService.repository.OrderingRepository;
import com.OrderingService.service.OrderingService;
import com.OrderingService.service.ProducerService;

@Service
public class OrderingServiceImpl implements OrderingService{
	@Autowired
	OrderingRepository orderingRepository;
	
	@Autowired
	ProducerService producer;

	@Override
	public void createOrder(Ordering order) {
		producer.sendMessage(OrderingConstant.TOPIC_NAME, order);
		//return orderingRepository.save(order);
	}

	@Override
	public void updateOrder(int orderId, Ordering order) {
		order.setOrderId(orderId);
		producer.sendMessage(OrderingConstant.TOPIC_NAME, order);
		//return orderingRepository.save(order);
	}

	@Override
	public List<Ordering> getAll() {
		return orderingRepository.findAll();
	}
	
	
}
