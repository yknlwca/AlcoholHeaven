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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.alcohol.model.dto.Alcohol;
import com.ssafy.alcohol.model.dto.SearchCondition;
import com.ssafy.alcohol.model.service.AlcoholService;


@RestController
@RequestMapping("/api/alcohol")
public class AlcoholRestController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	private final AlcoholService alService;

	@Autowired
	public AlcoholRestController(AlcoholService alService) {
		this.alService = alService;
	}

	@GetMapping("")
	public ResponseEntity<?> selectAll() {
		List<Alcohol> list = alService.selectAll();
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Alcohol>>(list, HttpStatus.OK);
	}
	@GetMapping("/search")
	public ResponseEntity<?> search(@RequestBody SearchCondition condition) {
		List<Alcohol> list = alService.searchBoard(condition);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Alcohol>>(list, HttpStatus.OK);
	}
	@GetMapping("/{region}")
	public ResponseEntity<?> selectByRegion(@PathVariable("region") String region) {
		List<Alcohol> alcohols = alService.selectAlcohol(region);
		if (alcohols != null) {
			return new ResponseEntity<>(alcohols, HttpStatus.OK);
		}
		return new ResponseEntity<Alcohol>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<Alcohol> detail(@PathVariable("id") int id) {
		Alcohol alcohol = alService.readAlcohol(id);
		if (alcohol != null) {
			return new ResponseEntity<Alcohol>(alcohol, HttpStatus.OK);
		}
		return new ResponseEntity<Alcohol>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("")
	public ResponseEntity<?> write(@RequestBody Alcohol alcohol) {
		alService.writeAlcohol(alcohol);
		return new ResponseEntity<Alcohol>(alcohol, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (alService.removeAlcohol(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}
}
