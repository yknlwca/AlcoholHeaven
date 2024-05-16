package com.ssafy.alcohol.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.alcohol.model.dao.ReviewDao;
import com.ssafy.alcohol.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao rDao;
	
	@Override
	public List<Review> selectReview(int id, int type) {
		// TODO Auto-generated method stub
		return rDao.selectReview(id, type);
	}

	@Override
	public int write(Review review) {
		// TODO Auto-generated method stub
		return rDao.write(review);
	}

	@Override
	public int delete(int reviewId) {
		// TODO Auto-generated method stub
		return rDao.delete(reviewId);
	}

}
