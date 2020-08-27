package com.mcdeden.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mcdeden.model.request.UserRequestDTO;
import com.mcdeden.model.response.UserResponseDTO;

public interface UserService {

	UserResponseDTO register(UserRequestDTO req) throws JsonProcessingException;
	Boolean isExist(String email, String mop);
	
}
