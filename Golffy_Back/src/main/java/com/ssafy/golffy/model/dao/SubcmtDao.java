package com.ssafy.golffy.model.dao;

import java.util.List;

import com.ssafy.golffy.model.dto.Subcmt;

public interface SubcmtDao {
	
	public List<Subcmt> selectAll();
	
	public Subcmt selectOne(int id);
	
	public int insertSubcmt(Subcmt subcmt);
	
	public int deleteSubcmt(int id);
	
	public int updateSubcmt(Subcmt subcmt);

}
