package com.example.demo.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.services.exceptions.DatabaseException;
import com.example.demo.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException r, HttpServletRequest req) {

		String errMsg = "Resource not found";
		HttpStatus stts = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), stts.value(), errMsg, r.getMessage(), req.getRequestURI());

		return ResponseEntity.status(stts).body(err);
	}

	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> databaseException(DatabaseException e, HttpServletRequest req) {

		String errMsg = "Database error";
		HttpStatus stts = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), stts.value(), errMsg, e.getMessage(), req.getRequestURI());

		return ResponseEntity.status(stts).body(err);
	}
}
