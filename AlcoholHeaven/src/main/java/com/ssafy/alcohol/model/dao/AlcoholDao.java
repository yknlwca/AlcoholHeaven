package com.ssafy.alcohol.model.dao;

import java.util.List;

import com.ssafy.alcohol.model.dto.Alcohol;
import com.ssafy.alcohol.model.dto.SearchCondition;

public interface AlcoholDao {
	

	public List<Alcohol> search(SearchCondition conditon);
	
	public Alcohol selectOne(String name);
	
	public int insertAlcohol(Alcohol alcohol);
	
	public int deleteAlcohol(String name);
	
	public int updateAlcohol(Alcohol alcohol);

	public List<Alcohol> selectAlcohol(String region);
	
}
