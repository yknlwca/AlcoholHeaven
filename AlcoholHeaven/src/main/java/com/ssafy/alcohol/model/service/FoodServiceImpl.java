package com.ssafy.alcohol.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.alcohol.model.dao.FoodDao;
import com.ssafy.alcohol.model.dto.Food;
import com.ssafy.alcohol.model.dto.SearchCondition;

@Service
public class FoodServiceImpl implements FoodService {

	private FoodDao fDao;
	
	@Autowired
	public FoodServiceImpl(FoodDao fDao) {
		this.fDao = fDao;
	}
	
	@Override
	public List<Food> searchFood(SearchCondition condition) {
		return fDao.search(condition);
	}

	@Override
	public Food readFood(int id) {
		return fDao.selectOne(id);
	}

	@Override
	public boolean writeFood(Food food) {
		return fDao.insertFood(food) == 1;
	}

	@Override
	public boolean removeFood(int id) {
		return fDao.deleteFood(id) == 1;
	}

	@Override
	public boolean modifyFood(Food food) {
		return fDao.updateFood(food) == 1;
	}

	@Override
	public List<Food> searchRegion(String Region) {
		return fDao.searchRegion(Region);
	}

	@Override
	public List<Food> searchMenu(String menu) {
		return fDao.searchMenu(menu);
	}

}
