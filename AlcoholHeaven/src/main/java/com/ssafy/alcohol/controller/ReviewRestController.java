package com.ssafy.alcohol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.alcohol.model.dto.Review;
import com.ssafy.alcohol.model.service.ReviewServiceImpl;

@RestController
@RequestMapping("/api/review")
public class ReviewRestController {
	
	@Autowired
	private ReviewServiceImpl rService;
	
	@GetMapping("/{type}/{id}")
	public ResponseEntity<?> selectReview (@PathVariable("type") int type, @PathVariable("id") int id){
		List<Review> reviews = rService.selectReview(id, type);
		if (reviews == null || reviews.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}
	@PostMapping("")
	public ResponseEntity<?> write(@RequestBody Review review){
		int result = rService.write(review);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}	
	@DeleteMapping("/{reviewId}")
	public ResponseEntity<?> delete(@PathVariable("reviewId") int reviewId){
		int result = rService.delete(reviewId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
