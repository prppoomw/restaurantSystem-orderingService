package com.OrderingService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OrderingService.entity.Ordering;

@Service
public interface OrderingService {

	void createOrder(Ordering order);

	void updateOrder(int orderId, Ordering order);
	
	List<Ordering> getAll();

}
