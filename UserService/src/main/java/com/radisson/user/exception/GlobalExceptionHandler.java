package com.radisson.user.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiError> handleResourceNotFound(ResourceNotFoundException ex ,  HttpServletRequest request) {
		ApiError error= ApiError.builder()
				.timestamp(LocalDateTime.now())
				.message(ex.getMessage())	
				.statusCode(HttpStatus.NOT_FOUND.value())
				.error("Not Found")
				.path(request.getRequestURI())
				.build();
		
		return new ResponseEntity<ApiError>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleGlobalException(Exception ex, HttpServletRequest request){
		ApiError error= ApiError.builder()
								.timestamp(LocalDateTime.now())
								.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
								.error("Internal-Server-Error")
								.message(ex.getMessage())
								.path(request.getRequestURI())
								.build();
		
		return new ResponseEntity<ApiError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
