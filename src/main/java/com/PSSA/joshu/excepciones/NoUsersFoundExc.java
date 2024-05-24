package com.PSSA.joshu.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoUsersFoundExc extends RuntimeException {
	public NoUsersFoundExc ( String message ) {
		super( message );
	}
}
