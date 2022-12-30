package com.ssafy.golffy.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.golffy.model.dto.Cmt;

@Service
public interface CmtService {
	
	public List<Cmt> getCmts(int id);
	
	public Cmt getCmt(int id);
	
	public boolean createCmt(Cmt cmt);
	
	public boolean removeCmt(int id);
	
	public boolean modifyCmt(Cmt cmt);
	
	public int cntcmt(String str);
}
