package com.mcnc.usermanagement.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.mcnc.usermanagement.dto.UserDTO;
import com.mcnc.usermanagement.message.request.PageParam;
import com.mcnc.usermanagement.message.request.UserQuery;
import com.mcnc.usermanagement.message.response.PageWrapper;

public interface UserService extends UserDetailsService {
	
	@PreAuthorize("hasRole('ADMIN')")
	UserDTO findUser(Integer id);
	
	UserDTO findByUsername(String username);
	
	@PreAuthorize("hasRole('ADMIN')")
	UserDTO findUserWithDepartment(Integer id);
	
	@PreAuthorize("hasRole('ADMIN')")
	void createUser(UserDTO user);
	
	@PreAuthorize("hasRole('ADMIN')")
	void updateUser(UserDTO user);
	
	@PreAuthorize("hasRole('ADMIN')")
	void deleteUser(Integer id);

	@PreAuthorize("hasRole('ADMIN')")
	PageWrapper<UserDTO> searchUsers(UserQuery userQuery, PageParam pageParam);
	
	Integer countSearchUsers(UserQuery userQuery);
}
