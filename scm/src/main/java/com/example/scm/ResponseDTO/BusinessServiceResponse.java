package com.example.scm.ResponseDTO;


public class BusinessServiceResponse {
	private Integer serviceId;
	private String serviceName;
	private Integer totalServiceSubcriptionCount;
	private Integer servicePrice;
	public Integer getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(Integer servicePrice) {
		this.servicePrice = servicePrice;
	}
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
	public BusinessServiceResponse(Integer serviceId, String serviceName, Integer totalServiceSubcriptionCount,Integer servicePrice) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.totalServiceSubcriptionCount = totalServiceSubcriptionCount;
		this.servicePrice = servicePrice;
	}
	public BusinessServiceResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", serviceName=" + serviceName + ", totalServiceSubcriptionCount="
				+ totalServiceSubcriptionCount + "]";
	}
	
	
}
