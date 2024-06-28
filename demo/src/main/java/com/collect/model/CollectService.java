package com.collect.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meals.model.MealsRepository;
import com.mealspic.model.MealsPicRepository;

@Service("collectService")
public class CollectService {

	@Autowired
	private CollectRepository collectrepository;

//	//要加入會員編號
//	@Autowired
//	private MemberRepository memberrepository;

	@Autowired
	private MealsRepository mealsrepository;

	@Autowired
	private MealsPicRepository mealspicrepository;

	public static int FAVORITE_ADD_OK = 1; // 成功加入我的最愛
	public static int FAVORITE_DEL_OK = 2; // 已從我的最愛移除
	public static int FAVORITE_LOGIN = 3; // 需要登入
	public static int FAVORITE_ERROR = 4; // 發生未知的錯誤

//	public int updateItem(final Favorite favorite) {
//		final Member member = memberRepository.findById(reqDto.getMemberId()).orElse(null);
//		if (member == null) {
//			return FAVORITE_LOGIN;
//		}
//
//		final Trip trip = tripRepository.findById(reqDto.getTripId()).orElse(null);
//
//		if (trip == null) {
//			return FAVORITE_ERROR;
//		}
//		// 如果是已經收藏的 就取消收藏
//		final boolean isFavorite = tripFavoriteRepository.existsById(new PrimaryKey2(reqDto.getMemberId(), trip));
//		if (isFavorite) {
//			tripFavoriteRepository.deleteQuery(reqDto.getMemberId(), reqDto.getTripId());
//			return FAVORITE_DEL_OK;
//		}
//
//		final TripFavorite favorite = new TripFavorite();
//		favorite.setKey(new PrimaryKey2(reqDto.getMemberId(), trip));
//		favorite.setAddTime(Timestamp.from(Instant.now()));
//		// System.out.println("加入收藏");
//		tripFavoriteRepository.save(favorite);
//
//		return FAVORITE_ADD_OK;
//
//	}
//
//	// 判斷是不是已經收藏的
//	public boolean checkIfExists(final FavoriteReqDto reqDto) {
//		final Trip trip = tripRepository.findById(reqDto.getTripId()).orElse(null);
//		final boolean isFavorite = tripFavoriteRepository.existsById(new PrimaryKey2(reqDto.getMemberId(), trip));
//		// System.out.println(isFavorite);
//		return isFavorite;
//	}
//
//	public DetailDto getAllTripItem(final int memberId, final int tripId) {
//		final Trip trip = tripRepository.findById(tripId).orElse(null);
//
//		if (trip == null) {
//			return null;
//		}
//		final DetailDto detailDto = new DetailDto(trip);
//		// 我的最愛
//		detailDto.setFavorite(tripFavoriteRepository.existsById(new PrimaryKey2(memberId, trip)));
//		return detailDto;


}
