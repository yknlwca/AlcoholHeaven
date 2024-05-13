package com.ssafy.alcohol.model.dao;

import java.util.List;

import com.ssafy.alcohol.model.dto.Friend;
import com.ssafy.alcohol.model.dto.SearchCondition;

public interface FriendDao {

	public List<Friend> search(SearchCondition condition);
	
	public Friend selectOne(int id);
	
	public int insertFriend(Friend friend);
	
	public int deleteFriend(int id);
	
	public int updateFriend(Friend friend);
	
}
