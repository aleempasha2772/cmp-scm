package com.example.scm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scm.Entity.Order;
import com.example.scm.Service.OrderService;

@RestController
@RequestMapping("api/v1")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/create-order")
	public ResponseEntity<Order> createOrder(@RequestBody Order order){
		Order newOrder = orderService.createOrder(order);
		return ResponseEntity.ok().body(newOrder);
	}
	
}
