package com.meals.model;

import java.util.List;
import java.util.Map;
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
	
	public void addMeals(MealsVO mealsVO) {
		repository.save(mealsVO);
	}
	
	public void updateMeals(MealsVO mealsVO) {
		repository.save(mealsVO);
	}
	
	public void deleteMeals(Integer mealsId) {
		if(repository.existsById(mealsId))
			repository.deleteByMealsId(mealsId);
	}
	
	public MealsVO getOneMeals(Integer mealsId) {
		Optional<MealsVO> optional = repository.findById(mealsId);
		return optional.orElse(null);
	}
	
	public List<MealsVO> getAll(){
		return repository.findAll();
	}
	
//	萬用複合查詢
//	public List<MealsVO> getAll(Map<String, String[]> map){
//		return HibernateUtil_CompositeQuery_Meals.getAll(map,sessionFactory.openSession());
//	}

}
