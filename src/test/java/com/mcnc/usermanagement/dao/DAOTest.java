package com.mcnc.usermanagement.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcnc.usermanagement.service.DepartmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:com/mcnc/usermanagement/spring/root-context.xml")
public class DAOTest {

	@Autowired
	private DepartmentService departmentService;
	
	@Test
	public void doTest() {
		departmentService.testTransaction();
	}
}
