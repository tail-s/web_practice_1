package com.ssafy.golffy.model.dao;

import java.util.List;

import com.ssafy.golffy.model.dto.Board;

public interface BoardDao {
	
	public List<Board> selectAll();
	
	public Board selectOne(int id);
	
	public int insertBoard(Board board);
	
	public int deleteBoard(int id);
	
	public int updateBoard(Board board);
	
	public int updateViewCnt(int id);
	
	public int boardCnt(String str);
	
//	public int updateLike(int id);
//	
//	public int cntLike(int id);
	
//	검색 구현예정?
//	public List<Board> search();

}
