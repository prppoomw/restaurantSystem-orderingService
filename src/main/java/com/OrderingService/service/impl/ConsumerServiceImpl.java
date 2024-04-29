package com.OrderingService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.OrderingService.constant.OrderingConstant;
import com.OrderingService.entity.Ordering;
import com.OrderingService.repository.OrderingRepository;
import com.OrderingService.service.ConsumerService;
import com.OrderingService.service.EmailService;

@Service
public class ConsumerServiceImpl implements ConsumerService{
	
	@Autowired
	OrderingRepository orderingRepository;
	
	@Autowired
	EmailService mailService;
		
	@Override
	@KafkaListener(topics = OrderingConstant.TOPIC_NAME, groupId = OrderingConstant.GROUP_ID)
	public void consumeMessage(Ordering order) {
		System.out.println("start consume");
		if(order.getPaymentType().equals("creditcard")) {
			if(order.getStatus().equals("waiting for payment")) {
				//send notification for payment
				mailService.sendMail(OrderingConstant.EXAMPLE_MAIL, "waiting for payment");
				//credit card auto payment
				order.setStatus("waiting for confirm");
				orderingRepository.save(order);
				//send Receipt by mail
				mailService.sendMail(OrderingConstant.EXAMPLE_MAIL, "Receipt");
				//notification waiting confirm
				mailService.sendMail(OrderingConstant.EXAMPLE_MAIL, "waiting for confirm");
			}
			else {
				if(order.getStatus().equals("preparing your order")) {
					//notification preparing
					mailService.sendMail(OrderingConstant.EXAMPLE_MAIL, "preparing your order");
					orderingRepository.save(order);
				}
				if(order.getStatus().equals("out for delivery")) {
					//notification delivery
					mailService.sendMail(OrderingConstant.EXAMPLE_MAIL, "out for delivery");
					orderingRepository.save(order);
				}
				if(order.getStatus().equals("arrived")) {
					//notification arrived
					mailService.sendMail(OrderingConstant.EXAMPLE_MAIL, "arrived");
					orderingRepository.save(order);
				}
				if(order.getStatus().equals("finished")) {
					//notification finish
					mailService.sendMail(OrderingConstant.EXAMPLE_MAIL, "finished");
					orderingRepository.save(order);
				}
			}
		}
		else {
			if(order.getStatus().equals("waiting for confirm")) {
				//notification wait for confirm
				mailService.sendMail(OrderingConstant.EXAMPLE_MAIL2, "waiting for confirm");
				orderingRepository.save(order);
			}
			if(order.getStatus().equals("preparing your order")) {
				//notification preparing
				mailService.sendMail(OrderingConstant.EXAMPLE_MAIL2, "preparing your order");
				orderingRepository.save(order);
			}
			if(order.getStatus().equals("out for delivery")) {
				//notification delivery
				mailService.sendMail(OrderingConstant.EXAMPLE_MAIL2, "out for delivery");
				orderingRepository.save(order);
			}
			if(order.getStatus().equals("arrived")) {
				//notification arrived
				mailService.sendMail(OrderingConstant.EXAMPLE_MAIL2, "arrived");
				order.setStatus("waiting for payment");
				mailService.sendMail(OrderingConstant.EXAMPLE_MAIL2, "waiting for payment");
				orderingRepository.save(order);
			}
			if(order.getStatus().equals("finished")) {
				//notification finish
				mailService.sendMail(OrderingConstant.EXAMPLE_MAIL2, "finished");
				orderingRepository.save(order);
			}
		}
	}

}
