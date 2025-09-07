package com.example.cmp_service.Service;

import java.util.List;
import java.util.Optional;

import com.example.cmp_service.Model.BusinessService;

public interface ProviderBusinessService {
	
	BusinessService createService(BusinessService service);
	List<BusinessService> getAllService();
	BusinessService updateService(Long id,String serviceName);
	void deleteService(Integer serviceId);
	BusinessService getServiceById(Integer serviceId);
	Integer updateSubscriptionCount(Integer serviceId);
	
	
}
