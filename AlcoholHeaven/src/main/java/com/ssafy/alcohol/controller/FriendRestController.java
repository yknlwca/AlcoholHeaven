package com.ssafy.alcohol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.alcohol.model.dto.Alcohol;
import com.ssafy.alcohol.model.dto.Friend;
import com.ssafy.alcohol.model.dto.SearchCondition;
import com.ssafy.alcohol.model.service.FriendService;


@RestController
@RequestMapping("/api/friend")
public class FriendRestController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	private final FriendService fService;

	@Autowired
	public FriendRestController(FriendService fService) {
		this.fService = fService;
	}


	@GetMapping("/search")
	public ResponseEntity<?> search(@ModelAttribute SearchCondition condition) {
		List<Friend> list = fService.searchFriend(condition);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Friend>>(list, HttpStatus.OK);
	}
	

	@GetMapping("")
	public ResponseEntity<?> selectAll() {
		List<Friend> list = fService.selectAll();
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Friend>>(list, HttpStatus.OK);
	}
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> detail(@PathVariable("id") int id) {
		Friend friend = fService.readFriend(id);
		if (friend != null) {
			return new ResponseEntity<Friend>(friend, HttpStatus.OK);
		}
		return new ResponseEntity<Friend>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("")
	public ResponseEntity<?> write(@RequestBody Friend friend) {
		fService.writeFriend(friend);
		return new ResponseEntity<Friend>(friend, HttpStatus.CREATED);
	}
	
	@PostMapping("/file")
	public ResponseEntity<Void> fileUpload(@RequestParam("file") MultipartFile multipartFile,
			@ModelAttribute Friend friend) {
		fService.fileFriend(multipartFile, friend);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (fService.removeFriend(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Friend friend){

		friend.setId(id);
		if(fService.modifyFriend(friend)) {
			return new ResponseEntity<Friend>(friend, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}
	
	
	@PutMapping("/likeup/{id}")
	public ResponseEntity<?> likeUp(@PathVariable("id") int id){
		if(fService.likeDown(id)) {
			return new ResponseEntity<Integer>(id, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/likedown/{id}")
	public ResponseEntity<?> likeDown(@PathVariable("id") int id){
		if(fService.likeDown(id)) {
			return new ResponseEntity<Integer>(id, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}
}
