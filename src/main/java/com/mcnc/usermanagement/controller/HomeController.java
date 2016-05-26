package com.mcnc.usermanagement.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mcnc.usermanagement.constant.Url;
import com.mcnc.usermanagement.dto.UserDTO;

@Controller
public class HomeController {
	
	@RequestMapping(value = Url.INDEX, method = RequestMethod.GET)
	public String getIndex(@AuthenticationPrincipal UserDTO user) {
		return Url.INDEX;
	}
}