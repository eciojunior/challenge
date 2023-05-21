package com.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.PRECONDITION_FAILED)
public class ParameterValidationException extends Exception {

	private static final long serialVersionUID = 1452037085752116584L;

	public ParameterValidationException(String message) {
		super(message);
	}
	
}
