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

import com.ssafy.golffy.model.dto.Subcmt;
import com.ssafy.golffy.model.service.SubcmtService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/subcmt")
public class SubcmtController {
	
	private static final Logger logger = LoggerFactory.getLogger(SubcmtController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	SubcmtService subcmtService;
	
	@ApiOperation(value = "모든 루트 댓글의 대댓글", response = List.class)
	@GetMapping
	public ResponseEntity<List<Subcmt>> listSubcmt() {
		logger.debug("getSubcmts - 호출");
		return new ResponseEntity<>(subcmtService.getSubcmts(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "id에 해당하는 대댓글의 정보를 반환한다.", response = Subcmt.class)
	@GetMapping("/{id}")
	public ResponseEntity<Subcmt> searchSubcmt(@PathVariable int id) {
		logger.debug("getSubcmt - 호출");
		return new ResponseEntity<Subcmt>(subcmtService.getSubcmt(id), HttpStatus.OK);
	}
	
	@ApiOperation(value = "새로운 대댓글을 입력한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> createSubcmt(@RequestBody Subcmt subcmt) {
		logger.debug("insertSubcmt - 호출");
		if(subcmtService.createSubcmt(subcmt)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@ApiOperation(value = "id에 해당하는 대댓글의 정보를 수정한다.", response = String.class)
	@PostMapping("/{id}")
	public ResponseEntity<String> modifySubcmt(@RequestBody Subcmt subcmt) {
		logger.debug("modifySubcmt - 호출");
		if(subcmtService.modifySubcmt(subcmt)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@ApiOperation(value = "id에 해당하는 댓글을 삭제한다", response = String.class)
	@PutMapping("{id}")
	public ResponseEntity<String> deleteSubcmt(@PathVariable int id) {
		logger.debug("deleteSubcmt - 호출");
		if(subcmtService.removeSubcmt(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	

}
