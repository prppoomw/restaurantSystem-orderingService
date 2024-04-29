package com.OrderingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.OrderingService.entity.Ordering;
import com.OrderingService.service.OrderingService;

@Controller
@RequestMapping("/ordering")
public class OrderingController {
	@Autowired
	OrderingService orderingService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createOrder(@RequestBody Ordering order){
		orderingService.createOrder(order);
		return ResponseEntity.ok("create order success");
	}
	
	@PutMapping("/update-{orderId}")
	public ResponseEntity<String> updateOrder(@PathVariable int orderId, @RequestBody Ordering order){
		orderingService.updateOrder(orderId, order);
		return ResponseEntity.ok("update order status success");
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Ordering>> getAllTask(){
		return ResponseEntity.ok(orderingService.getAll());
	}
	
}
