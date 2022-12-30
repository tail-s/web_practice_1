package com.ssafy.golffy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.golffy.model.dao.SubcmtDao;
import com.ssafy.golffy.model.dto.Subcmt;

@Service
public class SubcmtServiceImpl implements SubcmtService {
	
	@Autowired
	private SubcmtDao subcmtDao;

	@Override
	public List<Subcmt> getSubcmts() {
		return subcmtDao.selectAll();
	}

	@Override
	public Subcmt getSubcmt(int id) {
		return subcmtDao.selectOne(id);
	}

	@Override
	public boolean createSubcmt(Subcmt subcmt) {
		return subcmtDao.insertSubcmt(subcmt) == 1;
	}

	@Override
	public boolean removeSubcmt(int id) {
		return subcmtDao.deleteSubcmt(id) == 1;
	}

	@Override
	public boolean modifySubcmt(Subcmt subcmt) {
		return subcmtDao.updateSubcmt(subcmt) == 1;
	}

}
