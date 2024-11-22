package com.ReLi.model.dto;

public class ReLiDto {
	
	private Long id;
	private Integer userId;
	private String liStatus;
	private String reTime;
	private Integer liStatusCode;
	private String newReLiStatus;
	private Integer newReLiStatusCode;
	private String editTime;
	
	private ReLiDto(Builder builder) {
		// DTO의 필드를 선택적으로 구성하기 위함.
		// 해당 필드의 요소가 전달되었을때만 DTO 필드로 생성
		if (builder.id != null) {
			this.id = builder.id;
		}
		
		if (builder.userId != null) {
			this.userId = builder.userId;
		}
		
		if (builder.liStatus != null) {
			this.liStatus = builder.liStatus;
		}
		
		if (builder.reTime != null) {
			this.reTime = builder.reTime;
		}
		
		if (builder.liStatusCode != null) {
			this.liStatusCode = builder.liStatusCode;
		}
		
		if (builder.newReLiStatus != null) {
			this.newReLiStatus = builder.newReLiStatus;
		}
		
		if (builder.newReLiStatusCode != null) {
		    this.newReLiStatusCode = builder.newReLiStatusCode;
		}
		
		if (builder.editTime != null) {
			this.editTime = builder.editTime;
		}
	}
	
	public static class Builder{
		private Long id = null;
		private Integer userId = null;
		private String liStatus = null;
		private String reTime = null;
		private Integer liStatusCode = null;
		private String newReLiStatus = null;
		private Integer newReLiStatusCode = null;
		private String editTime = null;
		
		public Builder() {
			
		}
		
		public Builder id(Long id) {
			this.id = id;
			return this;
		}
		public Builder userId(Integer userId) {
			this.userId = userId;
			return this;
		}
		public Builder liStatus(String liStatus) {
			this.liStatus = liStatus;
			return this;
		}
		public Builder reTime(String reTime) {
			this.reTime = reTime;
			return this;
		}
		public Builder liStatusCode(Integer liStatusCode) {
			this.liStatusCode = liStatusCode;
			return this;
		}
		public Builder newReLiStatus(String newReLiStatus) {
			this.newReLiStatus = newReLiStatus;
			return this;
		}
		public Builder newReLiStatusCode(Integer newReLiStatusCode) {
			this.newReLiStatusCode = newReLiStatusCode;
			return this;
		}
		public Builder editTime(String editTime) {
			this.editTime = editTime;
			return this;
		}
		public ReLiDto build() {
			return new ReLiDto(this);
		}
		
	}
	//getters
	public Long getId() {
		return id;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public String getLiStatus() {
		return liStatus;
	}
	
	public String getReTime() {
		return reTime;
	}
	
	public Integer getLiStatusCode() {
		return liStatusCode;
	}
	
	public String getNewReLiStatus() {
		return newReLiStatus;
	}
	
	public Integer getNewReLiStatusCode() {
		return newReLiStatusCode;
	}
	
	public String getEditTime() {
		return editTime;
	}
}
