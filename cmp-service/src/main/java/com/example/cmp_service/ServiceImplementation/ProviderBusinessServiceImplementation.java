package com.example.cmp_service.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cmp_service.Model.BusinessService;
import com.example.cmp_service.Repository.BusinessServiceRepository;
import com.example.cmp_service.Service.ProviderBusinessService;

import jakarta.transaction.Transactional;

@Service
public class ProviderBusinessServiceImplementation implements ProviderBusinessService{
	
	@Autowired
	private BusinessServiceRepository businessServiceRepository;

	@Override
	public BusinessService createService(BusinessService service) {
		return businessServiceRepository.save(service);	
	}

	@Override
	public List<BusinessService> getAllService() {
		List<BusinessService> businessServiceList = businessServiceRepository.findAll();
		return businessServiceList;
	}

	@Override
	public BusinessService getServiceById(Integer serviceId) {
	    return businessServiceRepository.findById(serviceId)
	            .orElseThrow(() -> new RuntimeException("Service not found with id: " + serviceId));
	}

	@Override
	public BusinessService updateService(Long id, String serviceName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteService(Integer serviceId) {
		
		businessServiceRepository.deleteById(serviceId);
		
	}

	@Override
	@Transactional  // Add transactional annotation to ensure atomic operation
	public Integer updateSubscriptionCount(Integer serviceId) {
		BusinessService bs = getServiceById(serviceId);
		Integer updatedSubscriptionCount = bs.getTotalServiceSubcriptionCount()+1;
		bs.setTotalServiceSubcriptionCount(updatedSubscriptionCount);
		businessServiceRepository.save(bs);
		return bs.getTotalServiceSubcriptionCount();
	}


	
	
	
}
