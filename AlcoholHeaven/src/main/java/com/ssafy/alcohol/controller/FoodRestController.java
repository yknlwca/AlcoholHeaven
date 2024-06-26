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

import com.ssafy.alcohol.model.dto.Food;
import com.ssafy.alcohol.model.dto.SearchCondition;
import com.ssafy.alcohol.model.service.FoodService;

@RestController
@RequestMapping("/api/food")
public class FoodRestController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	private final FoodService fService;

	@Autowired
	public FoodRestController(FoodService fService) {
		this.fService = fService;
	}

	@GetMapping("")
	public ResponseEntity<?> selectAll() {
		List<Food> list = fService.selectAll();
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Food>>(list, HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<?> list(@ModelAttribute SearchCondition condition) {
		List<Food> list = fService.searchFood(condition);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Food>>(list, HttpStatus.OK);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<?> detail(@PathVariable("id") int id) {
		Food food = fService.readFood(id);
		if (food != null) {
			return new ResponseEntity<Food>(food, HttpStatus.OK);
		}
		return new ResponseEntity<Food>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("")
	public ResponseEntity<?> write(@RequestBody Food food) {
		fService.writeFood(food);
		return new ResponseEntity<Food>(food, HttpStatus.CREATED);
	}
	
	@PostMapping("/file")
	public ResponseEntity<Void> fileUpload(@RequestParam("file") MultipartFile multipartFile,
			@ModelAttribute Food food) {
		fService.fileFood(multipartFile, food);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (fService.removeFood(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Food food) {
		food.setId(id);
		if (fService.modifyFood(food)) {
			return new ResponseEntity<Food>(food, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/file/{id}")
	public ResponseEntity<Void> updateFileUpload(@PathVariable int id,
	                                             @RequestParam(value = "file", required = false) MultipartFile multipartFile,
	                                             @ModelAttribute Food food) {
	    food.setId(id); // 업데이트할 엔티티의 ID 설정
	    fService.updateFood(multipartFile, food);
	    return new ResponseEntity<>(HttpStatus.OK);
	}


	@PutMapping("/likeup/{id}")
	public ResponseEntity<?> likeUp(@PathVariable("id") int id) {
		if (fService.likeUp(id)) {
			return new ResponseEntity<Integer>(id, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}

	@PutMapping("/likedown/{id}")
	public ResponseEntity<?> likeDown(@PathVariable("id") int id) {
		if (fService.likeDown(id)) {
			return new ResponseEntity<Integer>(id, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}


}
