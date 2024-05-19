package com.ssafy.alcohol.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.alcohol.model.dto.Alcohol;
import com.ssafy.alcohol.model.dto.Food;
import com.ssafy.alcohol.model.dto.Friend;
import com.ssafy.alcohol.model.dto.SearchCondition;

public interface FriendService {



	public List<Friend> selectAll();
	
	public List<Friend> searchFriend(SearchCondition condition);

	public Friend readFriend(int id);

	public boolean writeFriend(Friend friend);

	public boolean removeFriend(int id);

	public boolean modifyFriend(Friend friend);

	public boolean likeUp(int id);
	
	public boolean likeDown(int id);

	public void fileFriend(MultipartFile multipartFile,Friend friend);
	
	public void updateFriend(MultipartFile multipartFile, Friend friend);
}
