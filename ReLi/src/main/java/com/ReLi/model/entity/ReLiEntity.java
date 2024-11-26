package com.ReLi.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(
	    uniqueConstraints = {@UniqueConstraint(columnNames = {"userId", "userReLiIndex"})} // 유저 ID와 인덱스의 유니크 제약 조건
	)
public class ReLiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Integer userId;
    
//  private Long userReLiIndex;
    
    @NotBlank(message = "필수 입력 항목")
    @NotNull
    private String liStatus;
    
    private String reTime; // java.time.LocalTime
    
    // 0,1,2,3 One Hot Encoding, 그냥 0~3으로 입력 받아도 문제없을듯
    @Size(min = 0, max = 3)
    private Integer liStatusCode;
    
    private boolean deletedRecord;

    public ReLiEntity(){

    }
    
    //id getter setter
    
    public Long getId(){
        return id;
    }
    
    public void setUserId(Integer userId) {
    	this.userId = userId;
    }
    public Integer getUserid() {
    	return userId;
    }

    // liStatus getter setter
    public void setLiStatus(String liStatus){
        this.liStatus = liStatus; 
    }
    public String getLiStatus(){
        return liStatus;
    }
    
    // reTime getter setter
    public void setReTime(String reTime){
        this.reTime = reTime;
    }
    public String getReTime(){
        return reTime;
    }
    
    // liStatusCode getter setter
    public void setLiStatusCode(Integer liStatusCode){
        this.liStatusCode = liStatusCode;
    }
    public Integer getLiStatusCode(){
        return liStatusCode;
    }
    
    // recordUsable getter setter
    public void setDeletedRecord(boolean deletedRecord) {
    	this.deletedRecord = deletedRecord;
    }
    public boolean getDeletedRecord() {
    	return deletedRecord;
    }

}
