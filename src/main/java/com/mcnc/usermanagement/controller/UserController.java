package com.mcnc.usermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mcnc.usermanagement.constant.Url;

@Controller
@RequestMapping(Url.USER)
public class UserController {

	@RequestMapping(method = RequestMethod.GET)
	public String getUserList() {
		return Url.USER;
	}
}
