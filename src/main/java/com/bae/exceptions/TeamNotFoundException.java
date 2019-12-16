package com.bae.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "This team does not exist")
public class TeamNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

}
