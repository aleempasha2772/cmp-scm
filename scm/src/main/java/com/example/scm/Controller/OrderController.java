package com.example.scm.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scm.Client.BusinessServiceClient;
import com.example.scm.Entity.Order;
import com.example.scm.ResponseDTO.BusinessServiceResponse;
import com.example.scm.Service.OrderService;

@RestController
@RequestMapping("api/v1")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private BusinessServiceClient businessServiceClient;
	
	@GetMapping("get-service")
	public List<BusinessServiceResponse> getAllService() {
		return businessServiceClient.getAllService();
	}
	
	
	@GetMapping("/get-business-service-by-id/{serviceId}")
	public ResponseEntity<BusinessServiceResponse> getBusinessServiceById(@PathVariable Integer serviceId){
	    return ResponseEntity.ok().body(businessServiceClient.getServiceById(serviceId));
	        
	}
	@PostMapping("/create-service")
	public ResponseEntity<BusinessServiceResponse> createOrder(@RequestBody BusinessServiceResponse businessServiceResponse){
		BusinessServiceResponse br = businessServiceClient.createService(businessServiceResponse);
		if(br != null && br.getServiceId() !=null) {
			try {
	            businessServiceClient.updateSubscriptionCount(br.getServiceId());
			}catch(Exception e) {
				System.out.print("Exception : "+e);
			}
		}
		return ResponseEntity.ok().body(br);
	}
	
	@PostMapping("/create-order")
	public ResponseEntity<Order> createOrder(@RequestBody Order order){
		Order newOrder = orderService.createOrder(order);
		if(newOrder != null && newOrder.getServiceId() !=null) {
			try {
				businessServiceClient.updateSubscriptionCount(newOrder.getServiceId());
			}catch(Exception e) {
				System.out.print("Exception : "+e);
			}
		}
		return ResponseEntity.ok().body(newOrder);
	}
	
}
