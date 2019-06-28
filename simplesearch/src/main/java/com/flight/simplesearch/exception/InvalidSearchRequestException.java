package com.flight.simplesearch.exception;

public class InvalidSearchRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidSearchRequestException(String s) {
		super(s);
	}
}
