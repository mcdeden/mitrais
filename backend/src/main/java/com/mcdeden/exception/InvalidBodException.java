package com.mcdeden.exception;

public class InvalidBodException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidBodException(String message) {
        super(message);
    }

    public InvalidBodException(String message, Throwable cause) {
        super(message, cause);
    }
}