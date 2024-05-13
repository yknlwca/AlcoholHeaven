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

import com.ssafy.alcohol.model.dto.Alcohol;
import com.ssafy.alcohol.model.service.AlcoholService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/alcohol")
public class AlcoholRestController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	private final AlcoholService alService;
	
	@Autowired
	public AlcoholRestController(AlcoholService alService) {
		this.alService = alService;
	}
	
	@GetMapping("/alcohol")
	public ResponseEntity<?> list(String region){
		List<Alcohol> list = alService.searchBoard(region);
		if(list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Alcohol>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/alcohol/{name}")
	public ResponseEntity<Alcohol> detail(@PathVariable("name") String name){
		Alcohol alcohol = alService.readAlcohol(name);
		if(alcohol != null) {
			return new ResponseEntity<Alcohol>(alcohol, HttpStatus.OK);
		}
		return new ResponseEntity<Alcohol>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/alcohol")
	public ResponseEntity<?> write(@RequestBody Alcohol alcohol){
		alService.writeAlcohol(alcohol);
		return new ResponseEntity<Alcohol>(alcohol, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/alcohol/{name}")
	public ResponseEntity<?> delete(@PathVariable("name") String name){
		if(alService.removeAlcohol(name)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}
}
