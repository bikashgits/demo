package com.test.poc.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.test.poc.exception.DigitConverterException;
import com.test.poc.exception.InvalidDataException;
import com.test.poc.exception.InvalidDigitLevelException;


@ControllerAdvice
public class DigitConverterExceptionHandler extends ResponseEntityExceptionHandler{
	 
	   @ExceptionHandler({ Exception.class, 
			DigitConverterException.class,
			InvalidDigitLevelException.class,
			InvalidDataException.class
			})
	   protected ResponseEntity<ResponseError> handleException(RuntimeException ex, WebRequest request) {
	    new ResponseError(ex.getMessage(), ex.getMessage());
	    ResponseError responseError = new ResponseError(ex.getMessage(), ex.getMessage());
	    
	    HttpStatus status = null;
	    
	    if(ex instanceof InvalidDataException){
	    	status = HttpStatus.BAD_REQUEST;
	    }else{
	    	status = HttpStatus.INTERNAL_SERVER_ERROR;
	    }
	    
	    return new ResponseEntity<ResponseError>(responseError, status);
	   }
	   
	   
	  
	   
}
