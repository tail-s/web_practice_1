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

import com.ssafy.golffy.model.service.BoardService;
import com.ssafy.golffy.model.dto.Board;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "/*" }, maxAge = 6000)
@RestController
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	BoardService boardService;
	
	@ApiOperation(value = "모든 글의 리스트", response = List.class)
	@GetMapping
	public ResponseEntity<List<Board>> listBoard(){
		logger.debug("boardlist");
		return new ResponseEntity<List<Board>>(boardService.getBoards(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "id에 해당하는 글의 정보를 반환한다.", response = Board.class)
	@GetMapping("/{id}")
	public ResponseEntity<Board> searchBoard(@PathVariable int id) {
		logger.debug("searchTitle - 호출");
		boardService.viewCntUp(id);
		return new ResponseEntity<>(boardService.getBoard(id), HttpStatus.OK);
	}
	
	@ApiOperation(value = "새로운 게시글 입력한다", response = String.class)
	@PostMapping
	public ResponseEntity<String> createBoard(@RequestBody Board board) {
		logger.debug("insertBoard - 호출");
		if (boardService.createBoard(board)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "id에 해당하는 게시글 정보를 수정한다", response = String.class)
	@PutMapping
	public ResponseEntity<String> modifyBoard(@RequestBody Board board) {
		logger.debug("modifyBoard - 호출");
		logger.debug("" + board);
		if (boardService.modifyBoard(board)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "게시글을 삭제한다.", response = Board.class)
	@PutMapping("/{id}")
	public ResponseEntity<String> deleteBoard(@PathVariable int id) {
		logger.debug("deleteBaord - 호출");
		if (boardService.removeBoard(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	@ApiOperation(value = "게시글 개수", response = Integer.class)
    @GetMapping("/bcnt/{user_nick}")
    public ResponseEntity<Integer> cntboard(@PathVariable String user_nick){
        logger.debug("cntboard");
        return new ResponseEntity<Integer>(boardService.cntBoard(user_nick), HttpStatus.OK);
    }

}
