package com.example.springtask.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EntityResultRestExceptionHandler {

	@ExceptionHandler(EntityResultNotFoundException.class)
	public ResponseEntity<EntityResultErrorResponse> handleException(EntityResultErrorResponse exc) {

		EntityResultErrorResponse error = new EntityResultErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<EntityResultErrorResponse> handleException(Exception exc) {

		EntityResultErrorResponse error = new EntityResultErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}





