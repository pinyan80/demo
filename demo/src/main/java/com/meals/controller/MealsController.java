package com.meals.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.meals.model.MealsService;
import com.meals.model.MealsVO;
import com.mealstypes.model.MealsTypesService;
import com.mealstypes.model.MealsTypesVO;

@Controller
@RequestMapping("/meals")
public class MealsController {

	@Autowired
	MealsService mealsSvc;

	@Autowired
	MealsTypesService mealstypesSvc;

	@GetMapping("addMeals")
	public String addMeals(ModelMap model) {
		MealsVO mealsVO = new MealsVO();
		model.addAttribute("mealsVO", mealsVO);
		return "back-end/meals/addMeals";
	}

	// 新增
	@PostMapping("insert")
	public String insert(@Valid MealsVO mealsVO, BindingResult result, ModelMap model) throws IOException {

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/

		/*************************** 2.開始新增資料 *****************************************/

		mealsSvc.addMeals(mealsVO);
		/*************************** 3.新增完成,準備轉交(Send the Success view) **************/
		List<MealsVO> list = mealsSvc.getAll();
		model.addAttribute("mealsListData", list);
		model.addAttribute("success", "- (新增成功)");
		return "redirect:/meals/listAllMeals";
	}

	// 修改
	@PostMapping("getOne_For_Update")
	public String getOne_For_Update(@RequestParam("mealsId") String mealsId, ModelMap model) {
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		/*************************** 2.開始查詢資料 *****************************************/

		MealsVO mealsVO = mealsSvc.getOneMeals(Integer.valueOf(mealsId));

		/*************************** 3.查詢完成,準備轉交(Send the Success view) **************/
		model.addAttribute("mealsVO", mealsVO);
		return "back-end/meals/update_meals_input";
	}

	@PostMapping("update")
	public String update(@Valid MealsVO mealsVO, BindingResult result, ModelMap model) throws IOException {
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/

		/*************************** 2.開始修改資料 *****************************************/
		mealsSvc.updateMeals(mealsVO);

		/*************************** 3.修改完成,準備轉交(Send the Success view) **************/
		model.addAttribute("success", "- (修改成功)");
		mealsVO = mealsSvc.getOneMeals(Integer.valueOf(mealsVO.getMealsId()));
		model.addAttribute("mealsVO", mealsVO);
		return "back-end/meals/listOneMeals";
	}

	// 刪除
	@PostMapping("delete")
	public String delete(@RequestParam("meals_id") String mealsId, ModelMap model) {
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		/*************************** 2.開始刪除資料 *****************************************/

		mealsSvc.deleteMeals(Integer.valueOf(mealsId));
		/*************************** 3.刪除完成,準備轉交(Send the Success view) **************/
		List<MealsVO> list = mealsSvc.getAll();
		model.addAttribute("empListData", list);
		model.addAttribute("success", "- (刪除成功)");
		return "back-end/meals/listAllEmp"; // 刪除完成後轉交listAllEmp.html
	}

	@ModelAttribute("mealstypesListData")
	protected List<MealsTypesVO> referenceListData() {
		List<MealsTypesVO> list = mealstypesSvc.getAll();
		return list;
	}

	// 去除BindingResult中某個欄位的FieldError紀錄
	public BindingResult removeFieldError(MealsVO mealsVO, BindingResult result, String removedFieldname) {
		List<FieldError> errorsListToKeep = result.getFieldErrors().stream()
				.filter(fieldname -> !fieldname.getField().equals(removedFieldname)).collect(Collectors.toList());
		result = new BeanPropertyBindingResult(mealsVO, "mealsVO");
		for (FieldError fieldError : errorsListToKeep) {
			result.addError(fieldError);
		}
		return result;
	}
	
//	public String listAllMeals(HttpServletRequest req, Model model) {
//		Map<String, String[]> map = req.getParameterMap();
//		List<MealsVO> list = mealsSvc.getAll(map);
//		model.addAttribute("mealstypesListData", list); // for listAllEmp.html 第85行用
//		return "back-end/meals/listAllEmp";
//	}

}
