package com.ssafy.alcohol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.alcohol.model.dto.Friend;
import com.ssafy.alcohol.model.dto.SearchCondition;
import com.ssafy.alcohol.model.service.FriendService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/with")
public class FriendRestController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	private final FriendService fService;

	@Autowired
	public FriendRestController(FriendService fService) {
		this.fService = fService;
	}

	@GetMapping("/friend")
	public ResponseEntity<?> list(SearchCondition condtion) {
		List<Friend> list = fService.searchFriend(condtion);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Friend>>(list, HttpStatus.OK);
	}

	@GetMapping("/friend/{id}")
	public ResponseEntity<?> detail(@PathVariable("id") int id) {
		Friend friend = fService.readFriend(id);
		if (friend != null) {
			return new ResponseEntity<Friend>(friend, HttpStatus.OK);
		}
		return new ResponseEntity<Friend>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/friend")
	public ResponseEntity<?> write(@RequestBody Friend friend) {
		fService.writeFriend(friend);
		return new ResponseEntity<Friend>(friend, HttpStatus.CREATED);
	}

	@DeleteMapping("/friend/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (fService.removeFriend(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}
}
