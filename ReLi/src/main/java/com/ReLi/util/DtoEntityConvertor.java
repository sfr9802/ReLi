package com.ReLi.util;

import com.ReLi.model.dto.*;
import com.ReLi.model.entity.*;

public class DtoEntityConvertor {
	public ReLiEntity dtoToReLiEntity(ReLiDto reLiDto) {
		ReLiEntity reLiEntity = new ReLiEntity();
		reLiEntity.setUserId(reLiDto.getUserId());
		reLiEntity.setLiStatus(reLiDto.getLiStatus());
		reLiEntity.setLiStatusCode(reLiDto.getLiStatusCode());
		reLiEntity.setReTime(reLiDto.getReTime());
		
		return reLiEntity;
	}
	
	public ReLiEditEntity dtoToReLiEditEntity(ReLiDto reLiDto) {
		ReLiEditEntity reLiEditEntity = new ReLiEditEntity();
		reLiEditEntity.setUserId(reLiDto.getUserId());
		
		reLiEditEntity.setBeforeLiStatus(reLiDto.getLiStatus());
		reLiEditEntity.setAfterLiStatus(reLiDto.getNewReLiStatus());
		
		reLiEditEntity.setBeforeLiStatusCode(reLiDto.getLiStatusCode());
		reLiEditEntity.setAfterLiStatusCode(reLiDto.getNewReLiStatusCode());
		
		reLiEditEntity.setEditTime(reLiDto.getEditTime());
		
		return reLiEditEntity;
	}
	
}
