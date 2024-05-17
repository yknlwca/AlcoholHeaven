package com.ssafy.alcohol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.alcohol.model.dto.User;
import com.ssafy.alcohol.model.service.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	private UserServiceImpl uService;

	@Autowired
	public UserRestController(UserServiceImpl uService) {
		this.uService = uService;
	}

	@GetMapping("")
	public ResponseEntity<?> list() {
		List<User> list = uService.searchAll();
		if (list == null || list.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> selectOne(@PathVariable("id") String id) {
		User user = uService.readUser(id);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("")
	public ResponseEntity<?> make(@RequestBody User user) {
		try {
			uService.writeUser(user);
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		if (uService.removeUser(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody User user) {
		user.setId(id);
		if (uService.modifyUser(user)) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}
	
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {
        User loggedInUser = uService.login(user.getId(), user.getPassword());
        if (loggedInUser != null) {
            session.setAttribute("user", loggedInUser);
            return new ResponseEntity<User>(loggedInUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("실패", HttpStatus.UNAUTHORIZED);
        }
    }
}
