package com.ReLi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ReLi.model.dto.IODto;
import com.ReLi.model.entity.ReLiEntity;
import com.ReLi.service.*;
import com.ReLi.util.DtoEntityConvertor;


@Controller
public class ReLiController {
	//get = findbyallUserid, post = saveEntity, delete(실제로는 save())Entity
	//save 는 primary 키가 중복일 때 update 와 같은 역할 수행
	
	private ReLiService reLiService;
	
	public ReLiController(ReLiService reLiService) {
		this.reLiService = reLiService;
	}
	
	// 리턴 타입 변경
	// 아마 다 save 로 해놔서 알아서 반환을 할거라
	// return 만 붙이면 될것같기도
	
	@PostMapping("/reLiCommit")
	public ResponseEntity<IODto> reLiCommit(@RequestBody IODto inputDto ) {
		ReLiEntity reLiEntity = reLiService.saveReLiEntity(inputDto);
		IODto outputDto = DtoEntityConvertor.reLiEntityToIODto(reLiEntity);
		return ResponseEntity.ok(outputDto);
	}
	
	@PostMapping("/reLiEdit")
	public ResponseEntity<IODto> reLiEdit(@RequestBody IODto inputDto) {
		ReLiEntity reLiEntity = reLiService.editRecord(inputDto);
		IODto outputDto = DtoEntityConvertor.reLiEntityToIODto(reLiEntity);
		return ResponseEntity.ok(outputDto);
	}
	
	// 입력 수정해야함
	// userId만 받아올수가 있으니가 그걸로 찾고 돌리게 
	// service 에서 수정
	// ResponseEntity 사용, List<Entity> 타입은 스트림 사용해서 DTO로 변환하고
	// ResponseEntity 로 래핑하여 리턴해주면 뚝딱 -> service 에서 처리
	@GetMapping("/reLiAllList/{userId}")
	public ResponseEntity<List<IODto>> reLiAllList(@RequestBody IODto ioDto) {
		List<IODto> listIoDto = reLiService.readUserAllRecord(ioDto);
		return ResponseEntity.ok(listIoDto);
	}
	
	// 여기도 그냥 그 ReLi 고유 id 만 받아와서 써도 될듯
	// 아니다 어차피 로직에 들어있긴하네
	@PostMapping("/reLiDelete")
	public void reLiDelete(@RequestBody IODto ioDto) {
		reLiService.deleteRecord(ioDto);
	}
	
	// 
	
}
