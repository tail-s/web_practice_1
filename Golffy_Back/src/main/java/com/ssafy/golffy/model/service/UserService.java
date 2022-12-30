package com.ssafy.golffy.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.golffy.model.dto.User;

@Service
public interface UserService {
	
	public User getUser(String user_id);
	
	public boolean createUser(User user);
	
	public boolean removeUser(int id);
	
	public boolean modifyUser(User user);
	
	public boolean checker(String str);
	
	public boolean loginChecker(String id, String pw);

}
