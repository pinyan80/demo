package com.mealstypes.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MealsTypesRepository extends JpaRepository<MealsTypesVO, Integer> {

	@Transactional
	@Modifying
	@Query(value="delate from meals where meals_types_id =?1", nativeQuery = true)
	void deleteByMealsId(int mealsTypeId);
}
