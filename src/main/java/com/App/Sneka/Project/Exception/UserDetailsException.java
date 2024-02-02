package com.App.Sneka.Project.Exception;

public class UserDetailsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDetailsException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserDetailsException(String message) {
		super(message);
	}

}
