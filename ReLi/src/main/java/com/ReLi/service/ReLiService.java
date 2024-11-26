package com.ReLi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ReLi.model.dto.IODto;
import com.ReLi.model.dto.ReLiDto;
import com.ReLi.model.entity.ReLiEditEntity;
import com.ReLi.model.entity.ReLiEntity;
import com.ReLi.model.repository.ReLiEditRepoInterface;
import com.ReLi.model.repository.ReLiRepositoryInterface;
import com.ReLi.service.interfaces.ReLiServiceInterface;
import com.ReLi.util.*;

	// 1. userId 받아오기 / O
	// 2. ReLiStatusCode 분기 로직 / 안해도될듯
	// 3. Status Text 받아오기 + 저장  / O
	//
	// 1. 삭제 취소, 추가 취소, 추가 취소를 취소는 삭제 취소 호출하?면될지도?, 추가된것 수정
	// 수정은 아예 다른 테이블로? ex) 수정 시도한 Entity 정보와 수정 시도한 시간 정보 컬럼까지. 삭제 이력도
	// |ID|BeforeLiStatus|AfterLiStatus|BeforeLiStatusCode|AfterLiStatusCode|UndoCount|EditTime|
	// 보통 서비스 계층에서는 Entity, 컨트롤러 에서 DTO사용함
	// 현재 DTO 입력으로 받는애들 싹 다 Entity로 변경

@Service
public class ReLiService implements ReLiServiceInterface{
	
	private final ReLiRepositoryInterface reLiRepositoryInterface;
	private final ReLiEditRepoInterface reLiEditRepoInterface;
	
	@Autowired
	public ReLiService(ReLiRepositoryInterface reLiRepositoryInterface, ReLiEditRepoInterface reLiEditRepoInterface) {
		this.reLiRepositoryInterface = reLiRepositoryInterface;
		this.reLiEditRepoInterface = reLiEditRepoInterface;
	}
	
	// DB 레코드 추가
	@Override
	public ReLiEntity saveReLiEntity(IODto ioDto) {
		
		ReLiDto reLiDto = ReLiMapper.IoDtoToReLiDto(ioDto);
		// DTO -> Entity
		ReLiEntity reLiEntity = DtoEntityConvertor.dtoToReLiEntity(reLiDto);
		
		// Entity > DB
		return reLiRepositoryInterface.save(reLiEntity);
	}
	
	// select*from table where UserId
	public List<IODto> readUserAllRecord(IODto ioDto) {
		ReLiDto reLiDto = ReLiMapper.IoDtoToReLiDto(ioDto);
		int userId = reLiDto.getUserId();
		
		// 전체 레코드에서 userId 가 해당되는것만 조회
		List<ReLiEntity> listReLiEntity = reLiRepositoryInterface.findAllByUserId(userId);
		
		// List<Entity> -> List<IODto> 스트림 사용하여 처리
		List<IODto> dtoList = listReLiEntity.stream()
                .map(DtoEntityConvertor::reLiEntityToIODto)
                .collect(Collectors.toList());
	    return dtoList;
	}
	
	public List<ReLiEntity> readUsersAllDeletedRecord(int userId){
		return reLiRepositoryInterface.findAllByUserIdAndDeleteRecord(userId, true);
	}
	
	
	// update DeletedRecord from table where reLiEntity.UserId
	// http로 해당 Json 보내주고 Entity로 변환 후 아래 메소드로
	// 조회하는거 빼도될것같은... 어차피 ioDto 로 해당 id 랑 다 받아오니가
	public ReLiEntity deleteRecord(IODto ioDto) {
		ReLiDto reLiDto = ReLiMapper.IoDtoToReLiDto(ioDto);
		
		// 매개변수 type ReLiDTOModel로 수정
		Long id = reLiDto.getId();
		Optional<ReLiEntity> reLiEntity = reLiRepositoryInterface.findById(id);
		if (reLiEntity.isPresent()) {
			reLiEntity.get().setDeletedRecord(true);
		} 
		return reLiRepositoryInterface.save(reLiEntity.get());
	}
	
	// 선택된 삭제 항목 리스트 받아서 DeleteRecord 변경
	@Transactional
	public void undoDeleteRecords(List<Long> ids) {
		// 선택 항목이 여러개 일때
		if (ids.size()>1) {
			List<ReLiEntity> deletedRecords = reLiRepositoryInterface.findAllById(ids);
			for (ReLiEntity re : deletedRecords) {
				re.setDeletedRecord(false);
				reLiRepositoryInterface.save(re);
			}
			// 선택 항목이 한개일때
		} else {
			Optional<ReLiEntity> reLiEntity = reLiRepositoryInterface.findById(ids.get(0));
			if (reLiEntity.isPresent()) {
				reLiEntity.get().setDeletedRecord(false);
			} else {
				// log.warn("선택 항목이 없음");
			}
		}
	}
	
	// 입력 파라미터 교체, Dto > Entity 부분 util method사용하는 로직으로 변경.
	public ReLiEntity editRecord(IODto ioDto) {
	    // 1. DTO를 ReLiDto로 변환
	    ReLiDto reLiDto = ReLiMapper.IoDtoToReLiDto(ioDto);

	    // 2. Legacy Entity 조회 및 검증
	    ReLiEntity legacyEntity = reLiRepositoryInterface.findById(reLiDto.getId())
	            .orElseThrow(() -> new IllegalArgumentException("Entity not found for ID: " + reLiDto.getId()));

	    // 3. Edit Entity 생성 및 저장
	    ReLiEditEntity reLiEditEntity = DtoEntityConvertor.dtoToReLiEditEntity(reLiDto);
	    reLiEditRepoInterface.save(reLiEditEntity);

	    // 4. Legacy Entity 업데이트 후 저장
	    legacyEntity.setLiStatus(reLiEditEntity.getAfterLiStatus());
	    legacyEntity.setLiStatusCode(reLiEditEntity.getAfterLiStatusCode());
	    reLiRepositoryInterface.save(legacyEntity);

	    return legacyEntity;
	}

	


    
	
	
}
