package com.ReLi.model.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ReLiEditEntity {
	
	private Long id;
	private int userId;
	
	private String beforeLiStatus;
	@NotNull
	private String afterLiStatus;
	
	@Size(min = 0, max = 3)
	private Integer beforeLiStatusCode;
	@Size(min = 0, max = 3)
	private Integer afterLiStatusCode;
	
	
	
	private String editTime;
	
	
	// ReLiEntity's primary key
	public Long getId() {
		return id;
	}
	
	// ReLientity's UserId 
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
	
	public void setBeforeLiStatus(String beforeLiStatus) {
		this.beforeLiStatus = beforeLiStatus;
	}
	public String getBeforeLiStatus() {
		return beforeLiStatus;
	}
	
	public void setAfterLiStatus(String afterLiStatus) {
		this.afterLiStatus = afterLiStatus;
	}
	public String getAfterLiStatus() {
		return afterLiStatus;
	}
	
	public void setBeforeLiStatusCode(Integer beforeLiStatusCode) {
		this.beforeLiStatusCode = beforeLiStatusCode;
	}
	public Integer getBeforeLiStatusCode() {
		return beforeLiStatusCode;
	}
	
	public void setAfterLiStatusCode(Integer afterLiStatusCode) {
		this.afterLiStatusCode = afterLiStatusCode;
	}
	public Integer getAfterLiStatusCode() {
		return afterLiStatusCode;
	}
	
	public void setEditTime(String editTime) {
		this.editTime = editTime;
	}
	public String getEditTime() {
		return editTime;
	}

	
}
