package com.mcnc.usermanagement.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcnc.usermanagement.dao.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:com/mcnc/usermanagement/spring/root-context.xml")
public class SimpleAspectTest {

	@Autowired
	private UserDAO userDAO;
	
	@Test
	public void doTest() {
		userDAO.findByUsername("admin");
	}
}
