package com.sevar.user.service.exception;

public class UserNotFoundException extends RuntimeException 
{
	
	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super();
	}
	
	public UserNotFoundException(String message) {
		super(message);
	}
}
