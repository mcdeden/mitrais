package com.mcdeden.exception;

public class DuplicationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DuplicationException(String message) {
        super(message);
    }

    public DuplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}