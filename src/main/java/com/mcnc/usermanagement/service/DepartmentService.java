package com.mcnc.usermanagement.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.mcnc.usermanagement.dto.DepartmentDTO;
import com.mcnc.usermanagement.message.request.DepartmentQuery;
import com.mcnc.usermanagement.message.request.PageParam;
import com.mcnc.usermanagement.message.response.PageWrapper;

public interface DepartmentService {
	
	@PreAuthorize("hasRole('ADMIN')")
	DepartmentDTO findDepartment(Integer id);
	
	DepartmentDTO findDepartmentForUser(Integer userId);
	
	@PreAuthorize("hasRole('ADMIN')")
	List<DepartmentDTO> findAllDepartments();

	@PreAuthorize("hasRole('ADMIN')")
	void createDepartment(DepartmentDTO Department);

	@PreAuthorize("hasRole('ADMIN')")
	void updateDepartment(DepartmentDTO Department);

	@PreAuthorize("hasRole('ADMIN')")
	void deleteDepartment(Integer id);
	
	@PreAuthorize("hasRole('ADMIN')")
	PageWrapper<DepartmentDTO> searchDepartments(DepartmentQuery DepartmentQuery, PageParam pageParam);

	Integer countSearchDepartments(DepartmentQuery studentQuery);
	
	void testTransaction();
}
