package com.ssafy.alcohol.model.service;

import java.util.List;

import com.ssafy.alcohol.model.dto.Alcohol;
import com.ssafy.alcohol.model.dto.SearchCondition;

public interface AlcoholService {
	
	public List<Alcohol> searchBoard(SearchCondition searchCondition);

	public Alcohol readAlcohol(String name);

	public boolean writeAlcohol(Alcohol alcohol);

	public boolean removeAlcohol(String name);

	public boolean modifyAlcohol(Alcohol alcohol);
}
