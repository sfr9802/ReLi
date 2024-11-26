package com.ReLi.util;

import com.ReLi.model.dto.IODto;
import com.ReLi.model.dto.ReLiDto;

public class ReLiMapper {
	
	// I/O 전용 DTO -> Entity 변환 전용 DTO인 ReLiDto로 변환
	public static ReLiDto IoDtoToReLiDto(IODto ioDto) {
		return ReLiDto.builder()
				.id(ioDto.getId())
				.userId(ioDto.getUserId())
				.liStatus(ioDto.getReLiStatus())
				.liStatusCode(ioDto.getReLiStatusCode())
				.build();
	}
	
	// Entity 에서 ReLiDto 로 변환 후 -> I/O 전용 DTO 변환
	public static IODto ReLiDtotoIoDto(ReLiDto reLiDto) {
		
		IODto ioDto = new IODto();
		
		ioDto.setId(reLiDto.getId());
		ioDto.setUserId(reLiDto.getUserId());
		ioDto.setReLiStatus(reLiDto.getLiStatus());
		ioDto.setReLiStatusCode(reLiDto.getLiStatusCode());
		
		return ioDto;
	}
	
	// before / after 
	
}
