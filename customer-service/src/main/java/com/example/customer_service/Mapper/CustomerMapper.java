package com.example.customer_service.Mapper;


import org.springframework.stereotype.Component;

import com.example.customer_service.DTO.CustomerDTO;
import com.example.customer_service.Entity.Customer;

import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    
    private final AddressMapper addressMapper;
    
    public CustomerMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }
    
    public CustomerDTO toDTO(Customer customer) {
        if (customer == null) return null;
        
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setFirstName(customer.getFirstName());
        dto.setMiddleName(customer.getMiddleName());
        dto.setLastName(customer.getLastName());
        dto.setEmail(customer.getEmail());
        dto.setPhoneNumber(customer.getPhoneNumber());
        dto.setAlternatePhone(customer.getAlternatePhone());
        dto.setDateOfBirth(customer.getDateOfBirth());
        dto.setGender(customer.getGender());
        dto.setMaritalStatus(customer.getMaritalStatus());
        dto.setNationality(customer.getNationality());
        dto.setOccupation(customer.getOccupation());
        dto.setCompanyName(customer.getCompanyName());
        dto.setAnnualIncome(customer.getAnnualIncome());
        dto.setTaxId(customer.getTaxId());
        dto.setSocialSecurityNumber(customer.getSocialSecurityNumber());
        dto.setDriverLicenseNumber(customer.getDriverLicenseNumber());
        dto.setPassportNumber(customer.getPassportNumber());
        dto.setCustomerType(customer.getCustomerType());
        dto.setStatus(customer.getStatus());
        dto.setCreditScore(customer.getCreditScore());
        dto.setPreferredLanguage(customer.getPreferredLanguage());
        dto.setPreferredCommunication(customer.getPreferredCommunication());
        dto.setMarketingOptIn(customer.getMarketingOptIn());
        dto.setNotes(customer.getNotes());
        dto.setCreatedAt(customer.getCreatedAt());
        dto.setUpdatedAt(customer.getUpdatedAt());
        
        if (customer.getAddresses() != null) {
            dto.setAddresses(customer.getAddresses().stream()
                .map(addressMapper::toDTO)
                .collect(Collectors.toList()));
        }
        
        return dto;
    }
    
    public Customer toEntity(CustomerDTO dto) {
        if (dto == null) return null;
        
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setFirstName(dto.getFirstName());
        customer.setMiddleName(dto.getMiddleName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setAlternatePhone(dto.getAlternatePhone());
        customer.setDateOfBirth(dto.getDateOfBirth());
        customer.setGender(dto.getGender());
        customer.setMaritalStatus(dto.getMaritalStatus());
        customer.setNationality(dto.getNationality());
        customer.setOccupation(dto.getOccupation());
        customer.setCompanyName(dto.getCompanyName());
        customer.setAnnualIncome(dto.getAnnualIncome());
        customer.setTaxId(dto.getTaxId());
        customer.setSocialSecurityNumber(dto.getSocialSecurityNumber());
        customer.setDriverLicenseNumber(dto.getDriverLicenseNumber());
        customer.setPassportNumber(dto.getPassportNumber());
        customer.setCustomerType(dto.getCustomerType());
        customer.setStatus(dto.getStatus());
        customer.setCreditScore(dto.getCreditScore());
        customer.setPreferredLanguage(dto.getPreferredLanguage());
        customer.setPreferredCommunication(dto.getPreferredCommunication());
        customer.setMarketingOptIn(dto.getMarketingOptIn());
        customer.setNotes(dto.getNotes());
        
        if (dto.getAddresses() != null) {
            dto.getAddresses().forEach(addressDTO -> {
                customer.addAddress(addressMapper.toEntity(addressDTO));
            });
        }
        
        return customer;
    }
    
    public void updateEntityFromDTO(CustomerDTO dto, Customer customer) {
        if (dto == null || customer == null) return;
        
        customer.setFirstName(dto.getFirstName());
        customer.setMiddleName(dto.getMiddleName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setAlternatePhone(dto.getAlternatePhone());
        customer.setDateOfBirth(dto.getDateOfBirth());
        customer.setGender(dto.getGender());
        customer.setMaritalStatus(dto.getMaritalStatus());
        customer.setNationality(dto.getNationality());
        customer.setOccupation(dto.getOccupation());
        customer.setCompanyName(dto.getCompanyName());
        customer.setAnnualIncome(dto.getAnnualIncome());
        customer.setTaxId(dto.getTaxId());
        customer.setSocialSecurityNumber(dto.getSocialSecurityNumber());
        customer.setDriverLicenseNumber(dto.getDriverLicenseNumber());
        customer.setPassportNumber(dto.getPassportNumber());
        customer.setCustomerType(dto.getCustomerType());
        customer.setStatus(dto.getStatus());
        customer.setCreditScore(dto.getCreditScore());
        customer.setPreferredLanguage(dto.getPreferredLanguage());
        customer.setPreferredCommunication(dto.getPreferredCommunication());
        customer.setMarketingOptIn(dto.getMarketingOptIn());
        customer.setNotes(dto.getNotes());
    }
}
