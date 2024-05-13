package com.ssafy.alcohol.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.alcohol.model.dto.Food;
import com.ssafy.alcohol.model.dto.SearchCondition;

@Service
public class FoodServiceImpl implements FoodService {

	private FoodService fService;
	
	@Autowired
	public FoodServiceImpl(FoodService fService) {
		this.fService = fService;
	}
	
	@Override
	public List<Food> searchFood(SearchCondition condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food readFood(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeFood(Food food) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeFood(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyFood(Food food) {
		// TODO Auto-generated method stub
		return false;
	}

}
