package com;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.collect.model.CollectService;
import com.meals.model.MealsService;
import com.meals.model.MealsVO;
import com.mealspic.model.MealsPicService;
import com.mealspic.model.MealsPicVO;
import com.mealstypes.model.MealsTypesService;
import com.mealstypes.model.MealsTypesVO;



//@PropertySource("classpath:application.properties") // 於https://start.spring.io建立Spring Boot專案時, application.properties文件預設已經放在我們的src/main/resources 目錄中，它會被自動檢測到
@Controller
public class IndexController_inSpringBoot {
	
	// @Autowired (●自動裝配)(Spring ORM 課程)
	
	@Autowired
	MealsService mealsSvc;
	
	@Autowired
	MealsTypesService mealstypesSvc;
	
	@Autowired
	CollectService collectSvc;
	
	@Autowired
	MealsPicService mealspicSvc;
	
    // inject(注入資料) via application.properties
    @Value("${welcome.message}")
    private String message;
	
    
    
    private List<String> myList = Arrays.asList("Spring Boot Quickstart 官網 : https://start.spring.io", "IDE 開發工具", "直接使用(匯入)官方的 Maven Spring-Boot-demo Project + pom.xml", "直接使用官方現成的 @SpringBootApplication + SpringBootServletInitializer 組態檔", "依賴注入(DI) HikariDataSource (官方建議的連線池)", "Thymeleaf", "Java WebApp (<font color=red>快速完成 Spring Boot Web MVC</font>)");
//    @GetMapping("/")
    public String index(Model model) {
    	model.addAttribute("message", message);
        model.addAttribute("myList", myList);
        return "index"; //view
    }
    
    // http://......../hello?name=peter1
    @GetMapping("/hello")
    public String indexWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("message", name);
        return "index"; //view
    }
    
  
    //=========== meals ===================   
    @GetMapping("/meals/select_page")
	public String select_page(Model model) {
		return "back-end/meals/select_page";
	}
    
    @GetMapping("/meals/listAllMeals")
	public String listAllMeals(Model model) {
		return "back-end/meals/listAllMeals";
	}
    
    @ModelAttribute("mealsListData")  // for select_page.html 第97 109行用 // for listAllEmp.html 第85行用
	protected List<MealsVO> referenceListData_meals(Model model) {
		
    	List<MealsVO> list = mealsSvc.getAll();
		return list;
	}
    
	
	//============ mealstypes =======================
	@GetMapping("/mealstypes/select_page")
	public String select_page2(Model model) {
		return "back-end/mealstypes/select_page";
	}
    
    @GetMapping("/mealstypes/listAllMealsTypes")
	public String listAllMealsTypes(Model model) {
		return "back-end/mealstypes/listAllMealsTypes";
	}
    
    @ModelAttribute("mealstypesListData")  // for select_page.html 第97 109行用 // for listAllEmp.html 第85行用
	protected List<MealsTypesVO> referenceListData_mealstypes(Model model) {
		
    	List<MealsTypesVO> list = mealstypesSvc.getAll();
		return list;
	}
    
  //============ mealspic =======================
  	@GetMapping("/mealspic/select_page")
  	public String select_page3(Model model) {
  		return "back-end/mealspic/select_page";
  	}
      
    @GetMapping("/mealspic/listAllMealsPic")
  	public String listAllMealsPic(Model model) {
  		return "back-end/mealspic/listAllMealsPic";
  	}
      
    @ModelAttribute("mealspicListData")  // for select_page.html 第97 109行用 // for listAllEmp.html 第85行用
  	protected List<MealsPicVO> referenceListData_mealspic(Model model) {
  		
      	List<MealsPicVO> list = mealspicSvc.getAll();
  		return list;
  	}
    
    //======== menu =============
    @GetMapping("/function/textmenu")
    public String menu(Model model) {
    	return "back-end/function/textmenu";
    }

}