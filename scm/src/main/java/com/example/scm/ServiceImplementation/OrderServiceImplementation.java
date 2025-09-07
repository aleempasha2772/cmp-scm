package com.example.scm.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scm.Client.BusinessServiceClient;
import com.example.scm.Entity.Order;
import com.example.scm.Repository.OrderRepository;
import com.example.scm.ResponseDTO.BusinessServiceResponse;
import com.example.scm.Service.OrderService;


@Service
public class OrderServiceImplementation implements OrderService{
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	@Autowired
	private BusinessServiceClient businessServiceClient;

	@Override
	public Order createOrder(Order order) {
		Order orderData = new Order();
		BusinessServiceResponse bResponse = businessServiceClient.getServiceById(order.getServiceId());
		orderData.setServiceId(bResponse.getServiceId());
		orderData.setPrice(bResponse.getServicePrice());
		orderData.setCustomerId(order.getCustomerId());
		
		return orderData;
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
