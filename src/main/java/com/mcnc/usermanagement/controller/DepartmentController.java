package com.mcnc.usermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mcnc.usermanagement.constant.Url;

@Controller
@RequestMapping(Url.DEPARTMENT)
public class DepartmentController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getDepartmetList() {
		return Url.DEPARTMENT;
	}
}
