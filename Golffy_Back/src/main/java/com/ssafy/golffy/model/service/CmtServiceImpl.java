package com.ssafy.golffy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.golffy.model.dao.CmtDao;
import com.ssafy.golffy.model.dto.Cmt;

@Service
public class CmtServiceImpl implements CmtService {
	
	@Autowired
	private CmtDao cmtDao;

	@Override
	public List<Cmt> getCmts(int id) {
		return cmtDao.selectAll(id);
	}

	@Override
	public Cmt getCmt(int id) {
		return cmtDao.selectOne(id);
	}

	@Override
	public boolean createCmt(Cmt cmt) {
		return cmtDao.insertCmt(cmt) == 1;
	}

	@Override
	public boolean removeCmt(int id) {
		return cmtDao.deleteCmt(id) == 1;
	}

	@Override
	public boolean modifyCmt(Cmt cmt) {
		return cmtDao.updateCmt(cmt) == 1;
	}
	@Override
    public int cntcmt(String str) {
        return cmtDao.cmtcnt(str);
    }

}
