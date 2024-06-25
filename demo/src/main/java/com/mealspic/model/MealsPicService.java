package com.mealspic.model;

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
	
	
	public void addMealsPic(MealsPicVO mealspicVO) {
		repository.save(mealspicVO);
	}
	
	public void updateMealsPic(MealsPicVO mealspicVO) {
		repository.save(mealspicVO);
	}
	
	public void deleteMealsPic(Integer mealsPicId) {
		if(repository.existsById(mealsPicId))
			repository.deleteById(mealsPicId);
	}
	
	public MealsPicVO getOneMealsPic(Integer mealsPicId) {
		Optional<MealsPicVO> optional = repository.findById(mealsPicId);
		return optional.orElse(null);
	}
	
	public List<MealsPicVO> getAll(){
		return repository.findAll();
	}

}
