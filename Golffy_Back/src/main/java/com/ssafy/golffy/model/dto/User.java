package com.ssafy.golffy.model.dto;

public class User {
	
	private int user_pid;
	private String user_id;
	private String user_pw;
	private String user_nick;
	private int user_deleted;
	
	public User() {
	}
	
	public User(int user_pid, String user_id, String user_pw, String user_nick, int user_deleted) {
		this.user_pid = user_pid;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_nick = user_nick;
		this.user_deleted = user_deleted;
	}

	public int getUser_pid() {
		return user_pid;
	}

	public void setUser_pid(int user_pid) {
		this.user_pid = user_pid;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_nick() {
		return user_nick;
	}

	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}

	@Override
	public String toString() {
		return "User [user_pid=" + user_pid + ", user_id=" + user_id + ", user_pw=" + user_pw + ", user_nick="
				+ user_nick + "]";
	}

}
