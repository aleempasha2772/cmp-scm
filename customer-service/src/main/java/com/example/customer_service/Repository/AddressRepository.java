package com.example.customer_service.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.customer_service.Entity.Address;
import com.example.customer_service.Entity.AddressType;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    
    List<Address> findByCustomerId(Long customerId);
    
    List<Address> findByCustomerIdAndAddressType(Long customerId, AddressType addressType);
    
    List<Address> findByCustomerIdAndIsPrimary(Long customerId, Boolean isPrimary);
}