package com.mcnc.usermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	
	private final String ERRO_PATH = "error";
	 
	@RequestMapping(value = "/400")
	public String error400() {
		return ERRO_PATH + "/400";
	}

	@RequestMapping(value = "/404")
	public String error404() {
		return ERRO_PATH + "/404";
	}
	
	@RequestMapping(value = "/403")
	public String error403() {
		return ERRO_PATH + "/403";
	}

	@RequestMapping(value = "/500")
	public String error500() {
		return ERRO_PATH + "/500";
	}
}
