package com.appdeveloperblog.app.ws.mobileappwsNew;

import java.util.List;

import com.appdeveloperblog.app.ws.mobileappwsNew.io.entity.UserEntity;
import com.appdeveloperblog.app.ws.shared.dto.UserDto;

//import com.appdeveloperblog.app.ws.shared.dto.UserDto;

public interface UserService {
	UserDto createUser(UserDto user);

	UserDto getUser(String email);

	UserDto getUserByUserId(String id);

	List<UserEntity> getAllUser();

	UserDto updateUser(String id, UserDto user);
}
