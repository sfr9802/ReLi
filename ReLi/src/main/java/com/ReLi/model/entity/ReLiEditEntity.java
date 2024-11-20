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
	private int beforeLiStatusCode;
	@Size(min = 0, max = 3)
	private int afterLiStatusCode;
	
	private int editCount;
	
	private String editTime;
	
	
	// ReLiEntity's primary key
	public void setId(Long id) {
		this.id = id;
	}
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
	
	public void setBeforeLiStatusCode(int beforeLiStatusCode) {
		this.beforeLiStatusCode = beforeLiStatusCode;
	}
	public int getBeforeLiStatusCode() {
		return beforeLiStatusCode;
	}
	
	public void setAfterLiStatusCode(int afterLiStatusCode) {
		this.afterLiStatusCode = afterLiStatusCode;
	}
	public int getAfterLiStatusCode() {
		return afterLiStatusCode;
	}
	
	public void setEditCount(int editCount) {
		this.editCount = editCount;
	}
	public int getEditCount() {
		return editCount;
	}
	
	public void setEditTime(String editTime) {
		this.editTime = editTime;
	}
	public String getEditTime() {
		return editTime;
	}

	
}
