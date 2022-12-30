package com.ssafy.golffy.model.dao;

import java.util.List;

import com.ssafy.golffy.model.dto.Cmt;

public interface CmtDao {
	
	public List<Cmt> selectAll(int id);
	
	public Cmt selectOne(int id);
	
	public int insertCmt(Cmt cmt);
	
	public int deleteCmt(int id);
	
	public int updateCmt(Cmt cmt);
	
	public int cmtcnt(String str);
}
