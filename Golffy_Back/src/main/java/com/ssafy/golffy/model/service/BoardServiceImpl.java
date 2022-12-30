package com.ssafy.golffy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.golffy.model.dao.BoardDao;
import com.ssafy.golffy.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public List<Board> getBoards() {
		return boardDao.selectAll();
	}

	@Override
	public Board getBoard(int id) {
		return boardDao.selectOne(id);
	}

	@Override
	public boolean createBoard(Board board) {
		return boardDao.insertBoard(board) == 1;
	}

	@Override
	public boolean removeBoard(int id) {
		return boardDao.deleteBoard(id) == 1;
	}

	@Override
	public boolean modifyBoard(Board board) {
		return boardDao.updateBoard(board) == 1;
	}

	@Override
	public boolean viewCntUp(int id) {
		return boardDao.updateViewCnt(id) == 1;
	}
	
	 @Override
	    public int cntBoard(String str) {
	        return boardDao.boardCnt(str);
	    }

//	@Override
//	public boolean updateLike(int id) {
//		return boardDao.updateLike(id)==1;
//	}
//
//	@Override
//	public int cntLike(int id) {
//		return boardDao.cntLike(id);
//	}

}
