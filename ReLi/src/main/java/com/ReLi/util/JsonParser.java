package com.ReLi.util;

import com.ReLi.model.dto.ReLiDto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.*;

public class JsonParser {
	//Json을 ReLiEntity로 파싱하는 메소드
	// 0, null 값은 교체 필, 아마 Restfull API 요청 받았을 때 쓰일?듯
	// 일단 String으로 다 받고 각 타입에 맞게 paserInt같은걸로 바꾸기
	
	// 선택해서 받게 하면 Gson을 쓸수 있나...
	// 빌더패턴 쓴 DTO 클래스 하나로 입력 변환 퉁치기
//	public ReLiDto reLiJsonToDto(JsonObject jsonObject) {
//		Gson gson = new GsonBuilder()
//		        .registerTypeAdapter(ReLiDto.class, new ReLiDtoDeserializer())
//		        .create();
//       // 알아서 자료형 매핑, return 타입은 ReLiDTOModel 
//      return gson.fromJson(jsonObject, ReLiDto.class);
//  }
	
//	public JsonObject reLiDtoToJson(ReLiDto reLidto) {
//		Gson gson = new Gson();
//        // DTO를 바로 JsonObject로 변환, 자료형 매핑 해줌
//		return gson.toJsonTree(reLidto).getAsJsonObject();
//	}
	
	
}
