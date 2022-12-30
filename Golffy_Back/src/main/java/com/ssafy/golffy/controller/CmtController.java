package com.ssafy.golffy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.golffy.model.dto.Cmt;
import com.ssafy.golffy.model.service.CmtService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/cmt")
public class CmtController {
	
	private static final Logger logger = LoggerFactory.getLogger(CmtController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	CmtService cmtService;
	
	@ApiOperation(value = "모든 댓글의 리스트", response = List.class)
	@GetMapping("/{id}")
	public ResponseEntity<List<Cmt>> listCmt(@PathVariable int id){
		logger.debug("getcmts - 호출");
		return new ResponseEntity<List<Cmt>>(cmtService.getCmts(id), HttpStatus.OK);
	}
	
	@ApiOperation(value = "id에 해당하는 댓글의 정보를 반환한다.", response = Cmt.class)
	@GetMapping("/one/{id}")
	public ResponseEntity<Cmt> searchCmt(@PathVariable int id) {
		logger.debug("getcmt - 호출");
		return new ResponseEntity<>(cmtService.getCmt(id), HttpStatus.OK);
	}
	
	@ApiOperation(value = "새로운 댓글을 입력한다", response = String.class)
	@PostMapping
	public ResponseEntity<String> createCmt(@RequestBody Cmt cmt) {
		logger.debug("insertCmt - 호출");
		if (cmtService.createCmt(cmt)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "id에 해당하는 댓글의 정보를 수정한다", response = String.class)
	@PostMapping("{id}")
	public ResponseEntity<String> modifyCmt(@RequestBody Cmt cmt) {
		logger.debug("modifyCmt - 호출");
		logger.debug("" + cmt);
		if (cmtService.modifyCmt(cmt)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "댓글을 삭제한다.", response = Cmt.class)
	@PutMapping("/{id}")
	public ResponseEntity<String> deleteCmt(@PathVariable int id) {
		logger.debug("deleteCmt - 호출");
		if (cmtService.removeCmt(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	@ApiOperation(value = "댓글 개수", response = Integer.class)
    @GetMapping("/ccnt/{user_nick}")
    public ResponseEntity<Integer> cntcmt(@PathVariable String user_nick){
        logger.debug("cntboard");
        return new ResponseEntity<Integer>(cmtService.cntcmt(user_nick), HttpStatus.OK);
    }

}
