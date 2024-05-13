package com.ssafy.alcohol.model.dao;

import java.util.List;

import com.ssafy.alcohol.model.dto.Food;
import com.ssafy.alcohol.model.dto.SearchCondition;

public interface FoodDao {
	
	public List<Food> search(SearchCondition condition);
	
	public Food selectOne(int id);
	
	public int insertFood(Food food);
	
	public int deleteFood(int id);
	
	public int updateFood(Food food);
}
