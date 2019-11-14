package com.rest.springboot.SpringbootCurd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {
	
	String message;

	public RecordNotFoundException(String message) {
		this.message=message;
	}

}
