package com.collect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.collect.model.CollectService;
import com.collect.model.CollectVO;

@Controller
public class FavoriteController {
	
	@GetMapping("/addFavorite")
	public String addFavorite(ModelMap model) {
		
		//從資料庫拿商品
		CollectVO collectVO = new CollectVO();
		model.addAttribute("collectVO", collectVO);
		
		// 初始情況下，商品的收藏狀態
        System.out.println("Product is favorite? " + collectVO.getFavorite()); // false

        // 模擬收藏商品的操作，切換收藏狀態
        collectVO.toggleFavorite(); // 切換商品的收藏狀態
        System.out.println("Product is favorite? " + collectVO.getFavorite()); // true

        // 假設更新收藏狀態到數據庫中
//        CollectService.updateFavoriteStatus(collectVO);

        // 再次切換收藏狀態
        collectVO.toggleFavorite();
        System.out.println("Product is favorite? " + collectVO.getFavorite()); // false

       //返回菜單
        return "back-end/meals/listAllMeals";
	}
	

}
