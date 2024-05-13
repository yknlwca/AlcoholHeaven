package com.ssafy.alcohol.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.alcohol.model.dto.Friend;
import com.ssafy.alcohol.model.dto.SearchCondition;

@Service
public class FriendServiceImpl implements FriendService {

	private FriendService fService;

	@Autowired
	public FriendServiceImpl(FriendService fService) {
		this.fService = fService;
	}

	@Override
	public List<Friend> searchFriend(SearchCondition condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Friend readFriend(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeFriend(Friend friend) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeFriend(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyFriend(Friend friend) {
		// TODO Auto-generated method stub
		return false;
	}

}
