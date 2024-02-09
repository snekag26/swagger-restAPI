package com.App.Sneka.Project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserDetailedExceptionHandler {
	
	@ExceptionHandler(value = {UserDetailsException.class})
	public ResponseEntity<Object> handleUserDetailedExption
	(UserDetailsException handleUserDetailedExption)
	{
		UserDetailedException userDetailedException = new UserDetailedException(
				handleUserDetailedExption.getMessage(), 
				handleUserDetailedExption.getCause(), 
				HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(userDetailedException, HttpStatus.NOT_FOUND);
		
	}

}
