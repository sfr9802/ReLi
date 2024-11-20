package com.ReLi.model.dto;

// ReLiNewDTO
public class ReLiDTOModel {

    private int userId;
//    private Long reLiIndex;
    private String liStatus;
    private String reTime; //java.time.localTime
    private int liStatusCode;

    public void setUserId(int userId){
        this.userId = userId;
    }
    public int getUserId(){
        return userId;
    }

//    public void setReLiIndex(Long reLiIndex){
//        this.reLiIndex = reLiIndex;
//    }
//    public Long getReLiIndex(){
//        return reLiIndex;
//    }

    public void setLiStatus(String liStatus){
        this.liStatus = liStatus;
    }
    public String getLiStatus(){
        return liStatus;
    }

    public void setReTime(String reTime){
        this.reTime = reTime;
    }
    public String getRetime(){
        return reTime;
    }

    public void setLiStatusCode(int liStatusCode){
        this.liStatusCode = liStatusCode;
    }
    public int getLiStatusCode(){
        return liStatusCode;
    }
}
