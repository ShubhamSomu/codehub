package com.assignment.codehub.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;

import org.hibernate.exception.ConstraintViolationException;
import org.joda.time.LocalDateTime;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request,
			HttpStatus httpStatus) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, httpStatus);
	}

	@ExceptionHandler(CustomException.class)
	public final ResponseEntity<ExceptionResponse> handleCustomException(Exception ex, WebRequest request,
			HttpStatus httpStatus) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, httpStatus);
	}

	// @ExceptionHandler(MethodArgumentNotValidException.class)
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// Get all errors
/*		ex.getBindingResult().*/
		String errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getField()+" : "+x.getDefaultMessage())
				.collect(Collectors.toList()).stream().collect(Collectors.joining("\n"));
		ExceptionResponse exceptionresponse = new ExceptionResponse(errors, LocalDateTime.now(), errors);
		return new ResponseEntity<>(exceptionresponse, headers, status);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public final ResponseEntity<ExceptionResponse> handleConstraintsExceptions(Exception ex, WebRequest request,
			HttpStatus httpStatus) {

		if (ex instanceof ConstraintViolationException) {
			ConstraintViolationException jdbcEx = (ConstraintViolationException) ex;
			String errors = ex.getMessage() + "; SQL [" + jdbcEx.getSQL() + "]; constraint ["
					+ jdbcEx.getConstraintName() + "]";
			ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(), errors);
			return new ResponseEntity<>(exceptionResponse, httpStatus);
		}
		return null;

	}
	
	/*
	 * @ExceptionHandler({ ConstraintViolationException.class }) public
	 * ResponseEntity<Object> handleConstraintViolation(
	 * ConstraintViolationException ex, WebRequest request) { List<String> errors =
	 * new ArrayList<String>(); for (ConstraintViolation<?> violation : ex.) {
	 * errors.add(violation.getRootBeanClass().getName() + " " +
	 * violation.getPropertyPath() + ": " + violation.getMessage()); }
	 * 
	 * ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,
	 * ex.getLocalizedMessage(), errors); return new ResponseEntity<Object>(
	 * apiError, new HttpHeaders(), apiError.getStatus()); }
	 */

}
