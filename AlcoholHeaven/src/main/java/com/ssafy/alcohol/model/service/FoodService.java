package com.ssafy.alcohol.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.alcohol.model.dto.Food;
import com.ssafy.alcohol.model.dto.SearchCondition;

public interface FoodService {

	public List<Food> searchFood(SearchCondition condition);

	public Food readFood(int id);

	public boolean writeFood(Food food);

	public boolean removeFood(int id);

	public boolean modifyFood(Food food);

	public List<Food> selectAll();
	
	public boolean likeUp(int id);
	
	public boolean likeDown(int id);
	
	public void fileFood(MultipartFile multipartFile, Food food);
}
