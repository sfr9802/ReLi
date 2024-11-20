package com.ReLi.model.dto;

// Service 계층을 Entity로 바꾸고 Util로 변환하는 부분을 빼면 필요 없어질지도
public class SavedDTO {
	private Long id;
	private int userId;
	private String liStatus;
    private String reTime; //java.time.localTime
    private int liStatusCode;
    
    public void setId(Long id) {
    	this.id = id;
    }
    public Long getId() {
    	return id;
    }
    
    public void setUserId(int userId) {
    	this.userId = userId;
    }
    public int getUserId() {
    	return userId;
    }
    
    
    public void setLiStatus(String liStatus) {
    	this.liStatus = liStatus;
    }
    public String getLiStatus() {
    	return liStatus;
    }
    
    public void setLiStatusCode(int liStatusCode) {
    	this.liStatusCode = liStatusCode;
    }
    public int getLiStatusCode() {
    	return liStatusCode;
    }
    
    public void setReTime(String reTime) {
    	this.reTime = reTime;
    }
    public String getReTime() {
    	return reTime;
    }
}
