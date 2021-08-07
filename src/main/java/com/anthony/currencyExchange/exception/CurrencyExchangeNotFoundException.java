package com.anthony.currencyExchange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CurrencyExchangeNotFoundException extends RuntimeException {

	public CurrencyExchangeNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrencyExchangeNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
