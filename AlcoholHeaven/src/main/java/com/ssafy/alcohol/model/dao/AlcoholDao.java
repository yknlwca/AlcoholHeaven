package com.ssafy.alcohol.model.dao;

import java.util.List;

import com.ssafy.alcohol.model.dto.Alcohol;
import com.ssafy.alcohol.model.dto.SearchCondition;

public interface AlcoholDao {
	

	List<Alcohol> search(SearchCondition conditon);
	
	Alcohol selectOne(int id);
	
	int insertAlcohol(Alcohol alcohol);
	
	int deleteAlcohol(int id);
	
	int updateAlcohol(Alcohol alcohol);

	List<Alcohol> selectAlcohol(String region);

	List<Alcohol> selectAll();
	
	int likeUp(int id);
	
	int likeDown(int id);
	
}
