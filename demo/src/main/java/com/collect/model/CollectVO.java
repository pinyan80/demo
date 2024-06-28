package com.collect.model;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.collect.model.CollectVO.CompositeDetail;

@Entity
@Table(name = "collect")
@IdClass(CompositeDetail.class)
public class CollectVO {

	@Id
	@Column(name = "mem_no")
	@ManyToOne
	private Integer memNo;

	@Id
	@Column(name = "meals_id")
	private Integer mealsId;

	@Column(name = "col_time")
	private LocalDateTime colTime;

	private Boolean favorite = false; // 收藏的標誌，true 表示已收藏，false 表示未收藏

// 收藏
	public Boolean getFavorite() {
		return favorite;
	}

	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}

//商藏商品的方法
	public void toggleFavorite() {
		favorite = !favorite;
	}

//無參數建構子
	public CollectVO() {

	}

	public CompositeDetail getCompositeKey() {
		return new CompositeDetail(memNo, mealsId);
	}

	public Integer getMemNo() {
		return memNo;
	}

	public void setMemNo(Integer memNo) {
		this.memNo = memNo;
	}

	public Integer getMealsId() {
		return mealsId;
	}

	public void setMealsId(Integer mealsId) {
		this.mealsId = mealsId;
	}

	public LocalDateTime getColTime() {
		return colTime;
	}

	public void setColTime(LocalDateTime colTime) {
		this.colTime = colTime;
	}

	static class CompositeDetail implements java.io.Serializable {
		private static final long serialVersionUID = 1L;

		private Integer memNo;
		private Integer mealsId;

		// 一定要有無參數建構子
		public CompositeDetail() {
			super();
		}

		public CompositeDetail(Integer memNO, Integer mealsId) {
			super();
			this.memNo = memNO;
			this.mealsId = mealsId;
		}

		public Integer getMemNo() {
			return memNo;
		}

		public void setMemNo(Integer memNo) {
			this.memNo = memNo;
		}

		public Integer getMealsId() {
			return mealsId;
		}

		public void setMealsId(Integer mealsId) {
			this.mealsId = mealsId;
		}

		// 一定要 override 此類別的 hashCode() 與 equals() 方法！
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((memNo == null) ? 0 : memNo.hashCode());
			result = prime * result + ((mealsId == null) ? 0 : mealsId.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;

			if (obj != null && getClass() == obj.getClass()) {
				CompositeDetail compositeKey = (CompositeDetail) obj;
				if (memNo.equals(compositeKey.memNo) && mealsId.equals(compositeKey.mealsId)) {
					return true;
				}
			}

			return false;
		}

	}

}
