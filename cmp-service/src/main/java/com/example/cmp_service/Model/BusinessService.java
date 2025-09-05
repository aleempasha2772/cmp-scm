package com.example.cmp_service.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "businessservice")
public class BusinessService {
	@Id
	private Integer serviceId;
	private String serviceName;
	private Integer totalServiceSubcriptionCount;
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Integer getTotalServiceSubcriptionCount() {
		return totalServiceSubcriptionCount;
	}
	public void setTotalServiceSubcriptionCount(Integer totalServiceSubcriptionCount) {
		this.totalServiceSubcriptionCount = totalServiceSubcriptionCount;
	}
	public BusinessService(Integer serviceId, String serviceName, Integer totalServiceSubcriptionCount) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.totalServiceSubcriptionCount = totalServiceSubcriptionCount;
	}
	public BusinessService() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", serviceName=" + serviceName + ", totalServiceSubcriptionCount="
				+ totalServiceSubcriptionCount + "]";
	}
	
	
}
