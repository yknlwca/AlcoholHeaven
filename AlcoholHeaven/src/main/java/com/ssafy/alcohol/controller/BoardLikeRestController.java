package com.ssafy.alcohol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.alcohol.model.dto.boardLike;
import com.ssafy.alcohol.model.service.BoardLikeServiceImpl;

@RestController
@RequestMapping("/api/boardLike")
public class BoardLikeRestController {
	
	@Autowired
	private BoardLikeServiceImpl bService;
	@GetMapping("/check")
	public ResponseEntity<?> check(boardLike boardLike){
		boardLike checker = bService.select(boardLike);
		if(checker == null) {
			return new ResponseEntity<>(false,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(true,HttpStatus.OK);
		}
	}
	@GetMapping("/{type}/{boardId}")
	public ResponseEntity<?> likeCnt(@PathVariable("type")int type, @PathVariable("boardId")int boardId){
		int cnt = bService.likeCnt(type, boardId);
		return new ResponseEntity<>(cnt,HttpStatus.OK);
	}
	@PostMapping("/click-like")
	public ResponseEntity<?> clickLike(@RequestBody boardLike boardLike){
		int result = bService.insert(boardLike);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	@DeleteMapping("/remove-like")
	public ResponseEntity<?> removeLike(@RequestBody boardLike boardLike){
		int result = bService.delete(boardLike);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
