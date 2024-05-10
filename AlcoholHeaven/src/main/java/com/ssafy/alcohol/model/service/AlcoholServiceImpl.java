package com.ssafy.alcohol.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.alcohol.model.dao.AlcoholDao;
import com.ssafy.alcohol.model.dto.Alcohol;
import com.ssafy.alcohol.model.dto.SearchCondition;

@Service
public class AlcoholServiceImpl implements AlcoholService {

	private final AlcoholDao alDao;

	@Autowired
	public AlcoholServiceImpl(AlcoholDao alDao) {
		this.alDao = alDao;
	}

	@Override
	public List<Alcohol> searchBoard(SearchCondition searchCondition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alcohol readAlcohol(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeAlcohol(Alcohol alcohol) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAlcohol(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyAlcohol(Alcohol alcohol) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
