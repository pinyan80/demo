package com;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.collect.model.CollectVO;
import com.meals.model.MealsRepository;
import com.meals.model.MealsVO;
import com.mealstypes.model.MealsTypesVO;

import hibernate.util.CompositeQuery.HibernateUtil_CompositeQuery_morningcode;


@SpringBootApplication
public class Test_Application_CommandLineRunner implements CommandLineRunner {
    
	@Autowired
	MealsRepository repository ;
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public static void main(String[] args) {
        SpringApplication.run(Test_Application_CommandLineRunner.class);
    }

    @Override
    public void run(String...args) throws Exception {

    	//● 新增
    	CollectVO collectVO= new CollectVO();
    	collectVO.setId(1);
    	
    	
    	
//		MealsTypesVO mealstypesVO = new MealsTypesVO(); // 類別POJO
//		mealstypesVO.setMealsTypesId(1);

//		MealsVO mealsVO1 = new MealsVO();
//		mealsVO1.setMealsName("草莓吐司");
//		mealsVO1.setMealsPrice(new Integer(25));
//		mealsVO1.setMealsDescription("草莓醬");
//		mealsVO1.setMealsControl(new Integer(1));
//		mealsVO1.setMealstypesVO(mealstypesVO);
//		repository.save(mealsVO1);

		//● 修改
//		MealsVO mealsVO2 = new MealsVO();
//		mealsVO2.setMealsId(1);
//		mealsVO2.setMealsName("草莓吐司");
//		mealsVO2.setMealsPrice(new Integer(25));
//		mealsVO2.setMealsDescription("草莓醬");
//		mealsVO2.setMealsControl(new Integer(0));
//		mealsVO2.setMealstypesVO(mealstypesVO);
//		repository.save(mealsVO2);
		
		//● 刪除   //●●● --> EmployeeRepository.java 內自訂的刪除方法
//		repository.deleteByMealsId(1);
		
		//● 刪除   //XXX --> Repository內建的刪除方法目前無法使用，因為有@ManyToOne
//		System.out.println("--------------------------------");
//		repository.deleteById(2);      
//		System.out.println("--------------------------------");

    	//● 查詢-findByPrimaryKey (多方emp2.hbm.xml必須設為lazy="false")(優!)
//    	Optional<MealsVO> optional = repository.findById(3);
//		MealsVO mealsVO3 = optional.get();
//		System.out.print(mealsVO3.getMealsId() + ",");
//		System.out.print(mealsVO3.getMealsName() + ",");
//		System.out.print(mealsVO3.getMealsPrice() + ",");
//		System.out.print(mealsVO3.getMealsDescription() + ",");
//		System.out.print(mealsVO3.getMealsControl() + ",");
//		System.out.print(mealsVO3.getMealsTotalScore() + ",");
//		System.out.print(mealsVO3.getMealsTotalPeople() + ",");
//		// 注意以下三行的寫法 (優!)
//		System.out.print(mealsVO3.getMealstypesVO().getMealsTypesId() + ",");
//		System.out.print(mealsVO3.getMealstypesVO().getMealsTypesName() + ",");
//		System.out.println("\n---------------------");
      
    	
		//● 查詢-getAll (多方emp2.hbm.xml必須設為lazy="false")(優!)
//    	List<MealsVO> list = repository.findAll();
//		for (MealsVO meals : list) {
//			System.out.print(meals.getMealsId() + ",");
//			System.out.print(meals.getMealsName() + ",");
//			System.out.print(meals.getMealsPrice() + ",");
//			System.out.print(meals.getMealsDescription() + ",");
//			System.out.print(meals.getMealsControl() + ",");
//			System.out.print(meals.getMealsTotalScore() + ",");
//			System.out.print(meals.getMealsTotalPeople() + ",");
//			// 注意以下三行的寫法 (優!)
//			System.out.print(meals.getMealstypesVO().getMealsTypesId() + ",");
//			System.out.print(meals.getMealstypesVO().getMealsTypesName() + ",");
//			System.out.println();
//		}


		//● 複合查詢-getAll(map) 配合 req.getParameterMap()方法 回傳 java.util.Map<java.lang.String,java.lang.String[]> 之測試
//		Map<String, String[]> map = new TreeMap<String, String[]>();
//		map.put("mealsId", new String[] { "1" });
//		map.put("mealsTypesId", new String[] { "2" });
//		map.put("mealsName", new String[] { "牛肉漢堡" });
//		map.put("mealsPrice", new String[] { "60" });
//		map.put("mealsDescription", new String[] { "牛肉" });
//		map.put("mealsControl", new String[] { "0" });
//
//		
//		List<MealsVO> list2 = HibernateUtil_CompositeQuery_morningcode.getAllC(map,sessionFactory.openSession());
//		for (MealsVO meals : list2) {
//			System.out.print(meals.getMealsId() + ",");
//			System.out.print(meals.getMealsName() + ",");
//			System.out.print(meals.getMealsPrice() + ",");
//			System.out.print(meals.getMealsDescription() + ",");
//			System.out.print(meals.getMealsControl() + ",");
//			System.out.print(meals.getMealsTotalScore() + ",");
//			System.out.print(meals.getMealsTotalPeople() + ",");
//			// 注意以下三行的寫法 (優!)
//			System.out.print(meals.getMealstypesVO().getMealsTypesId() + ",");
//			System.out.print(meals.getMealstypesVO().getMealsTypesName() + ",");
//			System.out.println();
//		}
		

		//● (自訂)條件查詢
//		List<MealsVO> list3 = repository.findByOthers(7001,"%K%",java.sql.Date.valueOf("1981-11-17"));
//		if(!list3.isEmpty()) {
//			for (EmpVO aEmp : list3) {
//				System.out.print(aEmp.getEmpno() + ",");
//				System.out.print(aEmp.getEname() + ",");
//				System.out.print(aEmp.getJob() + ",");
//				System.out.print(aEmp.getHiredate() + ",");
//				System.out.print(aEmp.getSal() + ",");
//				System.out.print(aEmp.getComm() + ",");
//				// 注意以下三行的寫法 (優!)
//				System.out.print(aEmp.getDeptVO().getDeptno() + ",");
//				System.out.print(aEmp.getDeptVO().getDname() + ",");
//				System.out.print(aEmp.getDeptVO().getLoc());
//				System.out.println();
//			}
//		} else System.out.print("查無資料\n");
//		System.out.println("--------------------------------");
//
    }
}
