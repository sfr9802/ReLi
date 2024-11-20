package com.ReLi.service.interfaces;

import java.util.*;

import com.ReLi.model.dto.ReLiDTOModel;
import com.ReLi.model.entity.ReLiEntity;

public interface ReLiServiceInterface {
    ReLiEntity saveReLiEntity(ReLiDTOModel reLiDtoModel);
    
}
