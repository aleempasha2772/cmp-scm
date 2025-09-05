package com.example.cmp_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cmp_service.Model.BusinessService;

public interface BusinessServiceRepository extends JpaRepository<BusinessService,Integer> {
	
	
}
