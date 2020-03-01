package com.appsdeveloperblog.app.ws.mobileappws.ui.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appdeveloperblog.app.ws.exceptions.UserServiceException;
import com.appdeveloperblog.app.ws.mobileappwsNew.UserService;
import com.appdeveloperblog.app.ws.mobileappwsNew.io.entity.UserEntity;
import com.appdeveloperblog.app.ws.shared.dto.UserDto;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.ErrorMessages;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(path = "/{id}")
	public UserRest getUser(@PathVariable String id) {
		UserRest returnValue = new UserRest();

		UserDto userDto = userService.getUserByUserId(id);
		BeanUtils.copyProperties(userDto, returnValue);
		return returnValue;
	}

	@GetMapping(path = "/allUsers")
	public List<UserEntity> getallUser() {
		UserRest returnValue = new UserRest();

		List<UserEntity> userDto = userService.getAllUser();
//		BeanUtils.copyProperties(userDto, returnValue);
		return userDto;
	}

	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) throws UserServiceException {
		System.out.println("HELLOOOOO");
		System.out.println(userDetails);
		UserRest returnValue = new UserRest();
		if (userDetails.getFirstName().isEmpty()) {
			throw new UserServiceException(ErrorMessages.RECORD_ALREADY_EXISTS.getErrorMessage());
		}

		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);// converts request object(JSON) to java object

		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);// converts request object(JSON) to java object

		return returnValue;
	}

	@PutMapping(path = "/{id}")
	public UserRest updateUser(@PathVariable String id, @RequestBody UserDetailsRequestModel userDetails) {

		UserRest returnValue = new UserRest();
		if (userDetails.getFirstName().isEmpty()) {
			throw new UserServiceException(ErrorMessages.RECORD_ALREADY_EXISTS.getErrorMessage());
		}

		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);// converts request object(JSON) to java object

		UserDto updatedUser = userService.updateUser(id, userDto);
		BeanUtils.copyProperties(updatedUser, returnValue);// converts request object(JSON) to java object

		return returnValue;
	}

	@DeleteMapping
	public String deleteUser() {
		return "Delete user was called";
	}

}
