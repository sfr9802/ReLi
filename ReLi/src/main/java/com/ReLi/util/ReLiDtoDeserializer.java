package com.ReLi.util;

import com.ReLi.model.dto.ReLiDto;
import com.google.gson.*;
import java.lang.reflect.Type;

public class ReLiDtoDeserializer implements JsonDeserializer<ReLiDto> {
    @Override
    public ReLiDto deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        // 빌더를 사용해 객체 생성
        ReLiDto.Builder builder = new ReLiDto.Builder();

        if (jsonObject.has("id") && !jsonObject.get("id").isJsonNull()) {
            builder.id(jsonObject.get("id").getAsLong());
        }

        if (jsonObject.has("userId") && !jsonObject.get("userId").isJsonNull()) {
            builder.userId(jsonObject.get("userId").getAsInt());
        }

        if (jsonObject.has("liStatus") && !jsonObject.get("liStatus").isJsonNull()) {
            builder.liStatus(jsonObject.get("liStatus").getAsString());
        }

        if (jsonObject.has("reTime") && !jsonObject.get("reTime").isJsonNull()) {
            builder.reTime(jsonObject.get("reTime").getAsString());
        }

        if (jsonObject.has("liStatusCode") && !jsonObject.get("liStatusCode").isJsonNull()) {
            builder.liStatusCode(jsonObject.get("liStatusCode").getAsInt());
        }

        if (jsonObject.has("newReLiStatus") && !jsonObject.get("newReLiStatus").isJsonNull()) {
            builder.newReLiStatus(jsonObject.get("newReLiStatus").getAsString());
        }

        if (jsonObject.has("newReLiStatusCode") && !jsonObject.get("newReLiStatusCode").isJsonNull()) {
            builder.newReLiStatusCode(jsonObject.get("newReLiStatusCode").getAsInt());
        }

        if (jsonObject.has("editTime") && !jsonObject.get("editTime").isJsonNull()) {
            builder.editTime(jsonObject.get("editTime").getAsString());
        }

        return builder.build();
    }
}
