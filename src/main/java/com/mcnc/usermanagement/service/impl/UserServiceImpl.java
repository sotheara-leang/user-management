package com.mcnc.usermanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mcnc.usermanagement.dao.UserDAO;
import com.mcnc.usermanagement.dto.UserDTO;
import com.mcnc.usermanagement.message.request.PageParam;
import com.mcnc.usermanagement.message.request.UserQuery;
import com.mcnc.usermanagement.message.response.PageWrapper;
import com.mcnc.usermanagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = findByUsername(username);
		if (userDetails == null) {
			throw new UsernameNotFoundException("Username is invalid");
		}
		return userDetails;
	}
	
	@Override
	public UserDTO findByUsername(String username) {
		return userDAO.findByUsername(username);
	}

	@Override
	public UserDTO findUser(Integer id) {
		return userDAO.findUser(id);
	}
	
	@Override
	public UserDTO findUserWithDepartment(Integer id) {
		return userDAO.findUserWithDepartment(id);
	}

	@Override
	public void createUser(UserDTO student) {
		userDAO.createUser(student);
	}

	@Override
	public void updateUser(UserDTO student) {
		userDAO.updateUser(student);
	}

	@Override
	public void deleteUser(Integer id) {
		userDAO.deleteUser(id);
	}

	@Override
	public PageWrapper<UserDTO> searchUsers(UserQuery userQuery, PageParam pageParam) {
		Integer totalPages = 0;
		Integer totalRecords = countSearchUsers(userQuery);
		
		if (totalRecords > 0 && pageParam.getSize() > 0) {
			totalPages = (int) Math.ceil((float) totalRecords / pageParam.getSize());
		}
		if (pageParam.getPage() > totalPages) {
			pageParam.setPage(totalPages);
		}
		List<UserDTO> records = userDAO.searchUsers(userQuery, pageParam);
		
		PageWrapper<UserDTO> pageWrapper = new PageWrapper<UserDTO>();
		pageWrapper.setPage(pageParam.getPage());
		pageWrapper.setSize(pageParam.getSize());
		pageWrapper.setTotalPages(totalPages);
		pageWrapper.setTotalRecords(totalRecords);
		pageWrapper.setRecords(records);
		return pageWrapper;
	}

	@Override
	public Integer countSearchUsers(UserQuery userQuery) {
		return userDAO.countSearchUsers(userQuery);
	}
}
