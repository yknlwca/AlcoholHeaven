package com.ssafy.alcohol.model.dao;

import java.util.List;

import com.ssafy.alcohol.model.dto.Friend;
import com.ssafy.alcohol.model.dto.SearchCondition;

public interface FriendDao {
	
//	<!-- 성별 / 지역  -->
	
	public List<Friend> searchRegion(String region);

	public List<Friend> searchSex(boolean sex);

	public List<Friend> search(SearchCondition condition);
	
	public Friend selectOne(int id);
	
	public int insertFriend(Friend friend);
	
	public int deleteFriend(int id);
	
	public int updateFriend(Friend friend);
	
}
