package com.flight.simplesearch.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.flight.simplesearch.exception.InvalidSearchRequestException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ InvalidSearchRequestException.class })

	public final ResponseEntity<String> handleException(Exception exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);

	}
}
