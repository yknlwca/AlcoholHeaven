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
	public List<Alcohol> searchBoard(SearchCondition condition) {
		return alDao.search(condition);
	}

	@Override
	public Alcohol readAlcohol(String name) {
		return alDao.selectOne(name);
	}

	@Override
	public boolean writeAlcohol(Alcohol alcohol) {
		return alDao.insertAlcohol(alcohol) == 1;
	}

	@Override
	public boolean removeAlcohol(String name) {
		return alDao.deleteAlcohol(name) == 1;
	}

	@Override
	public boolean modifyAlcohol(Alcohol alcohol) {
		return alDao.updateAlcohol(alcohol) == 1;
	}

	@Override
	public List<Alcohol> selectAlcohol(String region) {
		// TODO Auto-generated method stub
		return alDao.selectAlcohol(region);
	}

	
	
}
