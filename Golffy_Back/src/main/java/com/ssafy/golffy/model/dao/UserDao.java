package com.ssafy.golffy.model.dao;

import org.apache.ibatis.annotations.Param;

import com.ssafy.golffy.model.dto.User;

public interface UserDao {
	
	public int insertUser(User user);
	
	public int deleteUser(int id);
	
	public int updateUser(User user);
	
	public User selectUser(String user_id);
	
	public int idCheck(String str);
	
	public int loginCheck(@Param("user_id") String id, @Param("user_pw")String pw);

}
