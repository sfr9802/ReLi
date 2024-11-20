package com.ReLi.model.dto;

public class DtoForEdit {
	private String newReLiStatus;
	private int newReLiStatusCode;
	private String editTime;
	
	public void setNewReLiStatus(String newReLiStatus) {
		this.newReLiStatus = newReLiStatus;
	}
	public String getNewReLiStatus() {
		return newReLiStatus;
	}
	
	public void setNewReLiStatusCode(int newReLiStatusCode) {
		this.newReLiStatusCode = newReLiStatusCode;
	}
	public int getNewReLiStatusCode() {
		return newReLiStatusCode;
	}
	
	public void setEditTime(String editTime) {
		this.editTime = editTime;
	}
	public String getEditTime() {
		return editTime;
	}
	
	
}
