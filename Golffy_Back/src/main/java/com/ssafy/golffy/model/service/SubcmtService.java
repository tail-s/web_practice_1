package com.ssafy.golffy.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.golffy.model.dto.Subcmt;

@Service
public interface SubcmtService {
	
	public List<Subcmt> getSubcmts();
	
	public Subcmt getSubcmt(int id);
	
	public boolean createSubcmt(Subcmt subcmt);
	
	public boolean removeSubcmt(int id);
	
	public boolean modifySubcmt(Subcmt subcmt);

}
