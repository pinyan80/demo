package com.morning.mealspic.model;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mealspicService")
public class MealsPicService {

	@Autowired
	MealsPicRepository repository;

	@Autowired
	private SessionFactory sessionFactory;

//	修改取多張圖片
	public List<MealsPicVO> getPicsByMealsId(Integer mealPicId) {
		return repository.getPicsByMealsId(mealPicId);
	}

//	取一張圖片(前端畫面用)
	public MealsPicVO getPicByMealsId(Integer mealsId) {  //顯示第一張圖片
		return repository.getPicByMealsId(mealsId);
	}

//	新增圖片
	public void addMealsPic(MealsPicVO mealspicVO) {
		repository.save(mealspicVO);
	}

//	修改圖片
	public void updateMealsPic(MealsPicVO mealspicVO) {
		repository.save(mealspicVO);
	}

//	刪除圖片
	public void deleteMealsPic(Integer mealPidId) {
		if (repository.existsById(mealPidId))
			repository.deleteById(mealPidId);
	}

//	刪除多張圖片
	public boolean deleteMealPics(Integer mealPicId) {
		if (repository.existsById(mealPicId)) { // 檢查該id是否存在
			repository.deleteByMealsPicId(mealPicId);
			return true;
		} else {
			return false;
		}
	}

//	查詢單張圖片
	public MealsPicVO getOneMealsPic(Integer mealsId) {
		Optional<MealsPicVO> optional = repository.findById(mealsId);
		return optional.orElse(null);
	}

//	查詢所有圖片
	public List<MealsPicVO> getAll() {
		return repository.findAll();
	}

}
