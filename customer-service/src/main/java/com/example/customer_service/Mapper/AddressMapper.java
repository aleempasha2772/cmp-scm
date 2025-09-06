package com.example.customer_service.Mapper;


import org.springframework.stereotype.Component;

import com.example.customer_service.DTO.AddressDTO;
import com.example.customer_service.Entity.Address;

@Component
public class AddressMapper {
    
    public AddressDTO toDTO(Address address) {
        if (address == null) return null;
        
        AddressDTO dto = new AddressDTO();
        dto.setId(address.getId());
        dto.setAddressType(address.getAddressType());
        dto.setStreetAddress(address.getStreetAddress());
        dto.setStreetAddress2(address.getStreetAddress2());
        dto.setCity(address.getCity());
        dto.setStateProvince(address.getStateProvince());
        dto.setPostalCode(address.getPostalCode());
        dto.setCountry(address.getCountry());
        dto.setIsPrimary(address.getIsPrimary());
        
        return dto;
    }
    
    public Address toEntity(AddressDTO dto) {
        if (dto == null) return null;
        
        Address address = new Address();
        address.setId(dto.getId());
        address.setAddressType(dto.getAddressType());
        address.setStreetAddress(dto.getStreetAddress());
        address.setStreetAddress2(dto.getStreetAddress2());
        address.setCity(dto.getCity());
        address.setStateProvince(dto.getStateProvince());
        address.setPostalCode(dto.getPostalCode());
        address.setCountry(dto.getCountry());
        address.setIsPrimary(dto.getIsPrimary());
        
        return address;
    }
}