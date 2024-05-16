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
	public Alcohol readAlcohol(int id) {
		return alDao.selectOne(id);
	}

	@Override
	public boolean writeAlcohol(Alcohol alcohol) {
		return alDao.insertAlcohol(alcohol) == 1;
	}

	@Override
	public boolean removeAlcohol(int id) {
		return alDao.deleteAlcohol(id) == 1;
	}

	@Override
	public List<Alcohol> selectAlcohol(String region) {
		// TODO Auto-generated method stub
		return alDao.selectAlcohol(region);
	}

	@Override
	public List<Alcohol> selectAll() {
		return alDao.selectAll();
	}

	@Override
	public boolean modifyAlcohol(Alcohol alcohol) {
		return alDao.updateAlcohol(alcohol) == 1;
	}

	@Override
	public boolean likeUp(int id) {
		return alDao.likeUp(id) == 1;
	}

	@Override
	public boolean likeDown(int id) {
		return alDao.likeDown(id) == 1;
	}

}
