package com.example.cmp_service.Controller;

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

import com.example.cmp_service.Model.BusinessService;
import com.example.cmp_service.Service.ProviderBusinessService;

@RestController
@RequestMapping("api/v1")
public class BusinessServiceController {
	
	@Autowired
	private ProviderBusinessService providerBusinessService;
	
	
	@PostMapping("/create-business-service")
	public ResponseEntity<BusinessService> createBusinessService(@RequestBody BusinessService bService){
		BusinessService businessService = providerBusinessService.createService(bService);
		return ResponseEntity.ok().body(businessService);
	}
	
	@GetMapping("/get-all-business-service")
	public ResponseEntity<List<BusinessService>> getAllBusinessServices(){
		List<BusinessService> businessServiceList = providerBusinessService.getAllService();
		return ResponseEntity.ok().body(businessServiceList);
	}
	
	@GetMapping("/get-business-service-by-id/{serviceId}")
	public ResponseEntity<Optional<BusinessService>> getBusinessServiceById(@PathVariable Integer serviceId){
		
		return ResponseEntity.ok().body(providerBusinessService.getServiceById(serviceId));
		
	}
	
	
}
