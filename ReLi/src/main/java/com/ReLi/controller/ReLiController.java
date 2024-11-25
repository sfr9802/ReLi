package com.ReLi.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ReLi.model.dto.IODto;
import com.ReLi.model.dto.ReLiDto;
import com.ReLi.service.*;

@Controller
public class ReLiController {
	//get = findbyallUserid, post = saveEntity, delete(실제로는 save())Entity
	//save는 primary키가 중복일 때 update와 같은 역할 수행
	
	private ReLiService reLiService;
	
	public ReLiController(ReLiService reLiService) {
		this.reLiService = reLiService;
	}
	
	@PostMapping("/reLiCommit")
	public void reLiCommit(@RequestBody IODto ioDto ) {
		// IODto > ReLiDto convertor 추가
		// 매퍼 클래스 고려
		// 매퍼 클래스 = 변환기 짬통
		reLiService.saveReLiEntity();
	}
	
	@PostMapping("/reLiEdit")
	public void reLiEdit(@RequestBody IODto iioDto) {
		
	}
}
