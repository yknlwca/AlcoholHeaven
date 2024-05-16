package com.ssafy.alcohol.model.service;

import java.util.List;

import com.ssafy.alcohol.model.dto.Food;
import com.ssafy.alcohol.model.dto.SearchCondition;

public interface FoodService {

	public List<Food> searchFood(SearchCondition condition);
	
	public List<Food> searchRegion(String Region);
	
	public List<Food> searchMenu(String menu);

	public Food readFood(int id);

	public boolean writeFood(Food food);

	public boolean removeFood(int id);

	public boolean modifyFood(Food food);

	public List<Food> selectAll();
}
