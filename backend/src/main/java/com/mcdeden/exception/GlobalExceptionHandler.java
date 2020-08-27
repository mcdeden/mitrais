package com.mcdeden.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mcdeden.model.response.ApiErrorResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<?> handleAllExceptions(Exception ex, WebRequest request) {
		ApiErrorResponseDTO errorResponse = new ApiErrorResponseDTO();

		errorResponse.setTimestamp(LocalDateTime.now().toString());
		errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setError(HttpStatus.INTERNAL_SERVER_ERROR);
		errorResponse.setMessage("Handling default exception: " + ex.getMessage());
		errorResponse.setDetails(null);
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ApiErrorResponseDTO errorResponse = new ApiErrorResponseDTO();
		List<String> details = new ArrayList<>();

		errorResponse.setTimestamp(LocalDateTime.now().toString());
		errorResponse.setStatus(status.value());
		errorResponse.setError(status);
		errorResponse.setMessage("Invalid Body Parameter");
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			details.add(error.getField() + ": " + error.getDefaultMessage());
		}
		errorResponse.setDetails(details);
		
		return new ResponseEntity<>(errorResponse, headers, status);
	}
	
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ApiErrorResponseDTO errorResponse = new ApiErrorResponseDTO();

		errorResponse.setTimestamp(LocalDateTime.now().toString());
		errorResponse.setStatus(status.value());
		errorResponse.setError(status);
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<>(errorResponse, status);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ApiErrorResponseDTO errorResponse = new ApiErrorResponseDTO();

		errorResponse.setTimestamp(LocalDateTime.now().toString());
		errorResponse.setStatus(status.value());
		errorResponse.setError(status);
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<>(errorResponse, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ApiErrorResponseDTO errorResponse = new ApiErrorResponseDTO();

		errorResponse.setTimestamp(LocalDateTime.now().toString());
		errorResponse.setStatus(status.value());
		errorResponse.setError(status);
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<>(errorResponse, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ApiErrorResponseDTO errorResponse = new ApiErrorResponseDTO();

		errorResponse.setTimestamp(LocalDateTime.now().toString());
		errorResponse.setStatus(status.value());
		errorResponse.setError(status);
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<>(errorResponse, status);
	}	

	@ExceptionHandler(DuplicationException.class)
	public final ResponseEntity<?> handleDuplicationException(DuplicationException ex, WebRequest request) {		
		ApiErrorResponseDTO errorResponse = new ApiErrorResponseDTO();

		errorResponse.setTimestamp(LocalDateTime.now().toString());
		errorResponse.setStatus(HttpStatus.CONFLICT.value());
		errorResponse.setError(HttpStatus.CONFLICT);
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
	}	
	
	@ExceptionHandler(InvalidBodException.class)
	public final ResponseEntity<?> handleInvalidBodException(InvalidBodException ex, WebRequest request) {		
		ApiErrorResponseDTO errorResponse = new ApiErrorResponseDTO();

		errorResponse.setTimestamp(LocalDateTime.now().toString());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setError(HttpStatus.BAD_REQUEST);
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
}
