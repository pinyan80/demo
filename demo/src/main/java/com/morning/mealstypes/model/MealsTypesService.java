package com.morning.mealstypes.model;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mealstypesService")
public class MealsTypesService {

	@Autowired
	MealsTypesRepository repository;

	@Autowired
	private SessionFactory sessionFactory;

//	Autowired會自動注入依賴，可以更加明確表示依賴關係
	public MealsTypesService(MealsTypesRepository repository) {
		this.repository = repository;
	}

//	新增
	public void addMealsTypes(MealsTypesVO mealstypesVO) {
		repository.save(mealstypesVO);
	}

//	修改
	public void updateMealsTypes(MealsTypesVO mealstypesVO) {
		repository.save(mealstypesVO);
	}

//	查詢單個餐點類別
	public MealsTypesVO getOneMealsTypes(Integer mealsTypesId) {
		Optional<MealsTypesVO> optional = repository.findById(mealsTypesId);
		return optional.orElse(null);
	}

//	查詢所有餐點類別
	public List<MealsTypesVO> getAll() {
		return repository.findAll();
	}

}
