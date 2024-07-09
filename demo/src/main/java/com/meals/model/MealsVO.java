package com.meals.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.mealstypes.model.MealsTypesVO;

@Entity
@Table(name = "meals")
public class MealsVO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer mealsId;
	private MealsTypesVO mealstypesVO;
	private String mealsName;
	private Integer mealsPrice;
	private String mealsDescription;
	private Integer mealsControl;
	private Double mealsTotalScore;
	private Integer mealsTotalPeople;

	// 必需有一個不傳參數建構子
	public MealsVO() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Pattern(regexp = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{1,20}$", message = "餐點名稱:只能是中英文數字，且長度必須小於20")
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
	@NotEmpty(message = "餐點描述不能空白")
	public String getMealsDescription() {
		return mealsDescription;
	}

	public void setMealsDescription(String mealsDescription) {
		this.mealsDescription = mealsDescription;
	}

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

}
