package com.example.scm.Client;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.scm.ResponseDTO.BusinessServiceResponse;

@FeignClient(name = "cmp-service/api/v1")
public interface BusinessServiceClient {
	
	@PostMapping("/create-business-service")
	BusinessServiceResponse createService(BusinessServiceResponse service);
	
	@GetMapping("/get-all-business-service")
	List<BusinessServiceResponse> getAllService();
	
	
	@GetMapping("/get-business-service-by-id/{serviceId}")
	BusinessServiceResponse getServiceById(@PathVariable("serviceId") Integer serviceId);
	
	@PutMapping("/update-sub-count/{serviceId}")
	Integer updateSubscriptionCount(@PathVariable("serviceId") Integer serviceId);
}
