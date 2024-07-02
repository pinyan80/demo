package com.collect.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CollectRepository extends JpaRepository<CollectVO, Integer> {

	@Transactional
	@Query(value = "from CollectVO where memNo =?1 and favorite=false")
	List<CollectVO> findAllFBymemNo(int memNo);
	
	@Transactional
	@Query(value = "from CollectVO where memNo =?1 and favorite=ture")
	List<CollectVO> findAllTBymemNo(int memNO);

}
