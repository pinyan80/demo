package com.morning.meals.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.morning.mealspic.model.MealsPicVO;
import com.morning.mealstypes.model.MealsTypesVO;
import com.morning.ordd.model.OrddVO;

@Entity
@Table(name = "meals")
public class MealsVO implements java.io.Serializable {  //可被序列化
	private static final long serialVersionUID = 1L;    //版本控制，不同版本之間的兼容性

	private Integer mealsId;
	private MealsTypesVO mealstypesVO;
	private String mealsName;
	private Integer mealsPrice;
	private String mealsDescription;
	private Integer mealsControl;
	private Double mealsTotalScore;
	private Integer mealsTotalPeople;
	private List<MealsPicVO> mealspics = new ArrayList<>();
	private List<OrddVO> orderDetails = new ArrayList<>();
//	用ArrayList避免出現空值例外，符合JavaBean規範應該有合理的初始值(會是空的集合不是null)

//	無參數建構子
	public MealsVO() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)   //主鍵自動生成
	@Column(name = "meals_id", updatable = false, insertable = false)
	public Integer getMealsId() {
		return mealsId;
	}

	public void setMealsId(Integer mealsId) {
		this.mealsId = mealsId;
	}

	@ManyToOne
	@JoinColumn(name = "meals_types_id")
	public MealsTypesVO getMealstypesVO() {
		return this.mealstypesVO;
	}

	public void setMealstypesVO(MealsTypesVO mealstypesVO) {
		this.mealstypesVO = mealstypesVO;
	}

	@Column(name = "meals_name")
	@NotEmpty(message = "餐點名稱不能空白")
	@Pattern(regexp = "^[(\\u4e00-\\u9fa5)(a-zA-Z0-9)]{1,20}$", message = "餐點名稱:只能是中英文數字，且長度必須小於20")  //正則表達式
	public String getMealsName() {
		return mealsName;
	}

	public void setMealsName(String mealsName) {
		this.mealsName = mealsName;
	}

	@Column(name = "meals_price")
	@NotNull(message = "餐點價格不能空白")
	@Min(value = 0, message = "餐點價格不能小於{value}")
	public Integer getMealsPrice() {
		return mealsPrice;
	}

	public void setMealsPrice(Integer mealsPrice) {
		this.mealsPrice = mealsPrice;
	}

	@Column(name = "meals_description")
	public String getMealsDescription() {
		return mealsDescription;
	}

	public void setMealsDescription(String mealsDescription) {
		this.mealsDescription = mealsDescription;
	}

//	餐點控制；1上架 0下架 2已售完
	@Column(name = "meals_control")
	public Integer getMealsControl() {
		return mealsControl;
	}

	public void setMealsControl(Integer mealsControl) {
		this.mealsControl = mealsControl;
	}

	@Column(name = "meals_total_score", updatable = false, insertable = false)
	public Double getMealsTotalScore() {
		return mealsTotalScore;
	}

	public void setMealsTotalScore(Double mealsTotalScore) {
		this.mealsTotalScore = mealsTotalScore;
	}

	@Column(name = "meals_total_people", updatable = false, insertable = false)
	public Integer getMealsTotalPeople() {
		return mealsTotalPeople;
	}

	public void setMealsTotalPeople(Integer mealsTotalPeople) {
		this.mealsTotalPeople = mealsTotalPeople;
	}

	@OneToMany(mappedBy = "mealsVO", cascade = CascadeType.ALL)
	public List<MealsPicVO> getMealspics() {
		return mealspics;
	}

	public void setMealspics(List<MealsPicVO> mealspics) {
		this.mealspics = mealspics;
	}

	@OneToMany(mappedBy = "mealsVO", cascade = CascadeType.ALL)
	public List<OrddVO> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrddVO> orderDetails) {
		this.orderDetails = orderDetails;
	}
}
