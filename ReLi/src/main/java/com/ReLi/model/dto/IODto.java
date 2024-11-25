package com.ReLi.model.dto;

//Controller I/O 전용 DTO

public class IODto {
	private Long id;
	private String userId;
	private String reLiStatus;
	private Integer reLiStatusCode;
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserId() {
		return userId;
	}
	
	public void setReLiStatus(String reLiStatus) {
		this.reLiStatus = reLiStatus;
	}
	public String getReLiStatus() {
		return reLiStatus;
	}
	
	public void setReLiStatusCode(Integer reLiStatusCode) {
		this.reLiStatusCode = reLiStatusCode;
	}
	public Integer getReLiStatusCode() {
		return reLiStatusCode;
	}
}
