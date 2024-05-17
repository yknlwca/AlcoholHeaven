package com.ssafy.alcohol.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.alcohol.model.dao.UserDao;
import com.ssafy.alcohol.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDao uDao;
	
	@Autowired
	public UserServiceImpl(UserDao uDao) {
		this.uDao = uDao;
	}

	@Override
	public List<User> searchAll() {
		return uDao.selectAll();
	}

	@Override
	public User readUser(String id) {
		return uDao.selectOne(id);
	}

	@Override
	public boolean writeUser(User user) {
		return uDao.insertUser(user) == 1;
	}

	@Override
	public boolean removeUser(String id) {
		return uDao.deleteUser(id) == 1;
	}

	@Override
	public boolean modifyUser(User user) {
		return uDao.updateUser(user) == 1;
	}
}
