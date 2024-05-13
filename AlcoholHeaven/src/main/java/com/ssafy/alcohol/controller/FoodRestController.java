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

import com.ssafy.alcohol.model.dto.Food;
import com.ssafy.alcohol.model.dto.SearchCondition;
import com.ssafy.alcohol.model.service.FoodService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/food")
public class FoodRestController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	private final FoodService fService;
	
	@Autowired
	public FoodRestController(FoodService fService) {
		this.fService = fService;
	}
	
	@GetMapping("/food")
	public ResponseEntity<?> list(SearchCondition condition){
		List<Food> list= fService.searchFood(condition);
		if(list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Food>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/food/{id}")
	public ResponseEntity<?> detail(@PathVariable("id") int id){
		Food food = fService.readFood(id);
		if(food != null) {
			return new ResponseEntity<Food>(food, HttpStatus.OK);
		}
		return new ResponseEntity<Food>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/food")
	public ResponseEntity<?> write(@RequestBody Food food){
		fService.writeFood(food);
		return new ResponseEntity<Food>(food, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/food/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if(fService.removeFood(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}
}
