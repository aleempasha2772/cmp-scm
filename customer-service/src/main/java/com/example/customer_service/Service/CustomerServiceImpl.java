package com.example.customer_service.Service;

import com.example.customer_service.DTO.CustomerDTO;
import com.example.customer_service.Entity.Customer;
import com.example.customer_service.Entity.CustomerStatus;
import com.example.customer_service.Exception.CustomerAlreadyExistsException;
import com.example.customer_service.Exception.CustomerNotFoundException;
import com.example.customer_service.Exception.InvalidCustomerDataException;
import com.example.customer_service.Mapper.CustomerMapper;
import com.example.customer_service.Repository.CustomerRepository;
import com.example.customer_service.Service.CustomerService;	
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    
    private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);
    
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    
    public CustomerServiceImpl(CustomerRepository customerRepository, 
                              CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }
    
    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        logger.info("Creating new customer with email: {}", customerDTO.getEmail());
        
        validateCustomerData(customerDTO);
        
        if (customerRepository.existsByEmail(customerDTO.getEmail())) {
            logger.warn("Attempt to create customer with existing email: {}", customerDTO.getEmail());
            throw new CustomerAlreadyExistsException(
                "Customer with email " + customerDTO.getEmail() + " already exists");
        }
        
        try {
            Customer customer = customerMapper.toEntity(customerDTO);
            Customer savedCustomer = customerRepository.save(customer);
            
            logger.info("Customer created successfully with ID: {}", savedCustomer.getId());
            return customerMapper.toDTO(savedCustomer);
            
        } catch (Exception e) {
            logger.error("Error creating customer: ", e);
            throw new RuntimeException("Failed to create customer", e);
        }
    }
    
    @Override
    @Transactional(readOnly = true)
    public CustomerDTO getCustomerById(Long id) {
        logger.info("Retrieving customer with ID: {}", id);
        
        if (id == null || id <= 0) {
            throw new InvalidCustomerDataException("Invalid customer ID: " + id);
        }
        
        Customer customer = customerRepository.findByIdWithAddresses(id)
            .orElseThrow(() -> {
                logger.warn("Customer not found with ID: {}", id);
                return new CustomerNotFoundException("Customer not found with ID: " + id);
            });
        
        logger.info("Customer retrieved successfully with ID: {}", id);
        return customerMapper.toDTO(customer);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<CustomerDTO> getAllCustomers() {
        logger.info("Retrieving all customers");
        
        List<Customer> customers = customerRepository.findAll();
        logger.info("Retrieved {} customers", customers.size());
        
        return customers.stream()
            .map(customerMapper::toDTO)
            .collect(Collectors.toList());
    }
    
    @Override
    @Transactional(readOnly = true)
    public Page<CustomerDTO> getAllCustomers(Pageable pageable) {
        logger.info("Retrieving customers with pagination: page={}, size={}", 
                   pageable.getPageNumber(), pageable.getPageSize());
        
        Page<Customer> customers = customerRepository.findAll(pageable);
        logger.info("Retrieved {} customers from page {}", 
                   customers.getNumberOfElements(), pageable.getPageNumber());
        
        return customers.map(customerMapper::toDTO);
    }
    
    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        logger.info("Updating customer with ID: {}", id);
        
        if (id == null || id <= 0) {
            throw new InvalidCustomerDataException("Invalid customer ID: " + id);
        }
        
        validateCustomerData(customerDTO);
        
        Customer existingCustomer = customerRepository.findById(id)
            .orElseThrow(() -> {
                logger.warn("Customer not found for update with ID: {}", id);
                return new CustomerNotFoundException("Customer not found with ID: " + id);
            });
        
        // Check if email is being changed and if new email already exists
        if (!existingCustomer.getEmail().equals(customerDTO.getEmail()) && 
            customerRepository.existsByEmail(customerDTO.getEmail())) {
            logger.warn("Attempt to update customer with existing email: {}", customerDTO.getEmail());
            throw new CustomerAlreadyExistsException(
                "Customer with email " + customerDTO.getEmail() + " already exists");
        }
        
        try {
            customerMapper.updateEntityFromDTO(customerDTO, existingCustomer);
            Customer updatedCustomer = customerRepository.save(existingCustomer);
            
            logger.info("Customer updated successfully with ID: {}", id);
            return customerMapper.toDTO(updatedCustomer);
            
        } catch (Exception e) {
            logger.error("Error updating customer with ID: {}", id, e);
            throw new RuntimeException("Failed to update customer", e);
        }
    }
    
    @Override
    public void deleteCustomer(Long id) {
        logger.info("Deleting customer with ID: {}", id);
        
        if (id == null || id <= 0) {
            throw new InvalidCustomerDataException("Invalid customer ID: " + id);
        }
        
        if (!customerRepository.existsById(id)) {
            logger.warn("Customer not found for deletion with ID: {}", id);
            throw new CustomerNotFoundException("Customer not found with ID: " + id);
        }
        
        try {
            customerRepository.deleteById(id);
            logger.info("Customer deleted successfully with ID: {}", id);
            
        } catch (Exception e) {
            logger.error("Error deleting customer with ID: {}", id, e);
            throw new RuntimeException("Failed to delete customer", e);
        }
    }
    
    @Override
    @Transactional(readOnly = true)
    public CustomerDTO getCustomerByEmail(String email) {
        logger.info("Retrieving customer with email: {}", email);
        
        if (email == null || email.trim().isEmpty()) {
            throw new InvalidCustomerDataException("Email cannot be null or empty");
        }
        
        Customer customer = customerRepository.findByEmail(email.toLowerCase())
            .orElseThrow(() -> {
                logger.warn("Customer not found with email: {}", email);
                return new CustomerNotFoundException("Customer not found with email: " + email);
            });
        
        logger.info("Customer retrieved successfully with email: {}", email);
        return customerMapper.toDTO(customer);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<CustomerDTO> getCustomersByStatus(CustomerStatus status) {
        logger.info("Retrieving customers with status: {}", status);
        
        if (status == null) {
            throw new InvalidCustomerDataException("Status cannot be null");
        }
        
        List<Customer> customers = customerRepository.findByStatus(status);
        logger.info("Retrieved {} customers with status: {}", customers.size(), status);
        
        return customers.stream()
            .map(customerMapper::toDTO)
            .collect(Collectors.toList());
    }
    
    @Override
    @Transactional(readOnly = true)
    public Page<CustomerDTO> searchCustomers(String searchTerm, Pageable pageable) {
        logger.info("Searching customers with term: {}", searchTerm);
        
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return getAllCustomers(pageable);
        }
        
        Page<Customer> customers = customerRepository.findBySearchTerm(
            searchTerm.trim(), pageable);
        
        logger.info("Found {} customers matching search term: {}", 
                   customers.getNumberOfElements(), searchTerm);
        
        return customers.map(customerMapper::toDTO);
    }
    
    @Override
    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return customerRepository.existsByEmail(email.toLowerCase());
    }
    
    private void validateCustomerData(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            throw new InvalidCustomerDataException("Customer data cannot be null");
        }
        
        if (customerDTO.getFirstName() == null || customerDTO.getFirstName().trim().isEmpty()) {
            throw new InvalidCustomerDataException("First name is required");
        }
        
        if (customerDTO.getLastName() == null || customerDTO.getLastName().trim().isEmpty()) {
            throw new InvalidCustomerDataException("Last name is required");
        }
        
        if (customerDTO.getEmail() == null || customerDTO.getEmail().trim().isEmpty()) {
            throw new InvalidCustomerDataException("Email is required");
        }
        
        if (customerDTO.getPhoneNumber() == null || customerDTO.getPhoneNumber().trim().isEmpty()) {
            throw new InvalidCustomerDataException("Phone number is required");
        }
        
        // Normalize email to lowercase
        customerDTO.setEmail(customerDTO.getEmail().toLowerCase().trim());
    }
}