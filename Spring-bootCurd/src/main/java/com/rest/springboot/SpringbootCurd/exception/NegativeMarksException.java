package com.rest.springboot.SpringbootCurd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class NegativeMarksException extends RuntimeException {
	
	String message;

	public NegativeMarksException(String message) {
		this.message=message;
	}

}
