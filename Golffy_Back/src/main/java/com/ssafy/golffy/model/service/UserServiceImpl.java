package com.ssafy.golffy.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.golffy.model.dao.UserDao;
import com.ssafy.golffy.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getUser(String user_id) {
		return userDao.selectUser(user_id);
	}

	@Override
	public boolean createUser(User user) {
		return userDao.insertUser(user) == 1;
	}

	@Override
	public boolean removeUser(int id) {
		return userDao.deleteUser(id) == 1;
	}

	@Override
	public boolean modifyUser(User user) {
		return userDao.updateUser(user) == 1;
	}

	@Override
	public boolean checker(String str) {
		return userDao.idCheck(str) == 0;
	}

	@Override
	public boolean loginChecker(String id, String pw) {
		return userDao.loginCheck(id, pw) == 1;
	}

}
