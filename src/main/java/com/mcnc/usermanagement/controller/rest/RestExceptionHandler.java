package com.mcnc.usermanagement.controller.rest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.mcnc.usermanagement.exception.ResourceNotFoundException;
import com.mcnc.usermanagement.message.response.ErrorMessage;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorMessage handleNoHandlerFoundException(NoHandlerFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
		errorMessage.setMessage("Resource Not Found");
		return errorMessage;
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorMessage handleRestErrorException(ResourceNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
		errorMessage.setMessage(ex.getMessage());
		return errorMessage;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ErrorMessage handleOtherException(HttpServletResponse resp, Exception ex) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatus(resp.getStatus());
		errorMessage.setMessage(ex.getMessage());
		return errorMessage;
	}
}
