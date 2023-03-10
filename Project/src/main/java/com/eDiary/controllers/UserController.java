package com.eDiary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eDiary.entities.UserEntity;
import com.eDiary.repositories.UserRepository;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<Iterable<UserEntity>>(userRepository.findAll(), HttpStatus.OK);
	}
}
