package com.ssafy.golffy.model.dto;

public class Subcmt {
	
	private int subcmt_id;
	private int cmt_id;
	private int user_pid;
	private String user_nick;
	private String subcmt_regdate;
	private String subcmt;
	private int subcmt_deleted;
	
	public Subcmt() {		
	}

	public Subcmt(int subcmt_id, int cmt_id, int user_pid, String user_nick, String subcmt_regdate, String subcmt,
			int subcmt_deleted) {
		super();
		this.subcmt_id = subcmt_id;
		this.cmt_id = cmt_id;
		this.user_pid = user_pid;
		this.user_nick = user_nick;
		this.subcmt_regdate = subcmt_regdate;
		this.subcmt = subcmt;
		this.subcmt_deleted = subcmt_deleted;
	}

	public int getSubcmt_id() {
		return subcmt_id;
	}

	public void setSubcmt_id(int subcmt_id) {
		this.subcmt_id = subcmt_id;
	}

	public int getCmt_id() {
		return cmt_id;
	}

	public void setCmt_id(int cmt_id) {
		this.cmt_id = cmt_id;
	}

	public int getUser_pid() {
		return user_pid;
	}

	public void setUser_pid(int user_pid) {
		this.user_pid = user_pid;
	}

	public String getUser_nick() {
		return user_nick;
	}

	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}

	public String getSubcmt_regdate() {
		return subcmt_regdate;
	}

	public void setSubcmt_regdate(String subcmt_regdate) {
		this.subcmt_regdate = subcmt_regdate;
	}

	public String getSubcmt() {
		return subcmt;
	}

	public void setSubcmt(String subcmt) {
		this.subcmt = subcmt;
	}

	public int getSubcmt_deleted() {
		return subcmt_deleted;
	}

	public void setSubcmt_deleted(int subcmt_deleted) {
		this.subcmt_deleted = subcmt_deleted;
	}

	@Override
	public String toString() {
		return "Subcmt [subcmt_id=" + subcmt_id + ", cmt_id=" + cmt_id + ", user_pid=" + user_pid + ", user_nick="
				+ user_nick + ", subcmt_regdate=" + subcmt_regdate + ", subcmt=" + subcmt + ", subcmt_deleted="
				+ subcmt_deleted + "]";
	}
	
	
}
