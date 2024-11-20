package com.ReLi.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ReLi.model.entity.ReLiEntity;

public interface ReLiRepositoryInterface extends JpaRepository<ReLiEntity, Long>{
	// interface는 메소드 정의 시 접근제어자 생략 가능
	List<ReLiEntity> findAllByUserId(int userId);
    List<ReLiEntity> findAllByUserIdAndDeleteRecord(int userId, boolean deletedRecord);
	ReLiEntity findByUserId(int userId);
}
