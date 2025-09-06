package com.example.customer_service.Service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.customer_service.DTO.CustomerDTO;
import com.example.customer_service.Entity.CustomerStatus;

import java.util.List;

public interface CustomerService {
    
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    
    CustomerDTO getCustomerById(Long id);
    
    List<CustomerDTO> getAllCustomers();
    
    Page<CustomerDTO> getAllCustomers(Pageable pageable);
    
    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);
    
    void deleteCustomer(Long id);
    
    CustomerDTO getCustomerByEmail(String email);
    
    List<CustomerDTO> getCustomersByStatus(CustomerStatus status);
    
    Page<CustomerDTO> searchCustomers(String searchTerm, Pageable pageable);
    
    boolean existsByEmail(String email);
}