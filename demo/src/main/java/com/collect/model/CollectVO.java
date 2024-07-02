package com.collect.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.meals.model.MealsVO;
import com.mem.model.MemVO;

@Entity
@Table(name = "collect")
public class CollectVO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id",updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer	id;


	@ManyToOne
	@JoinColumn(name = "mem_no",referencedColumnName="mem_no")
	@NotEmpty(message="會員編號：請先登入")
	private MemVO memVO;

	@ManyToOne
	@JoinColumn(name = "meals_id",referencedColumnName="meals_id")
	@NotEmpty(message="餐點編號：請勿空白")
	private MealsVO mealsVO;


	@Column(name="favorite")
	private Integer favorite; // 收藏的標誌，true 1表示已收藏，false 0表示未收藏


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public MemVO getMemVO() {
		return memVO;
	}


	public void setMemVO(MemVO memVO) {
		this.memVO = memVO;
	}


	public MealsVO getMealsVO() {
		return mealsVO;
	}


	public void setMealsVO(MealsVO mealsVO) {
		this.mealsVO = mealsVO;
	}


	public Integer getFavorite() {
		return favorite;
	}


	public void setFavorite(Integer favorite) {
		this.favorite = favorite;
	}

}
