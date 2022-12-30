package com.ssafy.golffy.model.dto;

public class Board {
	
	private int board_id;
	private int user_pid;
	private String user_nick;
	private String board_title;
	private String board_content;
	private String board_regdate;
	private int board_viewcnt;
	private int board_like;
	private int board_deleted;
	
	public Board() {		
	}

	public Board(int board_id, int user_pid, String user_nick, String board_title, String board_content,
			String board_regdate, int board_viewcnt, int board_like, int board_deleted) {
		super();
		this.board_id = board_id;
		this.user_pid = user_pid;
		this.user_nick = user_nick;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_regdate = board_regdate;
		this.board_viewcnt = board_viewcnt;
		this.board_like = board_like;
		this.board_deleted = board_deleted;
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

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getBoard_regdate() {
		return board_regdate;
	}

	public void setBoard_regdate(String board_regdate) {
		this.board_regdate = board_regdate;
	}

	public int getBoard_viewcnt() {
		return board_viewcnt;
	}

	public void setBoard_viewcnt(int board_viewcnt) {
		this.board_viewcnt = board_viewcnt;
	}

	public int getBoard_like() {
		return board_like;
	}

	public void setBoard_like(int board_like) {
		this.board_like = board_like;
	}

	public int getBoard_deleted() {
		return board_deleted;
	}

	public void setBoard_deleted(int board_deleted) {
		this.board_deleted = board_deleted;
	}

	@Override
	public String toString() {
		return "Board [board_id=" + board_id + ", user_pid=" + user_pid + ", user_nick=" + user_nick + ", board_title="
				+ board_title + ", board_content=" + board_content + ", board_regdate=" + board_regdate
				+ ", board_viewcnt=" + board_viewcnt + ", board_like=" + board_like + ", board_deleted=" + board_deleted
				+ "]";
	}
	
	
}
