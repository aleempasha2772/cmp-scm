package com.example.scm.Service;

import java.util.List;

import com.example.scm.Entity.Order;

public interface OrderService {
	
	Order createOrder(Order order);
	List<Order> getAllOrder();
	Order getOrderById(Integer orderId);
	void deleteOrder(Integer orderId);
	Order updateOrder(Integer orderId);
}
