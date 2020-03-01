package com.appdeveloperblog.app.ws.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdeveloperblog.app.ws.exceptions.UserServiceException;
import com.appdeveloperblog.app.ws.mobileappwsNew.UserRepository;
import com.appdeveloperblog.app.ws.mobileappwsNew.UserService;
import com.appdeveloperblog.app.ws.mobileappwsNew.io.entity.UserEntity;
import com.appdeveloperblog.app.ws.shared.dto.UserDto;
import com.appsdeveloperblog.app.ws.ui.model.response.ErrorMessages;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto user) {
	
		if (userRepository.findByEmail(user.getEmail()) != null)
			throw new RuntimeException("Email Already exists");
//else part
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);

		userEntity.setEncryptedPassword("test");
		userEntity.setUserId("testUserId");

		UserEntity storedUserDetails = userRepository.save(userEntity);



		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);

		return returnValue;
	}

	@Override
	public UserDto getUser(String email) {
		UserEntity userEntity = userRepository.findByEmail(email);

		if (userEntity == null)
			throw new RuntimeException("UserEntity is null");

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(userEntity, returnValue);

		return returnValue;
	}

	@Override
	public UserDto getUserByUserId(String userId) {


		UserEntity userEntity = userRepository.findById(userId);
		if (userEntity == null)
			throw new RuntimeException("UserEntity is null in get by user id");

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(userEntity, returnValue);
		return returnValue;
	}

	@Override
	public List<UserEntity> getAllUser() {
		// TODO Auto-generated method stub
//		List<UserDto> temp = null;
//		List<UserEntity> userEntity = userRepository.findAll();
//
//		System.out.println(userEntity);
//		BeanUtils.copyProperties(userEntity, temp);
		return userRepository.findAllDetails();
	}

	@Override
	public UserDto updateUser(String userId, UserDto user) {
		UserDto returnValue = new UserDto();
		UserEntity userEntity = userRepository.findById(userId);

		if (userEntity == null)
			throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

		userEntity.setFirstName(user.getFirstName());
		userEntity.setLastName(user.getLastName());

		UserEntity updatedUserDetails = userRepository.save(userEntity);// jpa method to save data
		BeanUtils.copyProperties(updatedUserDetails, returnValue);
		return returnValue;
	}

}
