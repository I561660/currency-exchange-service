package com.anthony.currencyExchange.controllor;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.anthony.currencyExchange.exception.CurrencyExchangeNotFoundException;
import com.anthony.currencyExchange.exception.StandardExceptionResponse;

@RestController
@ControllerAdvice
public class CustomizeExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception e, WebRequest request) {

		StandardExceptionResponse standardExceptionResponse = new StandardExceptionResponse(new Date(), e.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity<Object>(standardExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CurrencyExchangeNotFoundException.class)
	public final ResponseEntity<Object> handleCurrencyExchangeNotFoundException(Exception e, WebRequest request) {

		StandardExceptionResponse standardExceptionResponse = new StandardExceptionResponse(new Date(), e.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity<Object>(standardExceptionResponse, HttpStatus.NOT_FOUND);
	}
}
