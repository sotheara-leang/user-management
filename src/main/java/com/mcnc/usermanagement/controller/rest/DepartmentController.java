package com.mcnc.usermanagement.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mcnc.usermanagement.constant.Url;
import com.mcnc.usermanagement.dto.DepartmentDTO;
import com.mcnc.usermanagement.exception.ResourceNotFoundException;
import com.mcnc.usermanagement.message.request.DepartmentQuery;
import com.mcnc.usermanagement.message.request.PageParam;
import com.mcnc.usermanagement.message.response.PageWrapper;
import com.mcnc.usermanagement.service.DepartmentService;

@RestController
@RequestMapping(Url.API.DEPARTMENT)
public class DepartmentController {
	
	private final String NOT_FOUND_MSG = "Department with id = %d is not found.";
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<DepartmentDTO> findAllDepartments() {
		return departmentService.findAllDepartments();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public DepartmentDTO findDepartment(@PathVariable("id") Integer id) {
		DepartmentDTO department = departmentService.findDepartment(id);
		if (department == null) {
			throw new ResourceNotFoundException(String.format(NOT_FOUND_MSG, id));
		}
		return department;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO department) {
		departmentService.createDepartment(department);
		return new ResponseEntity<DepartmentDTO>(HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody DepartmentDTO department) {
		DepartmentDTO dbUser = departmentService.findDepartment(department.getId());
		if (dbUser == null) {
			throw new ResourceNotFoundException(String.format(NOT_FOUND_MSG, department.getId()));
		}
		departmentService.updateDepartment(department);
		return new ResponseEntity<DepartmentDTO>(HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<DepartmentDTO> deleteStudent(@PathVariable("id") Integer id) {
		DepartmentDTO department = departmentService.findDepartment(id);
		if (department == null) {
			throw new ResourceNotFoundException(String.format(NOT_FOUND_MSG, id));
		}
		departmentService.deleteDepartment(id);
		return new ResponseEntity<DepartmentDTO>(HttpStatus.OK);
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public PageWrapper<DepartmentDTO> searchStudent(DepartmentQuery userQuery, PageParam pageParam) {
		return departmentService.searchDepartments(userQuery, pageParam);
	}
}
