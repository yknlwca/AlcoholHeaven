package com.ssafy.alcohol.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.alcohol.model.dao.FriendDao;
import com.ssafy.alcohol.model.dto.Friend;
import com.ssafy.alcohol.model.dto.SearchCondition;

@Service
public class FriendServiceImpl implements FriendService {

	private FriendDao fDao;
	
	@Autowired
	public FriendServiceImpl(FriendDao fDao) {
		this.fDao = fDao;
	}

	@Override
	public List<Friend> searchFriend(SearchCondition condition) {
		return fDao.search(condition);
	}

	@Override
	public Friend readFriend(int id) {
		return fDao.selectOne(id);
	}

	@Override
	public boolean writeFriend(Friend friend) {
		return fDao.insertFriend(friend) == 1;
	}

	@Override
	public boolean removeFriend(int id) {
		return fDao.deleteFriend(id) == 1;
	}

	@Override
	public boolean modifyFriend(Friend friend) {
		return fDao.updateFriend(friend) == 1;
	}

}
