package com.mcnc.usermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mcnc.usermanagement.constant.Url;

@Controller
public class AuthController {
	
	@RequestMapping(value = Url.LOGIN, method = RequestMethod.GET)
	public String getLogin() {
		return Url.LOGIN;
	}
}
