package com.ssafy.alcohol.model.service;

import java.util.List;

import com.ssafy.alcohol.model.dto.Review;

public interface ReviewService {
	
	List<Review> selectReview(int id, int type);
	
	int write(Review review);
	
	int delete(int reviewId);

}
