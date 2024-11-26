package com.ReLi.service.interfaces;

import java.util.*;

import com.ReLi.model.dto.IODto;
import com.ReLi.model.dto.ReLiDto;
import com.ReLi.model.entity.ReLiEntity;

public interface ReLiServiceInterface {
    ReLiEntity saveReLiEntity(IODto ioDto);    
    
}
