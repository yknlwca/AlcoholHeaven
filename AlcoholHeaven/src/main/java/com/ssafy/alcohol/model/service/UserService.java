package com.ssafy.alcohol.model.service;

import java.util.List;

import com.ssafy.alcohol.model.dto.User;

public interface UserService {
	
	List<User> searchAll();;
	
	User readUser(String id);
	
	boolean writeUser(User user);
	
	boolean removeUser(String id);
	
	boolean modifyUser(User user);
	
}
