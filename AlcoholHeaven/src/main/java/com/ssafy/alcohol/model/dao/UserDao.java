package com.ssafy.alcohol.model.dao;

import java.util.List;

import com.ssafy.alcohol.model.dto.User;

public interface UserDao {
	public List<User> selectAll();

	public int insertUser(User user);

	public User selectOne(String id);

	public int deleteUser(String id);

	public int updateUser(User user);
}
