package com.ssafy.golffy.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.golffy.model.dto.Board;

@Service
public interface BoardService {
	
	public List<Board> getBoards();
	
	public Board getBoard(int id);
	
	public boolean createBoard(Board board);
	
	public boolean removeBoard(int id);
	
	public boolean modifyBoard(Board board);
	
	public boolean viewCntUp(int id);

	public int cntBoard(String str);
	
//	public boolean updateLike(int id);
//	
//	public int cntLike(int id);

}
