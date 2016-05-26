package com.mcnc.usermanagement.controller.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mcnc.usermanagement.constant.Url;
import com.mcnc.usermanagement.dto.UserDTO;
import com.mcnc.usermanagement.exception.ResourceNotFoundException;
import com.mcnc.usermanagement.message.request.PageParam;
import com.mcnc.usermanagement.message.request.UserQuery;
import com.mcnc.usermanagement.message.response.PageWrapper;
import com.mcnc.usermanagement.service.UserService;

@RestController
@RequestMapping(Url.API.USER)
public class UserController {
	
	private final String NOT_FOUND_MSG = "User with id = %d is not found.";

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder pwdEncoder;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public UserDTO findUser(@PathVariable("id") Integer id) {
		UserDTO user = userService.findUser(id);
		if (user == null) {
			throw new ResourceNotFoundException(String.format(NOT_FOUND_MSG, id));
		}
		return user;
	}
	
	@RequestMapping(value = "findUserWithDepartment/{id}", method = RequestMethod.GET)
	public UserDTO findUserWithDepartment(@PathVariable("id") Integer id) {
		UserDTO user = userService.findUserWithDepartment(id);
		if (user == null) {
			throw new ResourceNotFoundException(String.format(NOT_FOUND_MSG, id));
		}
		return user;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
		if (user.getPassword() != null) {
			user.setPassword(pwdEncoder.encode(user.getPassword()));
		}
		userService.createUser(user);
		return new ResponseEntity<UserDTO>(HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user) {
		UserDTO dbUser = userService.findUser(user.getId());
		if (dbUser == null) {
			throw new ResourceNotFoundException(String.format(NOT_FOUND_MSG, user.getId()));
		}
		if (user.getPassword() != null) {
			user.setPassword(pwdEncoder.encode(user.getPassword()));
		} else {
			user.setPassword(dbUser.getPassword());
		}
		userService.updateUser(user);
		return new ResponseEntity<UserDTO>(HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserDTO> deleteStudent(@PathVariable("id") Integer id) {
		UserDTO user = userService.findUser(id);
		if (user == null) {
			throw new ResourceNotFoundException(String.format(NOT_FOUND_MSG, id));
		}
		userService.deleteUser(id);
		return new ResponseEntity<UserDTO>(HttpStatus.OK);
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public PageWrapper<UserDTO> searchStudent(UserQuery userQuery, PageParam pageParam) {
		return userService.searchUsers(userQuery, pageParam);
	}
}
