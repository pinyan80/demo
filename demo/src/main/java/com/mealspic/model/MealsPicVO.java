package com.mealspic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.meals.model.MealsVO;

@Entity
@Table(name = "meal_picture")
public class MealsPicVO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer mealPicId;
	private byte[] mealPic;
	private String mealPicInfo;
	private MealsVO mealsVO;
	
	public MealsPicVO() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "meal_pic_id", updatable = false ,insertable = false)
	public Integer getMealPicId() {
		return mealPicId;
	}

	public void setMealPicId(Integer mealPicId) {
		this.mealPicId = mealPicId;
	}

	@Column(name="meal_pic")
	public byte[] getMealPic() {
		return mealPic;
	}

	public void setMealPic(byte[] mealPic) {
		this.mealPic = mealPic;
	}

	@Column(name="meal_pic_info")
	@NotEmpty(message="餐點圖片名稱不能空白")
	@Pattern(regexp="^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{1,20}$", message="餐點名稱:只能是中英文數字，且長度必須小於20")
	public String getMealPicInfo() {
		return mealPicInfo;
	}

	public void setMealPicInfo(String mealPicInfo) {
		this.mealPicInfo = mealPicInfo;
	}

	@ManyToOne
	@JoinColumn(name="meals_id")
	public MealsVO getMealsVO() {
		return mealsVO;
	}

	public void setMealsVO(MealsVO mealsVO) {
		this.mealsVO = mealsVO;
	}
	
	

}
