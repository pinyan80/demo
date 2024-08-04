package com.morning.meals.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MealsRepository extends JpaRepository<MealsVO, Integer> {

//	所有餐點數量
	@Query(value = "SELECT COUNT(*) FROM meals;", nativeQuery = true)
	Integer getmealsnumber();

//	指定餐點的平均評分
	@Query(value = "SELECT AVG(meals_score) FROM orddetails where meals_id=?1", nativeQuery = true)
	Double getavgscore(Integer mealsId);

//	更新餐點評分
	@Modifying
	@Query(value = "UPDATE meals SET meals_total_score = ?1 WHERE meals_id = ?2", nativeQuery = true)
	Integer updateMealsScore(Double mealsScore, Integer mealsId);
}
