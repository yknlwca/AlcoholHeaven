package com.ssafy.alcohol.model.dao;

import java.util.List;

import com.ssafy.alcohol.model.dto.Review;

public interface ReviewDao {
	List<Review> selectReview(int id, int type);
	
	int write(Review review);
	
	int delete(int reviewId);
}
