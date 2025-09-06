package com.example.customer_service.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @Size(max = 50, message = "Middle name cannot exceed 50 characters")
    @Column(name = "middle_name")
    private String middleName;
    
    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "Phone number should be valid")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    
    @Column(name = "alternate_phone")
    @Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "Alternate phone number should be valid")
    private String alternatePhone;
    
    @Past(message = "Date of birth must be in the past")
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status")
    private MaritalStatus maritalStatus;
    
    @Size(max = 50, message = "Nationality cannot exceed 50 characters")
    @Column(name = "nationality")
    private String nationality;
    
    @Size(max = 50, message = "Occupation cannot exceed 50 characters")
    @Column(name = "occupation")
    private String occupation;
    
    @Size(max = 100, message = "Company name cannot exceed 100 characters")
    @Column(name = "company_name")
    private String companyName;
    
    @Column(name = "annual_income")
    private Double annualIncome;
    
    @Size(max = 20, message = "Tax ID cannot exceed 20 characters")
    @Column(name = "tax_id")
    private String taxId;
    
    @Size(max = 20, message = "Social security number cannot exceed 20 characters")
    @Column(name = "social_security_number")
    private String socialSecurityNumber;
    
    @Size(max = 20, message = "Driver license number cannot exceed 20 characters")
    @Column(name = "driver_license_number")
    private String driverLicenseNumber;
    
    @Size(max = 20, message = "Passport number cannot exceed 20 characters")
    @Column(name = "passport_number")
    private String passportNumber;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "customer_type")
    private CustomerType customerType = CustomerType.INDIVIDUAL;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CustomerStatus status = CustomerStatus.ACTIVE;
    
    @Column(name = "credit_score")
    private Integer creditScore;
    
    @Size(max = 20, message = "Preferred language cannot exceed 20 characters")
    @Column(name = "preferred_language")
    private String preferredLanguage;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "preferred_communication")
    private CommunicationPreference preferredCommunication;
    
    @Column(name = "marketing_opt_in")
    private Boolean marketingOptIn = false;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Size(max = 500, message = "Notes cannot exceed 500 characters")
    @Column(name = "notes")
    private String notes;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Address> addresses = new ArrayList<>();
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    // Constructors
    public Customer() {}
    
    public Customer(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
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
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    
    public List<Address> getAddresses() { return addresses; }
    public void setAddresses(List<Address> addresses) { this.addresses = addresses; }
    
    public void addAddress(Address address) {
        addresses.add(address);
        address.setCustomer(this);
    }
    
    public void removeAddress(Address address) {
        addresses.remove(address);
        address.setCustomer(null);
    }
}