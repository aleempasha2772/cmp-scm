package com.example.customer_service.Controller;

import com.example.customer_service.DTO.CustomerDTO;
import com.example.customer_service.Entity.CustomerStatus;
import com.example.customer_service.Service.CustomerService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin(origins = "*")
public class CustomerController {
    
    private static final Logger logger = LogManager.getLogger(CustomerController.class);
    
    private final CustomerService customerService;
    
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        logger.info("REST request to create customer with email: {}", customerDTO.getEmail());
        
        CustomerDTO createdCustomer = customerService.createCustomer(customerDTO);
        
        logger.info("Customer created successfully with ID: {}", createdCustomer.getId());
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        logger.info("REST request to get customer by ID: {}", id);
        
        CustomerDTO customer = customerService.getCustomerById(id);
        
        logger.info("Customer retrieved successfully with ID: {}", id);
        return ResponseEntity.ok(customer);
    }
    
    @GetMapping
    public ResponseEntity<Page<CustomerDTO>> getAllCustomers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir,
            @RequestParam(required = false) String search) {
        
        logger.info("REST request to get all customers - page: {}, size: {}, sortBy: {}, sortDir: {}", 
                   page, size, sortBy, sortDir);
        
        Sort.Direction direction = sortDir.equalsIgnoreCase("desc") 
            ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        
        Page<CustomerDTO> customers;
        if (search != null && !search.trim().isEmpty()) {
            customers = customerService.searchCustomers(search, pageable);
            logger.info("Search completed for term: {} - found {} customers", 
                       search, customers.getNumberOfElements());
        } else {
            customers = customerService.getAllCustomers(pageable);
            logger.info("Retrieved {} customers from page {}", 
                       customers.getNumberOfElements(), page);
        }
        
        return ResponseEntity.ok(customers);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<CustomerDTO>> getAllCustomersAsList() {
        logger.info("REST request to get all customers as list");
        
        List<CustomerDTO> customers = customerService.getAllCustomers();
        
        logger.info("Retrieved {} customers", customers.size());
        return ResponseEntity.ok(customers);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(
            @PathVariable Long id, 
            @Valid @RequestBody CustomerDTO customerDTO) {
        logger.info("REST request to update customer with ID: {}", id);
        
        CustomerDTO updatedCustomer = customerService.updateCustomer(id, customerDTO);
        
        logger.info("Customer updated successfully with ID: {}", id);
        return ResponseEntity.ok(updatedCustomer);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        logger.info("REST request to delete customer with ID: {}", id);
        
        customerService.deleteCustomer(id);
        
        logger.info("Customer deleted successfully with ID: {}", id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<CustomerDTO> getCustomerByEmail(@PathVariable String email) {
        logger.info("REST request to get customer by email: {}", email);
        
        CustomerDTO customer = customerService.getCustomerByEmail(email);
        
        logger.info("Customer retrieved successfully by email: {}", email);
        return ResponseEntity.ok(customer);
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<CustomerDTO>> getCustomersByStatus(@PathVariable CustomerStatus status) {
        logger.info("REST request to get customers by status: {}", status);
        
        List<CustomerDTO> customers = customerService.getCustomersByStatus(status);
        
        logger.info("Retrieved {} customers with status: {}", customers.size(), status);
        return ResponseEntity.ok(customers);
    }
    
    @GetMapping("/exists/{email}")
    public ResponseEntity<Boolean> checkCustomerExists(@PathVariable String email) {
        logger.info("REST request to check if customer exists with email: {}", email);
        
        boolean exists = customerService.existsByEmail(email);
        
        logger.info("Customer existence check for email: {} - result: {}", email, exists);
        return ResponseEntity.ok(exists);
    }
}