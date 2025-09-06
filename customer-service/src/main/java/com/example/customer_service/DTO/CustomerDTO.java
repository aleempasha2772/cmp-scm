package com.example.customer_service.DTO;



import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.example.customer_service.Entity.*;

public class CustomerDTO {
    private Long id;
    
    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;
    
    @Size(max = 50, message = "Middle name cannot exceed 50 characters")
    private String middleName;
    
    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;
    
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;
    
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "Phone number should be valid")
    private String phoneNumber;
    
    @Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "Alternate phone number should be valid")
    private String alternatePhone;
    
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;
    
    private Gender gender;
    private MaritalStatus maritalStatus;
    
    @Size(max = 50, message = "Nationality cannot exceed 50 characters")
    private String nationality;
    
    @Size(max = 50, message = "Occupation cannot exceed 50 characters")
    private String occupation;
    
    @Size(max = 100, message = "Company name cannot exceed 100 characters")
    private String companyName;
    
    private Double annualIncome;
    
    @Size(max = 20, message = "Tax ID cannot exceed 20 characters")
    private String taxId;
    
    @Size(max = 20, message = "Social security number cannot exceed 20 characters")
    private String socialSecurityNumber;
    
    @Size(max = 20, message = "Driver license number cannot exceed 20 characters")
    private String driverLicenseNumber;
    
    @Size(max = 20, message = "Passport number cannot exceed 20 characters")
    private String passportNumber;
    
    private CustomerType customerType;
    private CustomerStatus status;
    private Integer creditScore;
    
    @Size(max = 20, message = "Preferred language cannot exceed 20 characters")
    private String preferredLanguage;
    
    private CommunicationPreference preferredCommunication;
    private Boolean marketingOptIn;
    
    @Size(max = 500, message = "Notes cannot exceed 500 characters")
    private String notes;
    
    @Valid
    private List<AddressDTO> addresses;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    // Constructors
    public CustomerDTO() {}
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    public String getAlternatePhone() { return alternatePhone; }
    public void setAlternatePhone(String alternatePhone) { this.alternatePhone = alternatePhone; }
    
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    
    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }
    
    public MaritalStatus getMaritalStatus() { return maritalStatus; }
    public void setMaritalStatus(MaritalStatus maritalStatus) { this.maritalStatus = maritalStatus; }
    
    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }
    
    public String getOccupation() { return occupation; }
    public void setOccupation(String occupation) { this.occupation = occupation; }
    
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    
    public Double getAnnualIncome() { return annualIncome; }
    public void setAnnualIncome(Double annualIncome) { this.annualIncome = annualIncome; }
    
    public String getTaxId() { return taxId; }
    public void setTaxId(String taxId) { this.taxId = taxId; }
    
    public String getSocialSecurityNumber() { return socialSecurityNumber; }
    public void setSocialSecurityNumber(String socialSecurityNumber) { this.socialSecurityNumber = socialSecurityNumber; }
    
    public String getDriverLicenseNumber() { return driverLicenseNumber; }
    public void setDriverLicenseNumber(String driverLicenseNumber) { this.driverLicenseNumber = driverLicenseNumber; }
    
    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }
    
    public CustomerType getCustomerType() { return customerType; }
    public void setCustomerType(CustomerType customerType) { this.customerType = customerType; }
    
    public CustomerStatus getStatus() { return status; }
    public void setStatus(CustomerStatus status) { this.status = status; }
    
    public Integer getCreditScore() { return creditScore; }
    public void setCreditScore(Integer creditScore) { this.creditScore = creditScore; }
    
    public String getPreferredLanguage() { return preferredLanguage; }
    public void setPreferredLanguage(String preferredLanguage) { this.preferredLanguage = preferredLanguage; }
    
    public CommunicationPreference getPreferredCommunication() { return preferredCommunication; }
    public void setPreferredCommunication(CommunicationPreference preferredCommunication) { this.preferredCommunication = preferredCommunication; }
    
    public Boolean getMarketingOptIn() { return marketingOptIn; }
    public void setMarketingOptIn(Boolean marketingOptIn) { this.marketingOptIn = marketingOptIn; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    
    public List<AddressDTO> getAddresses() { return addresses; }
    public void setAddresses(List<AddressDTO> addresses) { this.addresses = addresses; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}