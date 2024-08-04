package com.morning.mealspic.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MealsPicRepository extends JpaRepository<MealsPicVO, Integer> {

//	查詢圖片只拿第一張
	@Query(value = "select * from meal_picture where meals_id =?1 limit 1", nativeQuery = true)
	MealsPicVO getPicByMealsId(Integer mealsId);

//	查詢所有圖片
	@Query(value = "select * from meal_picture where meal_pic_id =?1", nativeQuery = true)
	List<MealsPicVO> getPicsByMealsId(Integer mealPicId);

//	刪除圖片
	@Modifying
	@Query(value = "delete from meal_picture where meal_pic_id =?1", nativeQuery = true)
	void deleteByMealsPicId(Integer mealPicId);
}
