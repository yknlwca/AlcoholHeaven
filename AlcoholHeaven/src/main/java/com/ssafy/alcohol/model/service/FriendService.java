package com.ssafy.alcohol.model.service;

import java.util.List;

import com.ssafy.alcohol.model.dto.Friend;
import com.ssafy.alcohol.model.dto.SearchCondition;

public interface FriendService {

	
	public List<Friend> searchRegion(String region);

	public List<Friend> searchSex(boolean sex);
	
	public List<Friend> searchFriend(SearchCondition condition);

	public Friend readFriend(int id);

	public boolean writeFriend(Friend friend);

	public boolean removeFriend(int id);

	public boolean modifyFriend(Friend friend);

}