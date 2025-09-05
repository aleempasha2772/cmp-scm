package com.example.cmp_service.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cmp_service.Model.BusinessService;
import com.example.cmp_service.Repository.BusinessServiceRepository;
import com.example.cmp_service.Service.ProviderBusinessService;

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
	public Optional<BusinessService> getServiceById(Integer serviceId) {
		if (serviceId == null) {
            return Optional.empty();
        }
		return businessServiceRepository.findById(serviceId);
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


	
	
	
}
