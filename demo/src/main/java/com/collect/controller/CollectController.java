package com.collect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.collect.model.CollectService;
import com.collect.model.CollectVO;

@Controller
@Validated
@RequestMapping("/collect")
public class CollectController {
	
	@Autowired
	CollectService collectSvc;
	
	private CollectVO collectVO = new CollectVO();
	
	@PostMapping("/updateFavorite")
	public void updateFavorite(@RequestParam("mealsId") String mealsId) {
		
		//取得原始值
		int favorite = collectVO.getFavorite();
		
		//修改
		int updatefavorite = (favorite == 0) ? 1 : 0;
		
		//更新
		collectVO.setFavorite(updatefavorite);
		
		
	}

}
