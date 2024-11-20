package com.ReLi.util;

import com.ReLi.model.ReLiDTOModel;
import com.ReLi.model.SavedDTO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.*;

public class JsonParser {
	//Json을 ReLiEntity로 파싱하는 메소드
	// 0, null 값은 교체 필, 아마 Restfull API 요청 받았을 때 쓰일?듯
	// 일단 String으로 다 받고 각 타입에 맞게 paserInt같은걸로 바꾸기
	
	
	public ReLiDTOModel reLiJsonToDto(JsonObject jsonObject) {
        Gson gson = new Gson();
        // 알아서 자료형 매핑, return 타입은 ReLiDTOModel 
        return gson.fromJson(jsonObject, ReLiDTOModel.class);
    }
	public JsonObject reLiDtoToJson(ReLiDTOModel reLiDTOModel) {
        Gson gson = new Gson();
        // DTO를 바로 JsonObject로 변환, 자료형 매핑 해줌
        return gson.toJsonTree(reLiDTOModel).getAsJsonObject();
    }
	
	
	public SavedDTO savedReLiJsonToDto(JsonObject jsonObject) {
		Gson gson = new Gson();
		return gson.fromJson(jsonObject, SavedDTO.class);
	}
	public JsonObject savedReLiDtoToJson(SavedDTO savedDto) {
		Gson gson = new Gson();
		return gson.toJsonTree(savedDto).getAsJsonObject();
	}
}
