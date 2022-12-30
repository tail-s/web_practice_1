package com.ssafy.golffy.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

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

import com.ssafy.golffy.model.dto.User;
import com.ssafy.golffy.model.service.UserService;
import com.ssafy.golffy.util.JwtUtil;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private JwtUtil jwtUtil;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
		HashMap<String, Object> result = new HashMap<>();
		
		

//		if(userService.checker(user.getUser_id()))
		HttpStatus status = null;
		
		try {
			if(userService.loginChecker(user.getUser_id(), user.getUser_pw())) {
				result.put("access-token", jwtUtil.createToken("user_id", user.getUser_id()));
				result.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}				
			else {
				result.put("message", FAIL);
				status = HttpStatus.ACCEPTED;				
			}				
		}
		catch (UnsupportedEncodingException e) {
			result.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String, Object>>(result, status);
	}

	
	@ApiOperation(value = "신규 유저를 등록한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> registUser(@RequestBody User user) {
		logger.debug("Regist");
		String msg = null;
		if(userService.checker(user.getUser_id())) {
			if(userService.createUser(user)) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			}
			else {
				msg = "서버 오류";
				return new ResponseEntity<String>(msg, HttpStatus.OK);	
			}			
		}		
		msg = "중복된 아이디입니다. 다시 확인해주세요.";
		return new ResponseEntity<String>(msg, HttpStatus.OK);		
	}
	
	@ApiOperation(value = "해당 id에 해당하는 유저 정보를 반환한다.", response = User.class)
	@GetMapping("/login/{user_id}")
	public ResponseEntity<User> findUser(@PathVariable String user_id) {
		logger.debug("Find");
		return new ResponseEntity<User>(userService.getUser(user_id), HttpStatus.OK);
	}
	
	@ApiOperation(value = "해당 id에 해당하는 유저 정보를 수정한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> modifyUser(@RequestBody User user) {
		logger.debug("Modify");
		if(userService.modifyUser(user)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);		
	}
	
	@ApiOperation(value = "해당 id에 해당하는 유저 정보를 삭제한다.", response = String.class)
	@PutMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		logger.debug("Delete");
		if(userService.removeUser(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);		
	}
	
	
}
