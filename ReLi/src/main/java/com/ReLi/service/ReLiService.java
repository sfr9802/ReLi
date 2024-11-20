package com.ReLi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ReLi.model.dto.DtoForEdit;
import com.ReLi.model.dto.ReLiDTOModel;
import com.ReLi.model.dto.SavedDTO;
import com.ReLi.model.entity.ReLiEditEntity;
import com.ReLi.model.entity.ReLiEntity;
import com.ReLi.model.repository.ReLiRepositoryInterface;
import com.ReLi.service.interfaces.ReLiServiceInterface;

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
	
	public ReLiService(ReLiRepositoryInterface reLiRepositoryInterface) {
		this.reLiRepositoryInterface = reLiRepositoryInterface;
	}
	
	// DB 레코드 추가
	@Override
	public ReLiEntity saveReLiEntity(ReLiDTOModel reLiDTOModel) {
		
		// 이 부분 Util 쪽에 변환하는 클래스 제작
		String reLiStatus = reLiDTOModel.getLiStatus();
		int liStatusCode = reLiDTOModel.getLiStatusCode();
		String reTime = reLiDTOModel.getRetime();
		
		// DTO -> Entity
		ReLiEntity reLiEntity = new ReLiEntity();
		reLiEntity.setLiStatus(reLiStatus);
		reLiEntity.setLiStatusCode(liStatusCode);
		reLiEntity.setDeletedRecord(false);
		reLiEntity.setReTime(reTime); 
		
		// Entity > DB
		return reLiRepositoryInterface.save(reLiEntity);
	}
	
	// select*from table where UserId
	public List<ReLiEntity> readUserAllRecord(ReLiDTOModel reLiDTOModel) {
		int userId = reLiDTOModel.getUserId();
	    return reLiRepositoryInterface.findAllByUserId(userId);
	}
	
	public List<ReLiEntity> readUsersAllDeletedRecord(int userId){
		return reLiRepositoryInterface.findAllByUserIdAndDeleteRecord(userId, true);
	}
	
	// update DeletedRecord from table where reLiEntity.UserId
	// http로 해당 Json 보내주고 Entity로 변환 후 아래 메소드로
	public ReLiEntity deleteRecord(SavedDTO savedDTO) {
		// 매개변수 type ReLiDTOModel로 수정
		Long id = savedDTO.getId();
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
	
	
	public void editRecord(SavedDTO savedDto, DtoForEdit dtoForEdit) {
		Long id = savedDto.getId();
		ReLiEntity editTargetEntity = new ReLiEntity();
		Optional<ReLiEntity> reLiEntity = reLiRepositoryInterface.findById(id);
		if (reLiEntity.isPresent()) {
			
			editTargetEntity = reLiEntity.get();
			
			ReLiEditEntity reLiEditEntity = new ReLiEditEntity();
			reLiEditEntity.setId(editTargetEntity.getId());
			
			reLiEditEntity.setBeforeLiStatus(editTargetEntity.getLiStatus());
			reLiEditEntity.setBeforeLiStatusCode(editTargetEntity.getLiStatusCode());
			
			reLiEditEntity.setAfterLiStatus(dtoForEdit.getNewReLiStatus());
			reLiEditEntity.setAfterLiStatusCode(dtoForEdit.getNewReLiStatusCode());
			
			reLiEditEntity.setEditTime(dtoForEdit.getEditTime());
			
			
		}
	}
	


    
	
	
}
