package com.anthony.currencyExchange.controllor;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anthony.currencyExchange.exception.CurrencyExchangeNotFoundException;
import com.anthony.currencyExchange.pojo.ExchangeValue;
import com.anthony.currencyExchange.repository.ExchangeValueRepository;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeControllor {
	
	@Autowired
	private Environment enviroument;
	
	@Autowired
	private ExchangeValueRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeControllor.class);

	@RequestMapping(path="/from/{from}/to/{to}", method= RequestMethod.GET)
	public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		ExchangeValue res = null;
		try {
			res = repository.findByFromAndTo(from, to);
		} catch(Exception e) {
			logger.error("Exception Happens While Trigger the Retrive Exchange Value Call" + e.getMessage());
			logger.error(e.getMessage(), e);
		}
		
		if(res == null) {
			throw new CurrencyExchangeNotFoundException("Currency Exchange Rate From: " + from + " To: " + to + " Not Found In DB, Please Correct Input And Try Again");
		}else {
			res.setPort(Integer.parseInt(enviroument.getProperty("local.server.port")));
			logger.info("{}", res);
		}
		
		return res;
	}
}
