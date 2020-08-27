package com.mcdeden.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcdeden.entity.User;
import com.mcdeden.helper.DateTimeHelper;
import com.mcdeden.model.request.UserRequestDTO;
import com.mcdeden.model.response.UserResponseDTO;
import com.mcdeden.repository.MasterGenderRepository;
import com.mcdeden.repository.MasterUserStatusRepository;
import com.mcdeden.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MasterGenderRepository masterGenderRepository;	
	@Autowired
	MasterUserStatusRepository masterUserStatusRepository;
	
	@Override
	public UserResponseDTO register(UserRequestDTO req) throws JsonProcessingException {

		User newUser = new User();
		UserResponseDTO response = new UserResponseDTO();
		
		LOGGER.info("USER-SERVICE: incoming user registration event with request: " + new ObjectMapper().writeValueAsString(req));
		
		LOGGER.info("Create user registration id");
		String userRegId = "ACC" + DateTimeHelper.getCurentTimestamp();
		LOGGER.info("User registration id is: " + userRegId);
		
		LOGGER.info("Create user data from request");
		newUser.setId(userRegId);
		newUser.setRegistrationDate(LocalDate.now());
		newUser.setRegistrationTime(LocalTime.now());
		newUser.setMobileNumber(req.getMobileNumber());
		newUser.setFirstName(req.getFirstName());
		newUser.setLastName(req.getLastName());
		newUser.setBirthDay(req.getBirthDate().getDayOfMonth());
		newUser.setBirthMonth(req.getBirthDate().getMonthValue());
		newUser.setBirthYear(req.getBirthDate().getYear());
		newUser.setBirthDate(req.getBirthDate());
		newUser.setGender(masterGenderRepository.findById(req.getGenderId()).get());
		newUser.setEmail(req.getEmail());
		newUser.setStatus(masterUserStatusRepository.findById("A").get());		
		LOGGER.info("User data is created");
		
		LOGGER.info("Start store user registration data");
		try {
			userRepository.save(newUser);	
			LOGGER.info("User registration is stored successfully");
			
			LOGGER.info("Create response");
			response.setId(newUser.getId());
			response.setRegistrationDate(newUser.getRegistrationDate());
			response.setRegistrationTime(newUser.getRegistrationTime());
			response.setFullName(newUser.getFirstName() + " " + newUser.getLastName());
			response.setEmail(newUser.getEmail());
			response.setMobileNumber(newUser.getMobileNumber());	
			response.setStatus(masterUserStatusRepository.findById("A").get().getName());
			LOGGER.info("Response is created");
		} catch(Exception ex) {
			LOGGER.error("New user can not be registered. Caused by " + ex.getLocalizedMessage());
			response.setId(null);
			response.setRegistrationDate(null);
			response.setRegistrationTime(null);
			response.setFullName(null);
			response.setEmail(null);
			response.setMobileNumber(null);	
			response.setStatus(null);
		}
		
		return response;
	}

	@Override
	public Boolean isExist(String email, String mop) {
		Optional<User> search = userRepository.findByEmailOrMobileNumber(email, mop);
		if (search.isPresent()) {
			return true;
		} else {
			return false;
		}
	}
	
}

