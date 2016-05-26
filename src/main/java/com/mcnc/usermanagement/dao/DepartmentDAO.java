package com.mcnc.usermanagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mcnc.usermanagement.dto.DepartmentDTO;
import com.mcnc.usermanagement.message.request.DepartmentQuery;
import com.mcnc.usermanagement.message.request.PageParam;

@Repository
public interface DepartmentDAO {

	DepartmentDTO findDepartment(Integer id);
	
	DepartmentDTO findDepartmentForUser(Integer userId);
	
	List<DepartmentDTO> findAllDepartments();

	void createDepartment(DepartmentDTO department);

	void updateDepartment(DepartmentDTO department);

	void deleteDepartment(Integer id);

	List<DepartmentDTO> searchDepartments(@Param("departmentQuery") DepartmentQuery departmentQuery, @Param("pageParam") PageParam pageParam);

	Integer countSearchDepartments(DepartmentQuery departmentQuery);
}
