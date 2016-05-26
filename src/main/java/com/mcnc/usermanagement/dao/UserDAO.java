package com.mcnc.usermanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mcnc.usermanagement.dto.UserDTO;
import com.mcnc.usermanagement.message.request.PageParam;
import com.mcnc.usermanagement.message.request.UserQuery;

@Repository
public interface UserDAO {
	
	UserDTO findByUsername(String username);
	
	UserDTO findUser(Integer id);
	
	UserDTO findUserWithDepartment(Integer id);
	
	void createUser(UserDTO user);

	void updateUser(UserDTO user);

	void deleteUser(Integer id);

	List<UserDTO> searchUsers(@Param("userQuery") UserQuery userQuery, @Param("pageParam") PageParam pageParam);
	
	Integer countSearchUsers(UserQuery studentQuery);
}
