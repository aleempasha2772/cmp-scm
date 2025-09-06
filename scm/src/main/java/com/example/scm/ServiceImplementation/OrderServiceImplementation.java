package com.example.scm.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scm.Entity.Order;
import com.example.scm.Repository.OrderRepository;
import com.example.scm.Service.OrderService;


@Service
public class OrderServiceImplementation implements OrderService{
	
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public Order getOrderById(Integer orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(Integer orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order updateOrder(Integer orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
