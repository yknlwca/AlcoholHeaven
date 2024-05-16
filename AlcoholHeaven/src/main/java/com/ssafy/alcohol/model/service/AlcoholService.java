package com.ssafy.alcohol.model.service;

import java.util.List;

import com.ssafy.alcohol.model.dto.Alcohol;
import com.ssafy.alcohol.model.dto.SearchCondition;

public interface AlcoholService {
	
	
	List<Alcohol> searchBoard(SearchCondition condition);

	Alcohol readAlcohol(int id);

	boolean writeAlcohol(Alcohol alcohol);

	boolean removeAlcohol(int id);

	boolean modifyAlcohol(Alcohol alcohol);

	List<Alcohol> selectAlcohol(String region);

	List<Alcohol> selectAll();
	
	boolean likeUp(int id);
	
	boolean likeDown(int id);
}
