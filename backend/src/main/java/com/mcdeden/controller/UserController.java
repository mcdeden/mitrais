/**
 * 
 */
package com.mcdeden.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mcdeden.exception.DuplicationException;
import com.mcdeden.model.request.UserRequestDTO;
import com.mcdeden.model.response.UserResponseDTO;
import com.mcdeden.service.UserService;

/**
 * @Author mcdeden
 * @Web <https://mcdeden.github.io>
 * @CreatedDate Aug 24, 2020
 * @CreatedTime 5:08:23 PM
 * @ProjectName: user-service
 * @Package: com.mcdeden.controller
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService service;

	@PostMapping(value = "register")
	public ResponseEntity<UserResponseDTO> store(@Valid @RequestBody UserRequestDTO req) throws JsonProcessingException {
		LOGGER.info("--------------------------------------");
		LOGGER.info("Receive new user registration request with email: " + req.getEmail());

		if (service.isExist(req.getEmail(), req.getMobileNumber())) {
			throw new DuplicationException("Email or Mobile phone number already registared");
		}
		
		UserResponseDTO res = service.register(req);

		LOGGER.info("------------------------------------------");

		return new ResponseEntity<UserResponseDTO>(res, HttpStatus.CREATED);

	}
	
}
