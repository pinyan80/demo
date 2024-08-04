package com.morning.meals.model;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mealsService")
public class MealsService {

	@Autowired
	MealsRepository repository;

	@Autowired
	private SessionFactory sessionFactory;

//	新增餐點
	public void addMeals(MealsVO mealsVO) {
		repository.save(mealsVO);
	}

//	修改餐點
	public void updateMeals(MealsVO mealsVO) {
		repository.save(mealsVO);
	}

//	查詢單個餐點
	public MealsVO getOneMeals(Integer mealsId) {
		Optional<MealsVO> optional = repository.findById(mealsId);
		return optional.orElse(null);
	}

//	查詢所有餐點
	public List<MealsVO> getAll() {
		return repository.findAll();
	}

//	拿取餐點個數
	public Integer getmealsnumber() {
		return repository.getmealsnumber();
	}

//	拿取餐點平均評價
	public Double getavgscore(Integer mealsId) {
		return repository.getavgscore(mealsId);
	}

//	更新餐點評分(meals表格)
	public void updateMealsScore(Double mealsTotalScore, Integer mealsId) {
		repository.updateMealsScore(mealsTotalScore, mealsId);
	}

}
