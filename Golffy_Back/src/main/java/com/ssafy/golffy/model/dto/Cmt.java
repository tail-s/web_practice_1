package com.ssafy.golffy.model.dto;

public class Cmt {
	
	private int cmt_id;
	private int board_id;
	private int user_pid;
	private String user_nick;
	private String cmt_regdate;
	private String cmt;
	private int cmt_deleted;
	
	public Cmt() {				
	}

	public Cmt(int cmt_id, int board_id, int user_pid, String user_nick, String cmt_regdate, String cmt,
			int cmt_deleted) {
		super();
		this.cmt_id = cmt_id;
		this.board_id = board_id;
		this.user_pid = user_pid;
		this.user_nick = user_nick;
		this.cmt_regdate = cmt_regdate;
		this.cmt = cmt;
		this.cmt_deleted = cmt_deleted;
	}

	public int getCmt_id() {
		return cmt_id;
	}

	public void setCmt_id(int cmt_id) {
		this.cmt_id = cmt_id;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
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

	public String getCmt_regdate() {
		return cmt_regdate;
	}

	public void setCmt_regdate(String cmt_regdate) {
		this.cmt_regdate = cmt_regdate;
	}

	public String getCmt() {
		return cmt;
	}

	public void setCmt(String cmt) {
		this.cmt = cmt;
	}

	public int getCmt_deleted() {
		return cmt_deleted;
	}

	public void setCmt_deleted(int cmt_deleted) {
		this.cmt_deleted = cmt_deleted;
	}

	@Override
	public String toString() {
		return "Cmt [cmt_id=" + cmt_id + ", board_id=" + board_id + ", user_pid=" + user_pid + ", user_nick="
				+ user_nick + ", cmt_regdate=" + cmt_regdate + ", cmt=" + cmt + ", cmt_deleted=" + cmt_deleted + "]";
	}
	
	
}
