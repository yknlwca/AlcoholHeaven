package com.ssafy.alcohol.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.alcohol.model.dao.BoardLikeDao;
import com.ssafy.alcohol.model.dto.boardLike;
@Service
public class BoardLikeServiceImpl implements BoardLikeService{
	@Autowired
	private BoardLikeDao bDao;
	@Override
	public int insert(boardLike boardLike) {
		// TODO Auto-generated method stub
		return bDao.insert(boardLike);
	}

	@Override
	public int delete(boardLike boardLike) {
		// TODO Auto-generated method stub
		return bDao.delete(boardLike);
	}

	@Override
	public int likeCnt(int type, int boardId) {
		// TODO Auto-generated method stub
		return bDao.likeCnt(type, boardId);
	}

	@Override
	public boardLike select(boardLike boardLike) {
		// TODO Auto-generated method stub
		return bDao.select(boardLike);
	}

	@Override
	public boardLike selectByType(int type) {
		// TODO Auto-generated method stub
		return bDao.selectByType(type);
	}


}
