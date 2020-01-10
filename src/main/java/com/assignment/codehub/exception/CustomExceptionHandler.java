package com.assignment.codehub.exception;

import java.util.stream.Collectors;

import org.joda.time.LocalDateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, 
			WebRequest request, HttpStatus httpStatus){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse,
				httpStatus);
	}
	
	
	@ExceptionHandler(CustomException.class)
	public final ResponseEntity<ExceptionResponse> handleCustomException(
			Exception ex, WebRequest request, HttpStatus httpStatus){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse,
				httpStatus);
	}
	
	//@ExceptionHandler(MethodArgumentNotValidException.class)
	 @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	                                                                  HttpHeaders headers,
	                                                                  HttpStatus status, WebRequest request) {
	        //Get all errors
	        String errors = ex.getBindingResult()
	                .getFieldErrors()
	                .stream()
	                .map(x -> x.getDefaultMessage())
	                .collect(Collectors.toList()).stream().collect(Collectors.joining("\n"));
	        ExceptionResponse exceptionresponse = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(), 
	        		errors);
	        return new ResponseEntity<>(exceptionresponse, headers, 
	        		status);
	 }

}
